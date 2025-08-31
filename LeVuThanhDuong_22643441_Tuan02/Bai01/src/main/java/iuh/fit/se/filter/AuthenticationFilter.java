package iuh.fit.se.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class AuthenticationFilter extends HttpFilter implements Filter  {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        res.setContentType ("text/html");
        PrintWriter out = res.getWriter ();
        if(req.getParameter("username").equals(this.getFilterConfig().getInitParameter("username"))
        && req.getParameter("password").equals(this.getFilterConfig().getInitParameter("password"))) {
            chain.doFilter (req, res);
        } else {
            out.println("Login Failed");
        }
        out.close ();
    }
}
