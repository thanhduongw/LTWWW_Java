package iuh.fit.se.servlet;

import iuh.fit.se.dao.DepartmentDAO;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("departments")
public class DepartmentServlet extends HttpServlet {
    private DepartmentDAO departmentDAO;

    @Override
    public void init(ServletConfig config) throws ServletException {
        departmentDAO = new DepartmentDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("departments", departmentDAO.findAll());
        req.getRequestDispatcher("departments.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
