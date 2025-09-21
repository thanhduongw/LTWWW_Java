package iuh.fit.se.controller;

import iuh.fit.se.dao.DienThoaiDAO;
import iuh.fit.se.dao.impl.DienThoaiDAOImpl;
import iuh.fit.se.model.DienThoai;
import iuh.fit.se.model.NhaCungCap;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import javax.sql.DataSource;
import java.io.File;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/dienthoais", "/dienthoai-form"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024,
        maxFileSize = 5 * 1024 * 1024,
        maxRequestSize = 10 * 1024 * 1024)
public class DienThoaiController extends HttpServlet {
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
        String servletPath = req.getServletPath();

        if ("/dienthoai-form".equals(servletPath)) {
            // Hiển thị form thêm mới
            req.getRequestDispatcher("views/dienthoai/form.jsp").forward(req, resp);
        } else {
            // Danh sách điện thoại
            List<DienThoai> list = dienThoaiDAO.findAll();
            req.setAttribute("dienthoais", list);
            req.getRequestDispatcher("views/dienthoai/index.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String servletPath = req.getServletPath();

        if ("/dienthoai-form".equals(servletPath)) {
            handleCreate(req, resp);
        } else {
            doGet(req, resp);
        }
    }

    private void handleCreate(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String id = req.getParameter("id");
        String name = req.getParameter("ten");
        int namSanXuat = Integer.parseInt(req.getParameter("nam"));
        String cauHinh = req.getParameter("cauHinh");
        String nccId = req.getParameter("nccId");

        // upload ảnh
        Part filePart = req.getPart("image");
        String fileName = null;
        if (filePart != null && filePart.getSize() > 0) {
            String submittedFileName = filePart.getSubmittedFileName();
            String ext = submittedFileName.substring(submittedFileName.lastIndexOf(".")).toLowerCase();
            if (ext.equals(".png") || ext.equals(".jpg") || ext.equals(".jpeg")) {
                String uploads = req.getServletContext().getRealPath("/uploads");
                File uploadsDir = new File(uploads);
                if (!uploadsDir.exists()) uploadsDir.mkdirs();
                fileName = System.currentTimeMillis() + "_" + submittedFileName;
                filePart.write(uploads + File.separator + fileName);
            }
        }

        DienThoai dt = new DienThoai(
                id, name, namSanXuat, cauHinh, fileName,
                new NhaCungCap(nccId, null, null, null)
        );

        dienThoaiDAO.add(dt);
        resp.sendRedirect(req.getContextPath() + "/dienthoais");
    }
}
