package iuh.fit.se.controller;

import iuh.fit.se.dao.ClazzDAO;
import iuh.fit.se.dao.StudentDAO;
import iuh.fit.se.dao.impl.ClazzDAOImpl;
import iuh.fit.se.dao.impl.StudentDAOImpl;
import iuh.fit.se.model.Student;
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

@WebServlet("/student")
public class StudentController extends HttpServlet {
    @Resource(name = "jdbc/sinhviendb")
    private DataSource dataSource;

    private ClazzDAO clazzDAO;
    private StudentDAO studentDAO;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        clazzDAO = new ClazzDAOImpl(dataSource);
        studentDAO = new StudentDAOImpl(dataSource);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Student> studentList = studentDAO.findAll();
        req.setAttribute("studentList", studentList);
        req.getRequestDispatcher("/student-list.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if(action!=null){
            switch (action) {
                case "add" ->{

                }
                case "delete" ->{
                    String id = req.getParameter("id");
                    if(id!=null){
                        studentDAO.delete(id);
                    }
                    resp.sendRedirect("student");
                }
            }
        }
    }
}
