package model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import jakarta.servlet.http.HttpServletRequest;

public class MyInterfaceImpl implements MyInterface {

  @Override
  public String getDate(HttpServletRequest request) {
    request.setAttribute("date", DateTimeFormatter.ofPattern("yyyy. MM. dd.").format(LocalDate.now()));
    return "/view/date.jsp";
  }

  @Override
  public String getTime(HttpServletRequest request) {
    request.setAttribute("time", DateTimeFormatter.ofPattern("HH:mm:ss.SSS").format(LocalTime.now()));
    return "/view/time.jsp";
  }

  @Override
  public String getDateTime(HttpServletRequest request) {
    request.setAttribute("datetime", DateTimeFormatter.ofPattern("yyyy. MM. ss. HH:mm:ss.SSS").format(LocalDateTime.now()));
    return "/view/datetime.jsp";
  }

}
