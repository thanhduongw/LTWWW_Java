package iuh.fit.se.controller;

import iuh.fit.se.daos.DienThoaiDAO;
import iuh.fit.se.daos.NhaCungCapDAO;
import iuh.fit.se.daos.impl.DienThoaiDAOImpl;
import iuh.fit.se.daos.impl.NhaCungCapDAOImpl;
import iuh.fit.se.models.DienThoai;
import iuh.fit.se.models.NhaCungCap;
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

@WebServlet("/dienthoai")
public class DienThoaiController extends HttpServlet {
    @Resource(name = "jdbc/quanlydienthoai")
    private DataSource dataSource;
    private DienThoaiDAO dienThoaiDAO;
    private NhaCungCapDAO nhaCungCapDAO;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        this.dienThoaiDAO = new DienThoaiDAOImpl(dataSource);
        this.nhaCungCapDAO = new NhaCungCapDAOImpl(dataSource);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<DienThoai> dienThoaiList = dienThoaiDAO.findAll();
        List<NhaCungCap> nhaCungCapList = nhaCungCapDAO.findAll();
        req.setAttribute("nhaCungCapList", nhaCungCapList);
        String maNCC = req.getParameter("maNCC");

        if(maNCC != null && !maNCC.trim().isEmpty() && !maNCC.equals("ALL")) {
            NhaCungCap selectedNCC = nhaCungCapDAO.findById(Integer.parseInt(maNCC));
            if(selectedNCC != null) {
                dienThoaiList = dienThoaiDAO.findByMaNCC(Integer.parseInt(maNCC));
            } else {
                dienThoaiList = dienThoaiDAO.findAll();
            }
        }

        req.setAttribute("dienThoaiList", dienThoaiList);
        req.getRequestDispatcher("/views/dienthoai-list.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
