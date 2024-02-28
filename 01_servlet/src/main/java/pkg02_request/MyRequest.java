package pkg02_request;

import java.io.IOException;
import java.util.Optional;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MyRequest extends HttpServlet {
  
  private static final long serialVersionUID = 1L;
       
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    // 1. 요청 UTF-8 인코딩
    request.setCharacterEncoding("UTF-8");
    
    // 2. 요청 파라미터
    //  1) 모든 파라미터는 String 타입이다.
    //  2) 파라미터가 없으면 null 이다.
    //  3) 파라미터의 값이 없으면 ""(빈 문자열) 이다.
    
    /* if 문을 이용한 [null & 빈 문자열] 처리 */
    String strNumber = request.getParameter("number");
    int number = 0;
    if(strNumber != null && !strNumber.isEmpty())
      number = Integer.parseInt(strNumber);
    System.out.println(number);
    
    /* Optional<T> 클래스를 이용한 [null & 빈 문자열] 처리 */
    String strNumber2 = request.getParameter("number2");
    Optional<String> opt = Optional.ofNullable(strNumber2);
    double number2 = Double.parseDouble(opt.orElse("0").isEmpty() ? "0" : strNumber2);
    System.out.println(number2);
    
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
  }

}
