package pkg06_upload;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.Collection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2,
                 maxFileSize = 1024 * 1024 * 5,
                 maxRequestSize = 1024 * 1024 * 50)

public class Upload extends HttpServlet {
  
  private static final long serialVersionUID = 1L;

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    // 업로드 경로 (톰캣 내부 경로)
    String uploadPath = request.getServletContext().getRealPath("upload");
    File uploadDir = new File(uploadPath);
    if(!uploadDir.exists()) {
      uploadDir.mkdirs();
    }
    
    String originalFilename = null;
    String filesystemName = null;

    // 첨부된 파일 정보
    Collection<Part> parts = request.getParts();
    for(Part part : parts) {
      if(part.getHeader("Content-Disposition").contains("filename")) {
        if(part.getSize() > 0) {
          originalFilename = part.getSubmittedFileName();
        }
      }
      if(originalFilename != null) {
        int point = originalFilename.lastIndexOf(".");
        String extName = originalFilename.substring(point);      // .jpg
        String fileName = originalFilename.substring(0, point);  // anmal1
        filesystemName = fileName + "_" + System.currentTimeMillis() + extName;
      }
      if(filesystemName != null) {
        part.write(uploadPath + File.separator + filesystemName);
      }
    }
    
    // 응답
    response.setContentType("text/html; charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<div><a href=\"/servlet/pkg06_upload/NewFile.html\">입력폼으로 돌아가기</a></div>");
    out.println("<hr>");
    out.println("<div>첨부파일명 : " + originalFilename + "</div>");
    out.println("<div>저장파일명 : " + filesystemName + "</div>");
    out.println("<div>저장경로 : " + uploadPath + "</div>");
    out.println("<hr>");
    
    File[] files = uploadDir.listFiles();
    for(File file : files) {
      String fileName1 = file.getName();  // 파일명_1234567890.jpg
      String ext = fileName1.substring(fileName1.lastIndexOf("."));
      String fileName2 = fileName1.substring(0, fileName1.lastIndexOf("_"));
      out.println("<div><a href=\"/servlet/download?filename=" + URLEncoder.encode(fileName1, "UTF-8") + "\">" + fileName2 + ext + "</a></div>");
    }
    
    out.flush();
    out.close();
    
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
  }

}
