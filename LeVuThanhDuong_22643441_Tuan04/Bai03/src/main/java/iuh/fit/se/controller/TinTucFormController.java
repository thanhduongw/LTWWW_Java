package iuh.fit.se.controller;

import iuh.fit.se.dao.DanhSachTinTucQuanLyDAO;
import iuh.fit.se.dao.impl.DanhSachTinTucQuanLyDAOImpl;
import iuh.fit.se.model.DanhMuc;
import iuh.fit.se.model.TinTuc;
import jakarta.servlet.annotation.WebServlet;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.*;
@WebServlet("/tin-tuc-form")
public class TinTucFormController extends HttpServlet {
    @Resource(name = "jdbc/quanlytintuc")
    private DataSource dataSource;
    private DanhSachTinTucQuanLyDAO dao;

    @Override
    public void init() { dao = new DanhSachTinTucQuanLyDAOImpl(dataSource); }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setAttribute("danhmucs", dao.findAllDanhMuc());
        req.getRequestDispatcher("/views/tinTucForm.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String maTT = req.getParameter("maTT");
        String tieuDe = req.getParameter("tieuDe");
        String noiDung = req.getParameter("noiDung");
        String lienKet = req.getParameter("lienKet");
        String maDM = req.getParameter("maDM");
        DanhMuc danhMuc = new DanhMuc();
        danhMuc.setId(maDM);

        Map<String, String> errors = new HashMap<>();
        if (maTT == null || maTT.isBlank()) errors.put("maTT", "Mã TT là bắt buộc");
        if (tieuDe == null || tieuDe.isBlank()) errors.put("tieuDe", "Tiêu đề là bắt buộc");
        if (lienKet == null || !lienKet.startsWith("http://"))
            errors.put("lienKet", "Liên kết phải bắt đầu bằng http://");
        if (noiDung == null || noiDung.isBlank() || noiDung.length() > 255)
            errors.put("noiDung", "Nội dung bắt buộc và <=255 ký tự");
        if (maDM == null || maDM.isBlank()) errors.put("maDM", "Danh mục bắt buộc");

        if (!errors.isEmpty()) {
            req.setAttribute("errors", errors);
            req.setAttribute("tinTuc", new TinTuc(maTT, tieuDe, noiDung, lienKet, danhMuc));
            req.setAttribute("danhmucs", dao.findAllDanhMuc());
            req.getRequestDispatcher("/views/tinTucForm.jsp").forward(req, resp);
            return;
        }

        TinTuc t = new TinTuc(maTT, tieuDe, noiDung, lienKet, danhMuc);
        if (dao.addTinTuc(t)) {
            resp.sendRedirect(req.getContextPath() + "/danh-sach?madm=" + maDM);
        } else {
            req.setAttribute("message", "Thêm thất bại (mã trùng?)");
            req.setAttribute("danhmucs", dao.findAllDanhMuc());
            req.getRequestDispatcher("/views/tinTucForm.jsp").forward(req, resp);
        }
    }
}
