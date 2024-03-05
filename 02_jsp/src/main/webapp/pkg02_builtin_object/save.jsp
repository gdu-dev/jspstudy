<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
  // 요청 인코딩
  request.setCharacterEncoding("UTF-8");

  // 요청 파라미터
  String createdAt = request.getParameter("created-at");
  String title = request.getParameter("title");
  String contents = request.getParameter("contents");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

  <div><%=createdAt%></div>
  <div><%=title%></div>
  <div><%=contents%></div>

</body>
</html>