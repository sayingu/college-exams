<%@ page contentType="text/html;charset=utf-8"
	import="java.sql.*, delivery.*, java.util.Date"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");

		String SNAME = (String) request.getParameter("sname");

		MyDB.loadConnect();

		ResultSet rs = MyDB.selectMyStoreOrders(SNAME);

		request.setAttribute("title", SNAME + "가게 주문내역");
		request.setAttribute("RS", rs);
		request.getRequestDispatcher("ShowStoreOrderList.jsp").forward(request, response);
	%>
</body>
</html>