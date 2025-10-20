package iuh.fit.se.servlet;

import iuh.fit.se.dao.DanhMucDAO;
import iuh.fit.se.dao.TinTucDAO;
import iuh.fit.se.dao.impl.DanhMucDAOImpl;
import iuh.fit.se.dao.impl.TinTucDAOImpl;
import iuh.fit.se.model.DanhMuc;
import iuh.fit.se.model.TinTuc;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;

@WebServlet("/danh-sach-tin-tuc")
public class DanhSachTinTucServlet extends HttpServlet {

    @Resource(name = "jdbc/news")
    private DataSource dataSource;

    private TinTucDAO tinTucDAO;
    private DanhMucDAO danhMucDAO;

    @Override
    public void init(ServletConfig config) throws ServletException {
        tinTucDAO = new TinTucDAOImpl(dataSource);
        danhMucDAO = new DanhMucDAOImpl(dataSource);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String maDMStr = req.getParameter("maDM");
        int selectedMaDM = 0;

        // Lấy danh sách danh mục
        List<DanhMuc> danhMucList = danhMucDAO.findAll();
        req.setAttribute("danhMucList", danhMucList);
        List<TinTuc> tinTucList;
        // Nếu có mã danh mục, lấy tin tức theo danh mục
        if (maDMStr != null && !maDMStr.isEmpty()) {
            try {
                selectedMaDM = Integer.parseInt(maDMStr);
                tinTucList = tinTucDAO.findByDanhMuc(selectedMaDM);
                req.setAttribute("selectedMaDM", selectedMaDM);
            } catch (NumberFormatException e) {
                // Nếu mã danh mục không hợp lệ, lấy tất cả tin tức
                tinTucList = tinTucDAO.findAll();
                req.setAttribute("error", "Mã danh mục không hợp lệ");
            }
        } else {
            // Lấy tất cả tin tức
            tinTucList = tinTucDAO.findAll();
        }
        req.setAttribute("tinTucList", tinTucList);
        req.getRequestDispatcher("/views/danhSachTinTuc.jsp").forward(req, resp);
    }

}
