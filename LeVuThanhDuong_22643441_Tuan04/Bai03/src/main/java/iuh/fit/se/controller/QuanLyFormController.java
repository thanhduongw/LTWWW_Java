package iuh.fit.se.controller;

import iuh.fit.se.dao.DanhSachTinTucQuanLyDAO;
import iuh.fit.se.dao.impl.DanhSachTinTucQuanLyDAOImpl;
import iuh.fit.se.model.TinTuc;
import jakarta.servlet.http.HttpServlet;

import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import javax.sql.DataSource;
import java.io.IOException;

@WebServlet("/quan-ly")
public class QuanLyFormController extends HttpServlet {
    @Resource(name = "jdbc/quanlytintuc")
    private DataSource dataSource;
    private DanhSachTinTucQuanLyDAO dao;

    @Override
    public void init() { dao = new DanhSachTinTucQuanLyDAOImpl(dataSource); }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setAttribute("tintucs", dao.findAllDanhMuc());
        req.getRequestDispatcher("/views/quanLyForm.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        TinTuc tinTuc = new TinTuc();
        tinTuc.setId(req.getParameter("maTT"));
        if ("delete".equals(req.getParameter("action"))) {
            dao.deleteTinTuc(tinTuc);
        }
        resp.sendRedirect(req.getContextPath() + "/quan-ly");
    }
}
