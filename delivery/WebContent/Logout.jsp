<%@ page language="java" contentType="text/html; charset=EUC-KR"
	import="delivery.*" pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>�α׾ƿ� ó��</title>
<body>
	<br>
	<table width=100%>
		<tr>
			<td bgcolor='#CCEEFF'><h1 align=center>����</h1>
				<div align="right">
					<button type="button" onclick="location.href='DeliveryStart.html'">ó������
					</button>

				</div>
			</td>
		</tr>
	</table>
	<hr>
	<br>
	<div align="center">
		<h3>
			<%=session.getAttribute("id")%>�� �α׾ƿ��߽��ϴ�.
		</h3>
	</div>
	<%
		session.invalidate();
	%>
</body>
</html>


