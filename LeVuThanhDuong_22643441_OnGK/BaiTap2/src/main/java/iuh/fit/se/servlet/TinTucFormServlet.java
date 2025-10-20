package iuh.fit.se.servlet;

import iuh.fit.se.dao.DanhMucDAO;
import iuh.fit.se.dao.TinTucDAO;
import iuh.fit.se.dao.impl.DanhMucDAOImpl;
import iuh.fit.se.dao.impl.TinTucDAOImpl;
import iuh.fit.se.model.DanhMuc;
import iuh.fit.se.model.TinTuc;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;
import java.util.Set;

@WebServlet("/them-tin-tuc")
public class TinTucFormServlet extends HttpServlet {
    @Resource(name = "jdbc/news")
    private DataSource dataSource;

    private DanhMucDAO danhMucDAO;
    private TinTucDAO tinTucDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        danhMucDAO = new DanhMucDAOImpl(dataSource);
        tinTucDAO = new TinTucDAOImpl(dataSource);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<DanhMuc> danhMucList = danhMucDAO.findAll();
        req.setAttribute("danhMucList", danhMucList);
        req.getRequestDispatcher("/views/tinTucForm.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String tieuDe = req.getParameter("tieuDe");
        String noiDungTT = req.getParameter("noiDungTT");
        String lienKet = req.getParameter("lienKet");
        String maDMStr = req.getParameter("maDM");

        // Tạo đối tượng TinTuc
        TinTuc tinTuc = new TinTuc();
        tinTuc.setTieuDe(tieuDe);
        tinTuc.setNoiDung(noiDungTT);
        tinTuc.setLienKet(lienKet);

        if (maDMStr != null && !maDMStr.isEmpty()) {
            DanhMuc danhMuc = danhMucDAO.findById(Integer.parseInt(maDMStr));
            tinTuc.setDanhMuc(danhMuc);
        }

        // Validate dữ liệu
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<TinTuc>> violations = validator.validate(tinTuc);

        if (!violations.isEmpty()) {
            // Có lỗi validation
            req.setAttribute("errors", violations);
            req.setAttribute("tinTuc", tinTuc);

            List<DanhMuc> danhMucList = danhMucDAO.findAll();
            req.setAttribute("danhMucList", danhMucList);

            req.getRequestDispatcher("/views/tinTucForm.jsp").forward(req, resp);
            return;
        }

        // Thêm tin tức vào database
        boolean success = tinTucDAO.save(tinTuc);

        if (success) {
            resp.sendRedirect(req.getContextPath() + "/danh-sach-tin-tuc?maDM=" + tinTuc.getDanhMuc().getMaDanhMuc());
        } else {
            req.setAttribute("error", "Thêm tin tức thất bại");
            List<DanhMuc> danhMucList = danhMucDAO.findAll();
            req.setAttribute("danhMucList", danhMucList);
            req.getRequestDispatcher("/views/tinTucForm.jsp").forward(req, resp);
        }
    }
}
