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
		Boolean b = (Boolean) session.getAttribute("SIDDuplicationChecked");

		if (b == null || b == false) {
			out.println(
					"<script language=javascript> alert('아이디 중복 검사를 하지 않았습니다.'); window.history.go(-1); </script>");
			return;
		} else
			session.setAttribute("SIDDuplicationChecked", false);

		String SID = request.getParameter("SID");
		String SADNAME = request.getParameter("SADNAME");
		String SNAME = request.getParameter("SNAME");
		String PW = request.getParameter("PW");
		String ADD = request.getParameter("ADD");
		String CP = request.getParameter("CP");
		String CLASSTIFICATION = request.getParameter("CLASSTIFICATION");
		String OPENTIME = request.getParameter("OPENTIME");
		String CLOSETIME = request.getParameter("CLOSETIME");

		if (MyDB.insertAdmin(SID, SNAME, SADNAME, PW, CP, ADD)
				&& MyDB.insertStore(SNAME, CLASSTIFICATION, OPENTIME, CLOSETIME)) {
			out.println("<script language=javascript> alert(" + SNAME + "점주님 아이디" + SID
					+ "(으)로 회원 가입햇습니다.'); </script>");
			response.sendRedirect("DeliveryStart.html");
		}
	%>
</body>
</html>


