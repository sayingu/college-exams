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

		try {
			String SNAME = request.getParameter("SNAME");

			String MNAME = request.getParameter("MNAME");

			int OCNT = Integer.parseInt(request.getParameter("OCNT"));

			String REQUEST = request.getParameter("request");

			MyDB.loadConnect();

			ResultSet rs1 = MyDB.selectMenuPrice(SNAME, MNAME);
			rs1.next();
			int price = rs1.getInt("price");

			int TP = price * OCNT; //총 가격 계산

			float SALE = MyDB.getSale(MNAME);

			int DAMOUT = 0;

			if (SALE != 0) {
				DAMOUT = (int) (price * SALE);
			} else {
				DAMOUT = 0;
			}

			String CID = session.getAttribute("id").toString(); // CID 가져와야해요!!

			MyDB.insertOrder(CID, SNAME, MNAME, TP, REQUEST, OCNT, DAMOUT); //주문테이블 추가

			MyDB.updateMenuOcntPlus(SNAME, MNAME); //메뉴 주문건수 +1증가

			MyDB.updateCustomerOcntPlus(CID); //고객의 주문건수 +1증가

			MyDB.disconnect();

		} catch (Exception e) {
			e.printStackTrace();
		}

		response.sendRedirect("CustomerOrderTablePrint.jsp");
	%>
</body>
</html>