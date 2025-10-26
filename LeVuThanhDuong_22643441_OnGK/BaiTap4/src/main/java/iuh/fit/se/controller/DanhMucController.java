package iuh.fit.se.controller;

import iuh.fit.se.dao.DanhMucDAO;
import iuh.fit.se.dao.impl.DanhMucDAOImpl;
import iuh.fit.se.model.DanhMuc;
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

@WebServlet("/danhmuc")
public class DanhMucController extends HttpServlet {

    @Resource(name = "jdbc/news")
    private DataSource dataSource;
    private DanhMucDAO danhMucDAO;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        danhMucDAO = new DanhMucDAOImpl(dataSource);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<DanhMuc> list = danhMucDAO.findAll();
        req.setAttribute("danhMucList", list);
        req.getRequestDispatcher("/view/danhmuc-list.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "delete"->{
                String id = req.getParameter("id");
                if(id!=null && !id.isEmpty()){
                    danhMucDAO.delete(id);
                    resp.sendRedirect("danhmuc");
                }
            }
            case "save"->{
                String maDM = req.getParameter("maDM");
                String tenDanhMuc = req.getParameter("tenDanhMuc");
                String nguoiQuanLy = req.getParameter("nguoiQuanLy");
                String ghiChu = req.getParameter("ghiChu");

                DanhMuc danhMuc = new DanhMuc(maDM, tenDanhMuc, nguoiQuanLy, ghiChu);
                danhMucDAO.save(danhMuc);
                resp.sendRedirect("danhmuc");
            }
        }
    }
}
