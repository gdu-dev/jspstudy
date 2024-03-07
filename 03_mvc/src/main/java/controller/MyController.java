package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.MyInterface;
import model.MyInterfaceImpl;

public class MyController extends HttpServlet {
  
  private static final long serialVersionUID = 1L;
  
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  
    /* 요청 UTF-8 인코딩 */
    request.setCharacterEncoding("UTF-8");
    
    /* 어떤 요청인지 확인 (URLMapping 확인) */
    String requestURI = request.getRequestURI();    /* http://localhost:8080/mvc/getDate.do */
    String contextPath = request.getContextPath();  /* /mvc */
    String urlMapping = requestURI.substring(requestURI.indexOf(contextPath) + contextPath.length());
    
    /* MyInterface 타입의 MyInterfaceImpl 객체 생성 */
    MyInterface myInterface = new MyInterfaceImpl();
    
    /* 메소드 호출 결과(view 경로)를 저장할 변수 */
    String path = null;
    
    /* 요청에 따른 메소드 호출 */
    switch(urlMapping) {
    case "/getDate.do":
      path = myInterface.getDate(request);
      System.out.println(request.getAttribute("date"));
      break;
    case "/getTime.do":
      path = myInterface.getTime(request);
      System.out.println(request.getAttribute("time"));
      break;
    case "/getDateTime.do":
      path = myInterface.getDateTime(request);
      System.out.println(request.getAttribute("datetime"));
      break;
    }
    
    System.out.println(path);
  
  }
  
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
  }

}
