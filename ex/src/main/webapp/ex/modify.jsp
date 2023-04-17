<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h1>수정 화면</h1>
	<form method="post" action="${contextPath}/modify.do">
		<div>
			게시글번호 ${ex.exNo}
		</div>
		<div>
			<input type="text" name="exContent" value="${ex.exContent}">
		</div>
		<div>
			<input type="hidden" name="exNo" value="${ex.exNo}">
			<button>수정하기</button>
			<input type="button" value="목록보기" onclick="fnList()">
		</div>
	</form>
	<script>
		function fnList(){
			location.href = '${contextPath}/list.do';
		}
	</script>
	
</body>
</html>