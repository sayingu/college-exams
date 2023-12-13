<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" import="java.sql.*, delivery.*, util.*"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>classification</title>
</head>
<body>
	<div align=right>
		<input type=button value="로그아웃" onclick="location.href='Logout.jsp'">
		<br>
		<br>
		<button onclick="location.href='FindMenubySIDforAdmin.jsp'">홈으로</button>
		<br>
		<br>
	</div>
	분류로 검색
	<br>
	<%
		String classification = request.getParameter("classification");
		MyDB.loadConnect();
		ResultSet rs = MyDB.selectStorebyClassification(classification);
		request.setAttribute("title", "** '" + classification + "' 카테고리 검색 결과 **");
		request.setAttribute("RS", rs);
	%>
	<jsp:forward page="ShowStoreList.jsp" />;
</body>
</html>
