package model;

import jakarta.servlet.http.HttpServletRequest;

public interface MyInterface {
  String getDate(HttpServletRequest request);
  String getTime(HttpServletRequest request);
  String getDateTime(HttpServletRequest request);
}
