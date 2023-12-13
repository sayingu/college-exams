<%@ page contentType="text/html;charset=utf-8"
	import="java.sql.*, delivery.*, java.util.Date"%>
<%@page import="java.util.Vector"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<table width=100%>
		<tr>
			<td bgcolor='#CCEEFF'><h1 align=center>요기따</h1>
				<div align=right>
					<%=session.getAttribute("id")%>님이 로그인 했습니다.<br> <input
						type=button value="로그아웃" onclick="location.href='Logout.jsp'">
					<button onclick="location.href='CustomerStart.jsp'">홈으로</button>
					<br>
					<form action="CustomerOrderTablePrint.jsp" method="POST">
						<input type="hidden" name="CID"
							value=<%=session.getAttribute("id")%>> <input
							type="submit" value="주문내역">
					</form>
				</div>
			</td>
		</tr>
	</table>
	<hr>
	<br>
	<%
		request.setCharacterEncoding("utf-8");
		MyDB.loadConnect();

		String MNAME = request.getParameter("mname");

		ResultSet rs = MyDB.selectMenubyMNAME(MNAME);
		rs.next();
	%>
	<form action=OrderOk.jsp method="POST">
		<table border=1 width=320 align=center valign=top bgcolor=white
			cellspacing=1 cellpadding=1 bordercolor=black>
			<tr type="hidden">
				<td><input type="hidden" name="SNAME"
					value=<%=rs.getString("sname")%>></td>
			</tr>
			<tr>
				<td>메뉴</td>
				<td><%=rs.getString("mname")%> <input type="hidden"
					name="MNAME" value=<%=rs.getString("mname")%>></td>
			</tr>
			<tr>
				<td>개수</td>
				<td>

					<p align=center>
						<select name="OCNT">
							<option value=1>1
							<option value=2>2
							<option value=3>3
							<option value=4>4
							<option value=5>5
						</select>
				</td>
			</tr>
			<tr>
				<td>요구사항</td>
				<td><textarea name="request" cols="50" rows="5"
						placeholder="요구 사항을 남겨주세요."></textarea></td>
			</tr>
			<tr>
				<td colspan=2 align="center"><input type="submit" value=" 주 문 ">&emsp;&emsp;
				</td>
			</tr>
		</table>
	</form>
</body>
</html>