package iuh.fit.se.controller;

import iuh.fit.se.dao.ClazzDAO;
import iuh.fit.se.dao.impl.ClazzDAOImpl;
import iuh.fit.se.model.Clazz;
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

@WebServlet("/clazz")
public class ClazzController extends HttpServlet {

    @Resource(name = "jdbc/sinhviendb")
    private DataSource dataSource;
    private ClazzDAO clazzDAO;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        clazzDAO = new ClazzDAOImpl(dataSource);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) action = "list";

        switch (action) {
            case "add" -> {
                req.getRequestDispatcher("/view/clazz-form.jsp").forward(req, resp);
            }
            case "edit" -> {
                String id = req.getParameter("id");
                Clazz clazz = clazzDAO.findById(id);
                req.setAttribute("clazz", clazz);
                req.getRequestDispatcher("/view/clazz-form.jsp").forward(req, resp);
            }
            default -> { // "list"
                List<Clazz> clazzList = clazzDAO.findAll();
                req.setAttribute("clazzList", clazzList);
                req.getRequestDispatcher("/view/clazz-list.jsp").forward(req, resp);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) action = "";

        switch (action) {
            case "add", "update" -> {
                String id = req.getParameter("malop");
                String name = req.getParameter("tenlop");

                Clazz clazz = new Clazz();
                clazz.setId(id);
                clazz.setName(name);

                if ("add".equals(action)) {
                    clazzDAO.add(clazz);
                } else {
                    clazzDAO.update(clazz);
                }

                resp.sendRedirect("clazz");
            }
            case "delete" -> {
                String id = req.getParameter("id");
                if (id != null && !id.isEmpty()) {
                    clazzDAO.delete(id);
                }
                resp.sendRedirect("clazz");
            }
            default -> resp.sendRedirect("clazz");
        }
    }
}