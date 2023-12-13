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

		String intro = request.getParameter("intro");
		if (intro == null)
			System.out.println("intro=NULL");
		else if (intro.equals(""))
			System.out.println("intro=empty string");

		System.out.println("sname=" + sname);
		System.out.println("mname=" + mname);
		System.out.println("price=" + price);
		System.out.println("intro=" + intro);

		if (mname == null || mname.equals("")) {
			out.println("<script language=javascript> alert('메뉴 이름은 입력되어야 합니다'); window.history.go(-1); </script>");
			return;
		}

		if (price == null || price.equals("")) {
			out.println("<script language=javascript> alert('가격은 입력되어야 합니다'); window.history.go(-1); </script>");
			return;
		}
		if (intro == null || intro.equals(""))
			intro = "0";

		MyDB.loadConnect();
		//Menu menu=new Menu(sname, mname, price, intro);
		ResultSet rs = MyDB.insertMenuRS(sname, mname, price, intro);

		if (rs == null) {
			out.println(
					"<script language=javascript> alert('삽입실패: menu 테이블에 삽입할 수 없습니다'); window.history.go(-1); </script>");
			return;
		} else {
			request.setAttribute("title", "추가된 메뉴 정보");
			request.setAttribute("RS", rs);
		}
	%>

	<!-- 새로운 페이지 호출하여 수행하기 -->
	<jsp:forward page="listRS2.jsp" />;

</BODY>
</HTML>
