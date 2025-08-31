package iuh.fit.se;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;

@WebServlet(name = "uploadMultiFileServlet", urlPatterns = {"/upload"})
@MultipartConfig(
        fileSizeThreshold = 1024*1024,// 1 MB Nếu kích thước file upload lơn hơn threshold sẽ được ghi trực tiếp vào ổ đĩa thay vì lưu ở memory đệm.
        maxFileSize = 1024*1024*5, // 5 MB Kích thước tối da của file được upload.
        maxRequestSize = 1024*1024*10 // 10 MB Kích thước tối đa cho một request.
)
public class UploadMultiFileServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public UploadMultiFileServlet(){}
    private static final String UPLOAD_DIR="uploads";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uploadPath = getServletContext().getRealPath("") + UPLOAD_DIR;

        File uploadDir = new File(uploadPath);
        if(!uploadDir.exists()){
            uploadDir.mkdir();
        }

        for (Part part : req.getParts()) {
            String filename = getFileName(part);
            if(filename!=null&& !filename.isEmpty()){
                part.write(uploadPath + File.separator + filename);
            }
            resp.setContentType("text/html;charset=utf-8");
            resp.getWriter().println("Upload successfully to " +uploadPath);
        }
    }
    private String getFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String item : items) {
            if (item.trim().startsWith("filename")) {
                return item.substring(item.indexOf("=") + 2, item.length() - 1);
            }
        }
        return null;
    }
}