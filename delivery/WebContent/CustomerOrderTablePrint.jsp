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

		String CID = session.getAttribute("id").toString();

		;

		MyDB.loadConnect();

		ResultSet rs = MyDB.selectMyOrders(CID);

		request.setAttribute("title", "고객 주문내역");
		request.setAttribute("RS", rs);

		request.getRequestDispatcher("ShowCustomerOrderList.jsp").forward(request, response);
	%>
</body>
</html>