<%@ page contentType="text/html;charset=utf-8"
	import="java.sql.*, delivery.*, java.util.Date"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<div style="align: right;">
		<input type=button value="로그아웃" onclick="location.href='Logout.jsp'">
		<br> <br>
		<button onclick="location.href='CustomerStart.jsp'">홈으로</button>
		<br> <br>
	</div>
	<%
		request.setCharacterEncoding("utf-8");

		try {
			String SNAME = request.getParameter("SNAME");

			String ONUM = request.getParameter("ONUM");

			String MNAME = request.getParameter("MNAME");

			String CHREASON = request.getParameter("chreason");

			String CID = request.getParameter("CID");

			MyDB.loadConnect();

			MyDB.insertCancelOrders(ONUM); //주문테이블을 취소로 옮김

			MyDB.updateCancelOrders(ONUM, CHREASON); //취소테이블에 취소사유와 취소날짜시간 삽입

			MyDB.deleteOrderbyOnum(ONUM); // 주문테이블에서 삭제

			MyDB.updateMenuOcntMinus(SNAME, MNAME); // 메뉴의 주문수량 -1 감소

			MyDB.updateCustomerOcntMinus(CID); //손님 아이디 필요

			MyDB.disconnect();

		} catch (Exception e) {
			e.printStackTrace();
		}

		response.sendRedirect("CustomerOrderTablePrint.jsp");
	%>
</body>
</html>