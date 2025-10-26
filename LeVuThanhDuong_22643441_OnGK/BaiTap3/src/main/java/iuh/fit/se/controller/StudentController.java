package iuh.fit.se.controller;

import iuh.fit.se.dao.ClazzDAO;
import iuh.fit.se.dao.StudentDAO;
import iuh.fit.se.dao.impl.ClazzDAOImpl;
import iuh.fit.se.dao.impl.StudentDAOImpl;
import iuh.fit.se.model.Clazz;
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
import java.util.ArrayList;
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
        String action = req.getParameter("action");
        if (action == null) action = "list";

        switch (action) {
            case "add" -> {
                List<Clazz> clazzList = clazzDAO.findAll();
                req.setAttribute("clazzList", clazzList);
                req.getRequestDispatcher("/view/student-form.jsp").forward(req, resp);
            }

            case "edit" -> {
                String id = req.getParameter("id");
                Student student = studentDAO.findById(id);
                req.setAttribute("student", student);
                List<Clazz> clazzList = clazzDAO.findAll();
                req.setAttribute("clazzList", clazzList);
                req.getRequestDispatcher("/view/student-form.jsp").forward(req, resp);
            }

            case "detail" -> {
                String id = req.getParameter("id");
                Student student = studentDAO.findById(id);
                req.setAttribute("student", student);
                req.getRequestDispatcher("/view/student-detail.jsp").forward(req, resp);
            }

            default -> { // "list"
                List<Clazz> clazzList = clazzDAO.findAll();
                req.setAttribute("clazzList", clazzList);

                String name = req.getParameter("name");
                String clazzId = req.getParameter("clazzId");
                List<Student> studentList = new ArrayList<>();

//                if (clazzId != null && !clazzId.trim().isEmpty() && !"ALL".equals(clazzId)) {
//                    Clazz selectedClazz = clazzDAO.findById(clazzId);
//                    if (selectedClazz != null) {
//                        studentList = studentDAO.findByClassName(selectedClazz.getName());
//                    } else {
//                        studentList = studentDAO.findAll();
//                    }
//                }
//                else
//                    studentList = studentDAO.findAll();

                if (name != null && !name.trim().isEmpty()) {
                    studentList = studentDAO.search(name);

                } else {
                    studentList = studentDAO.findAll();
                }

                req.setAttribute("studentList", studentList);
                req.setAttribute("selectedClazzId", clazzId);
                req.getRequestDispatcher("/view/student-list.jsp").forward(req, resp);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) action = "";

        switch (action) {
            case "add", "update" -> {
                String id = req.getParameter("mssv");
                String name = req.getParameter("hoten");
                String dob = req.getParameter("ngaysinh");
                double score = Double.parseDouble(req.getParameter("diem"));
                String classId = req.getParameter("clazzId");
                Clazz clazz = null;
                if(classId != null && !classId.isEmpty()){
                    clazz = clazzDAO.findById(classId);
                }

                Student student = new Student();
                student.setId(id);
                student.setName(name);
                student.setDob(java.time.LocalDate.parse(dob));
                student.setScore(score);
                student.setClazz(clazz);

                if ("add".equals(action))
                    studentDAO.add(student);
                else
                    studentDAO.update(student);

                resp.sendRedirect("student");
            }

            case "delete" -> {
                String id = req.getParameter("id");
                if (id != null && !id.isEmpty()) {
                    studentDAO.delete(id);
                }
                resp.sendRedirect("student");
            }

            default -> resp.sendRedirect("student");
        }
    }
}