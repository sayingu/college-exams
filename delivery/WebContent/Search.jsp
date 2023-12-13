<%@ page language="java" contentType="text/html; charset=EUC-KR"
	import="delivery.*" pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>탐색 처리</title>
<body>
	<br>
	<h1 align=center>요기따</h1>
	<div align="right">

		<%
			String id = (String) session.getAttribute("id");
			System.out.println("ID=" + id);

			if (id == null || id.equals("")) {
		%>
		<button type="button" onclick="location.href='Login.html'">로그인
		</button>
		<button type="button" onclick="location.href='Joinm.html'">회원가입
		</button>
		<%
			} else {
		%>
		<%=id%>님이 로그인 했습니다. <input type=button value="로그아웃"
			onclick="location.href='Logout.jsp'">
		<%
			}
		%>

	</div>
	<hr>
	<br>
	<div align="center">
		<h3>탐색을 위한 페이지 작성하기 바랍니다.....</h3>
	</div>
</body>
</html>


