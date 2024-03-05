<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<%
  request.setCharacterEncoding("UTF-8");
  String title = request.getParameter("title");
%>
<title><%=title%></title>

<%
  String contextPath = request.getContextPath();
  long timestamp = System.currentTimeMillis();
%>

<!-- custom css -->
<link rel="stylesheet" href="<%=contextPath%>/assets/css/header.css?dt=<%=timestamp%>">
<link rel="stylesheet" href="<%=contextPath%>/assets/css/body.css?dt=<%=timestamp%>">
<link rel="stylesheet" href="<%=contextPath%>/assets/css/footer.css?dt=<%=timestamp%>">

</head>
<body>

  <div class="header-wrap">
    <div>
      <a href="<%=contextPath%>/pkg03_include/main1.jsp">main1</a>
      <a href="<%=contextPath%>/pkg03_include/main2.jsp">main2</a>
    </div>
  </div>
  
  <div class="body-wrap">