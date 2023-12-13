<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" import="java.sql.*, delivery.*, util.*"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>로그인 처리</title>
<body>
	<%
		String usertype = request.getParameter("usertype");
		String id = request.getParameter("id");
		String password = request.getParameter("password");

		if (id == null || id.equals("")) {
			out.println(
					"<script language=javascript> alert('아이디가 입력되지지 않았습니다.'); window.history.go(-1); </script>");
			return;
		}
		if (password == null || password.equals("")) {
			out.println(
					"<script language=javascript> alert('패스워드가 입력되지지 않았습니다.'); window.history.go(-1); </script>");
			return;
		}

		if (MyDB.isValidLogin(usertype, id, password)) {
			session.setAttribute("usertype", usertype); // usertype을 session 객체에 저장
			session.setAttribute("id", id); // 로그인 id를 session 객체에 저장

			if (usertype.equals("customer")) {
				response.sendRedirect("CustomerStart.jsp");
			} else if (usertype.equals("owner")) {
				String sname = MyDB.selectSnameOfId(id);
				session.setAttribute("sname", sname); // 로그인 id를 session 객체에 저장  
				response.sendRedirect("FindMenubySIDforAdmin.jsp"); //가게운영자시작

			}
		} else {
			out.println(
					"<script language=javascript> alert('아이디 또는 패스워드가 잘못되었습니다'); window.history.go(-1); </script>");
			return;

		}
	%>
</body>
</html>


