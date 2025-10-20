package iuh.fit.se.servlet;


import iuh.fit.se.dao.DanhMucDAO;
import iuh.fit.se.dao.TinTucDAO;
import iuh.fit.se.dao.impl.DanhMucDAOImpl;
import iuh.fit.se.dao.impl.TinTucDAOImpl;
import iuh.fit.se.model.DanhMuc;
import iuh.fit.se.model.TinTuc;


import iuh.fit.se.dao.DanhMucDAO;
import iuh.fit.se.dao.TinTucDAO;
import iuh.fit.se.dao.impl.DanhMucDAOImpl;
import iuh.fit.se.dao.impl.TinTucDAOImpl;
import iuh.fit.se.model.DanhMuc;
import iuh.fit.se.model.TinTuc;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Set;

@WebServlet("/test-db")
public class TestDBServlet extends HttpServlet {
    @Resource(name = "jdbc/news")
    private DataSource dataSource;

    private DanhMucDAO danhMucDAO;
    private TinTucDAO tinTucDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        danhMucDAO = new DanhMucDAOImpl(dataSource);
        tinTucDAO = new TinTucDAOImpl(dataSource);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        out.println("<html><head><title>Test Database Connection</title></head><body>");
        out.println("<h1>Testing Database Connection</h1>");

        try {
            // Test 1: Kiểm tra kết nối cơ bản
            out.println("<h2>1. Testing Basic Connection...</h2>");
            try (Connection conn = dataSource.getConnection()) {
                if (conn != null && !conn.isClosed()) {
                    out.println("<p style='color: green;'>✓ Kết nối database THÀNH CÔNG</p>");

                    // Test 2: Kiểm tra bảng DANHMUC
                    out.println("<h2>2. Testing DANHMUC table...</h2>");
                    try (Statement stmt = conn.createStatement();
                         ResultSet rs = stmt.executeQuery("SELECT COUNT(*) as count FROM DANHMUC")) {
                        if (rs.next()) {
                            int count = rs.getInt("count");
                            out.println("<p>Số danh mục trong bảng DANHMUC: <strong>" + count + "</strong></p>");

                            // Hiển thị chi tiết danh mục
                            if (count > 0) {
                                out.println("<h3>Chi tiết danh mục:</h3>");
                                try (ResultSet rs2 = stmt.executeQuery("SELECT * FROM DANHMUC")) {
                                    out.println("<table border='1'><tr><th>MADM</th><th>TENDANHMUC</th><th>NGUOIQUANLY</th><th>GHICHU</th></tr>");
                                    while (rs2.next()) {
                                        out.println("<tr>");
                                        out.println("<td>" + rs2.getInt("MADM") + "</td>");
                                        out.println("<td>" + rs2.getString("TENDANHMUC") + "</td>");
                                        out.println("<td>" + rs2.getString("NGUOIQUANLY") + "</td>");
                                        out.println("<td>" + rs2.getString("GHICHU") + "</td>");
                                        out.println("</tr>");
                                    }
                                    out.println("</table>");
                                }
                            }
                        }
                    }

                    // Test 3: Kiểm tra bảng TINTUC
                    out.println("<h2>3. Testing TINTUC table...</h2>");
                    try (Statement stmt = conn.createStatement();
                         ResultSet rs = stmt.executeQuery("SELECT COUNT(*) as count FROM TINTUC")) {
                        if (rs.next()) {
                            int count = rs.getInt("count");
                            out.println("<p>Số tin tức trong bảng TINTUC: <strong>" + count + "</strong></p>");

                            // Hiển thị chi tiết tin tức
                            if (count > 0) {
                                out.println("<h3>Chi tiết tin tức:</h3>");
                                try (ResultSet rs2 = stmt.executeQuery("SELECT t.*, d.TENDANHMUC FROM TINTUC t LEFT JOIN DANHMUC d ON t.MADM = d.MADM")) {
                                    out.println("<table border='1'><tr><th>MATT</th><th>TIEUDE</th><th>NOIDUNGTT</th><th>LIENKET</th><th>MADM</th><th>TENDANHMUC</th></tr>");
                                    while (rs2.next()) {
                                        out.println("<tr>");
                                        out.println("<td>" + rs2.getInt("MATT") + "</td>");
                                        out.println("<td>" + rs2.getString("TIEUDE") + "</td>");
                                        out.println("<td>" + (rs2.getString("NOIDUNGTT") != null ?
                                                (rs2.getString("NOIDUNGTT").length() > 50 ?
                                                        rs2.getString("NOIDUNGTT").substring(0, 50) + "..." :
                                                        rs2.getString("NOIDUNGTT")) : "NULL") + "</td>");
                                        out.println("<td>" + rs2.getString("LIENKET") + "</td>");
                                        out.println("<td>" + rs2.getInt("MADM") + "</td>");
                                        out.println("<td>" + rs2.getString("TENDANHMUC") + "</td>");
                                        out.println("</tr>");
                                    }
                                    out.println("</table>");
                                }
                            }
                        }
                    }
                } else {
                    out.println("<p style='color: red;'>✗ Kết nối database THẤT BẠI</p>");
                }
            }

            // Test 4: Kiểm tra DAO
            out.println("<h2>4. Testing DAO Layer...</h2>");
            try {
                List<DanhMuc> danhMucList = danhMucDAO.findAll();
                out.println("<p>DanhMucDAO.getAllDanhMuc(): " + danhMucList.size() + " items</p>");

                List<TinTuc> tinTucList = tinTucDAO.findAll();
                out.println("<p>TinTucDAO.getAllTinTuc(): " + tinTucList.size() + " items</p>");

                if (!tinTucList.isEmpty()) {
                    out.println("<h3>Dữ liệu từ TinTucDAO:</h3>");
                    out.println("<table border='1'><tr><th>MATT</th><th>TIEUDE</th><th>NOIDUNGTT</th><th>LIENKET</th><th>MADM</th></tr>");
                    for (TinTuc tt : tinTucList) {
                        out.println("<tr>");
                        out.println("<td>" + tt.getMaTinTuc() + "</td>");
                        out.println("<td>" + tt.getTieuDe() + "</td>");
                        out.println("<td>" + (tt.getNoiDung() != null ?
                                (tt.getNoiDung().length() > 50 ?
                                        tt.getNoiDung().substring(0, 50) + "..." :
                                        tt.getNoiDung()) : "NULL") + "</td>");
                        out.println("<td>" + tt.getLienKet() + "</td>");
                        out.println("<td>" + tt.getDanhMuc().getMaDanhMuc() + "</td>");
                        out.println("</tr>");
                    }
                    out.println("</table>");
                }
            } catch (Exception e) {
                out.println("<p style='color: red;'>✗ DAO Test FAILED: " + e.getMessage() + "</p>");
                e.printStackTrace(out);
            }

        } catch (Exception e) {
            out.println("<p style='color: red;'>✗ Có lỗi xảy ra: " + e.getMessage() + "</p>");
            e.printStackTrace(out);
        }

        out.println("</body></html>");
    }
}