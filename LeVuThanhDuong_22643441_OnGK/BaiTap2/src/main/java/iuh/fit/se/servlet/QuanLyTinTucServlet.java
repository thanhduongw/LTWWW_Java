package iuh.fit.se.servlet;

import iuh.fit.se.dao.TinTucDAO;
import iuh.fit.se.dao.impl.TinTucDAOImpl;
import iuh.fit.se.model.TinTuc;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;

@WebServlet("/quan-ly-tin-tuc")
public class QuanLyTinTucServlet extends HttpServlet {
    @Resource(name = "jdbc/news")
    private DataSource dataSource;

    private TinTucDAO tinTucDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        tinTucDAO = new TinTucDAOImpl(dataSource);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Xử lý xóa tin tức nếu có tham số maTT
        String maTTStr = req.getParameter("maTT");
        if (maTTStr != null && !maTTStr.isEmpty()) {
            int maTT = Integer.parseInt(maTTStr);
            tinTucDAO.delete(maTT);
        }

        // Lấy tất cả tin tức để hiển thị
        List<TinTuc> tinTucList = tinTucDAO.findAll();
        req.setAttribute("tinTucList", tinTucList);

        req.getRequestDispatcher("/views/quanLyForm.jsp").forward(req, resp);
    }
}