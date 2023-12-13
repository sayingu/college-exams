
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" import="java.sql.*, delivery.*, util.*"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>회원 가입 처리</title>
<body>
	<%
		Boolean b = (Boolean) session.getAttribute("idDuplicationChecked");

		if (b == null || b == false) {
			out.println(
					"<script language=javascript> alert('아이디 중복 검사를 하지 않았습니다.'); window.history.go(-1); </script>");
			return;
		} else
			session.setAttribute("idDuplicationChecked", false);

		String CID = request.getParameter("CID");
		String PW = request.getParameter("PW");
		String CNAME = request.getParameter("CNAME");
		String ADD = request.getParameter("ADD");
		String CP = request.getParameter("CP");

		if (MyDB.insertCustomer(CID, PW, CNAME, ADD, CP)) {
			out.println("<script language=javascript> alert(" + CNAME + "고객님 아이디" + CID
					+ "(으)로 회원 가입햇습니다.'); </script>");

			response.sendRedirect("DeliveryStart.html");
		}
	%>
</body>
</html>


