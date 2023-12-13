<%@ page language="java" contentType="text/html; charset=EUC-KR"
	import="delivery.*" pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>로그아웃 처리</title>
<body>
	<br>
	<table width=100%>
		<tr>
			<td bgcolor='#CCEEFF'><h1 align=center>요기따</h1>
				<div align="right">
					<button type="button" onclick="location.href='DeliveryStart.html'">처음으로
					</button>

				</div>
			</td>
		</tr>
	</table>
	<hr>
	<br>
	<div align="center">
		<h3>
			<%=session.getAttribute("id")%>님 로그아웃했습니다.
		</h3>
	</div>
	<%
		session.invalidate();
	%>
</body>
</html>


