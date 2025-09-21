package iuh.fit.se.controller;

import iuh.fit.se.dao.DanhSachTinTucQuanLyDAO;
import iuh.fit.se.dao.impl.DanhSachTinTucQuanLyDAOImpl;
import iuh.fit.se.model.TinTuc;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "danhSachTinTucController", urlPatterns = "/danh-sach-tin-tuc")
public class DanhSachTinTucController extends HttpServlet {
    @Resource(name = "jdbc/quanlydanhmuc")
    private DataSource dataSource;

    private DanhSachTinTucQuanLyDAO dao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        this.dao = new DanhSachTinTucQuanLyDAOImpl(this.dataSource);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String madm = req.getParameter("MADM");
        List<TinTuc> list = dao.findAllTinTucByDanhMuc(madm);
        req.setAttribute("tinTucs", list);
        req.setAttribute("danhmucs", dao.findAllDanhMuc());
        req.getRequestDispatcher("/views/danhSachTinTuc.jsp").forward(req, resp);
    }
}
