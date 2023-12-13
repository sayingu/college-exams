<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" import="java.sql.*, delivery.*, util.*"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String sname = request.getParameter("sname");
		MyDB.loadConnect();
		ResultSet rs = MyDB.ShowStoreMenu(sname);
		request.setAttribute("title", "** '" + sname + "'의 메뉴보기 **");
		request.setAttribute("RS", rs);
	%>
	<jsp:forward page="ShowStoreMenuList.jsp" />;
</body>
</html>

