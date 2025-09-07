package iuh.fit.se;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/registration-form")
public class RegistrationForm extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public RegistrationForm() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().append("Served at: ").append(req.getContextPath());

        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String dob = req.getParameter("dob");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String gender = req.getParameter("gender");
        String address = req.getParameter("address");
        String city = req.getParameter("city");
        String pinCode = req.getParameter("pinCode");
        String state = req.getParameter("state");
        String country = req.getParameter("country");
        String hobbies = req.getParameter("hobbies");
        String course = req.getParameter("course");

        Student student = new Student();
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setDob(LocalDate.parse(dob));
        student.setEmail(email);
        student.setPhone(phone);
        student.setAddress(address);
        student.setCity(city);
        student.setPinCode(pinCode);
        student.setState(state);
        student.setCountry(country);
        student.setHobbies(hobbies);
        student.setCourse(course);

        req.setAttribute("student", student);

        RequestDispatcher rd = req.getRequestDispatcher("result-form.jsp");
        rd.forward(req, resp);


    }
}
