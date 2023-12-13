<%@ page contentType="text/html;charset=utf-8"
	import="java.sql.*, delivery.*, java.util.Date"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<div align=right>
		<input type=button value="로그아웃" onclick="location.href='Logout.jsp'">
		<br>
		<br>
		<button onclick="location.href='CustomerStart.jsp'">홈으로</button>
		<br>
		<br>
	</div>
	<%
		request.setCharacterEncoding("utf-8");

		try {
			String SNAME = request.getParameter("SNAME");

			String ONUM = request.getParameter("ONUM");

			String MNAME = request.getParameter("MNAME");

			int OCNT = Integer.parseInt(request.getParameter("OCNT"));

			String REQUEST = request.getParameter("request");

			String CHAREASON = request.getParameter("chareason");

			MyDB.loadConnect();

			ResultSet rs1 = MyDB.selectMenuPrice(ONUM);
			rs1.next();
			int price = Integer.parseInt(rs1.getString("price"));

			int TP = price * OCNT; //총 가격 계산

			MyDB.updateOrderEdit(ONUM, MNAME, OCNT, TP, REQUEST); //주문테이블 수정

			MyDB.disconnect();

		} catch (Exception e) {
			e.printStackTrace();
		}

		response.sendRedirect("CustomerOrderTablePrint.jsp");
	%>
</body>
</html>