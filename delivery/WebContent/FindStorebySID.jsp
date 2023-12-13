<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" import="java.sql.*, delivery.*, util.*"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>store name</title>
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
	<%
		String SID;
		SID = Convert.getStringFromString(request.getParameter("SID"));

		MyDB.loadConnect();
		ResultSet rs = MyDB.selectStorebySID(SID);
		request.setAttribute("title", "** '" + SID + "' 검색 결과 **");
		request.setAttribute("RS", rs);
	%>
	<jsp:forward page="ShowStoreList.jsp" />;
</body>
</html>