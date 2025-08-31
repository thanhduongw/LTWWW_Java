package iuh.fit.se.levuthanhduong_22643441_tuan01;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String gender = req.getParameter("gender");
        String country = req.getParameter("country");
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<h2>Thông tin đăng ký:</h2>");
        out.println("Tên: " + name + "<br/>");
        out.println("Giới tính: " + gender + "<br/>");
        out.println("Quốc gia: " + country + "<br/>");
        out.println("<br/>\n" + "  <a href=\"index.jsp\">Quay lại</a>");
    }
}
