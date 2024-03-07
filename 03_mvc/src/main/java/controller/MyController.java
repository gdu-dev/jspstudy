package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MyController extends HttpServlet {
  
  private static final long serialVersionUID = 1L;
  
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  
    /* 요청 UTF-8 인코딩 */
    request.setCharacterEncoding("UTF-8");
    
    /* 어떤 요청인지 확인 (URLMapping 확인) */
    String requestURI = request.getRequestURI();    /* http://localhost:8080/mvc/getDate.do */
    String contextPath = request.getContextPath();  /* /mvc */
    String urlMapping = requestURI.substring(requestURI.indexOf(contextPath) + contextPath.length());
    
    System.out.println(urlMapping);
  
  }
  
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
  }

}
