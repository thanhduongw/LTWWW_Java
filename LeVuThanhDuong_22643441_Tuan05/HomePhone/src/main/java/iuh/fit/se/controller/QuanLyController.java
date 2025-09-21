package iuh.fit.se.controller;

import iuh.fit.se.dao.DienThoaiDAO;
import iuh.fit.se.dao.impl.DienThoaiDAOImpl;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import javax.sql.DataSource;
import java.io.IOException;

@WebServlet(urlPatterns = "/quanly")
public class QuanLyController extends HttpServlet {
    @Resource(name = "jdbc/quanlydienthoai")
    private DataSource ds;

    private DienThoaiDAO dienThoaiDAO;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        dienThoaiDAO = new DienThoaiDAOImpl(ds);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setAttribute("dienthoais", dienThoaiDAO.findAll());
        req.getRequestDispatcher("views/dienthoai/quanly.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String action = req.getParameter("action");
        if ("delete".equals(action)) {
            String id = req.getParameter("id");
            dienThoaiDAO.delete(id);
        }
        resp.sendRedirect(req.getContextPath() + "/quanly");
    }
}
