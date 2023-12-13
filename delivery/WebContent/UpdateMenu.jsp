<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" import="java.sql.*, delivery.*, util.*"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<HTML>
<HEAD>
<TITLE>상담 교수 및 학생, 상당내용, 상담 날짜와 시간 입력</TITLE>
</HEAD>
<BODY>
	<%
		request.setCharacterEncoding("utf-8");

		String sname = request.getParameter("sname");
		String mname = request.getParameter("mname");
		String price = request.getParameter("price");
		String sale = request.getParameter("sale");

		String intro = request.getParameter("intro");
		if (intro == null)
			System.out.println("intro=NULL");
		else if (intro.equals(""))
			System.out.println("intro=empty string");

		System.out.println("sname=" + sname);
		System.out.println("mname=" + mname);
		System.out.println("price=" + price);
		System.out.println("intro=" + intro);
		System.out.println("sale=" + sale);

		if (intro == null)
			System.out.println("intro=NULL");
		else if (intro.equals(""))
			System.out.println("intro=empty string");

		System.out.println("sname=" + sname);
		System.out.println("mname=" + mname);
		System.out.println("price=" + price);
		System.out.println("intro=" + intro);
		System.out.println("sale=" + sale);

		if (mname == null || mname.equals("")) {
			out.println("<script language=javascript> alert('메뉴 이름은 입력되어야 합니다'); window.history.go(-1); </script>");
			return;
		}

		if (price == null || price.equals("")) {
			out.println("<script language=javascript> alert('가격은 입력되어야 합니다'); window.history.go(-1); </script>");
			return;
		}
		MyDB.loadConnect();
		ResultSet rs = MyDB.UpdateMenuRS(sname, mname, price, intro, sale);

		if (rs == null) {
			out.println(
					"<script language=javascript> alert('수정실패: 메뉴를 수정할 수 없습니다'); window.history.go(-1); </script>");
			return;
		} else {
			request.setAttribute("title", "메뉴 리스트");
			request.setAttribute("RS", rs);
		}
	%>

	// 새로운 페이지 호출하여 수행하기
	<jsp:forward page="listRS2.jsp" />;

</BODY>
</HTML>
