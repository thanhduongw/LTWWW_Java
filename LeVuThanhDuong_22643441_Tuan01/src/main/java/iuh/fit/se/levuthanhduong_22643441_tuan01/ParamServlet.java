package iuh.fit.se.levuthanhduong_22643441_tuan01;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class ParamServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        // Lấy giá trị init-param
        out.println("<h2>" + getServletConfig().getInitParameter("message") + "</h2>");
        out.println("<h2>" + getServletContext().getInitParameter("username") + "</h2>");
        out.println("<br/>\n" + "  <a href=\"index.jsp\">Quay lại</a>");

    }
}
