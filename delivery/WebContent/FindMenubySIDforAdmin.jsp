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
	<%
		String SID;
		SID = Convert.getStringFromString(session.getAttribute("id").toString());

		MyDB.loadConnect();
		ResultSet rs = MyDB.selectMenubySID(SID);
		request.setAttribute("title", "** '" + SID + "' 시작 화면 **");
		request.setAttribute("RS", rs);
	%>

	<jsp:forward page="ShowStoreAdminMenuList.jsp" />;
</body>
</html>