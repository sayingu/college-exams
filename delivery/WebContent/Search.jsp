<%@ page language="java" contentType="text/html; charset=EUC-KR"
	import="delivery.*" pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Ž�� ó��</title>
<body>
	<br>
	<h1 align=center>����</h1>
	<div align="right">

		<%
			String id = (String) session.getAttribute("id");
			System.out.println("ID=" + id);

			if (id == null || id.equals("")) {
		%>
		<button type="button" onclick="location.href='Login.html'">�α���
		</button>
		<button type="button" onclick="location.href='Joinm.html'">ȸ������
		</button>
		<%
			} else {
		%>
		<%=id%>���� �α��� �߽��ϴ�. <input type=button value="�α׾ƿ�"
			onclick="location.href='Logout.jsp'">
		<%
			}
		%>

	</div>
	<hr>
	<br>
	<div align="center">
		<h3>Ž���� ���� ������ �ۼ��ϱ� �ٶ��ϴ�.....</h3>
	</div>
</body>
</html>


