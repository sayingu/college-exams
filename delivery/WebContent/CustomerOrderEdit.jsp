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
					<form action="CustomerOrderTablePrint.jsp" method="POST">
						<input type="hidden" name="CID"
							value=<%=session.getAttribute("id")%>> <input
							type="submit" value="주문내역">
					</form>
				</div></td>
		</tr>
	</table>
	<hr>
	<br>
	<%
		request.setCharacterEncoding("utf-8");
		MyDB.loadConnect();

		String ONUM = request.getParameter("ONUM");

		ResultSet rs = MyDB.selectOrderbyONUM(ONUM);
		rs.next();
	%>
	<form action=CustomerOrderEditOk.jsp method="POST">
		<table border=1 width=320 align=center valign=top bgcolor=white
			cellspacing=1 cellpadding=1 bordercolor=black>
			<tr>
				<td><input type="hidden" name="ONUM" value=<%=ONUM%>></td>
			</tr>
			<tr>
				<td>가게이름</td>
				<td><%=rs.getString("sname")%></td>
			</tr>
			<tr>
				<td>메뉴</td>
				<td>현재 메뉴 : <%=rs.getString("mname")%> <%
 	String sname = rs.getString("sname");
 	@SuppressWarnings("unchecked")
 	Vector<String> mnames = MyDB.selectDistinctMenu(sname);
 %>
					<p align=center>
						<select name="MNAME">
							<%
								for (int i = 0; i < mnames.size(); i++)
									out.print("<option value=\"" + mnames.get(i) + "\" >" + "&nbsp;&nbsp;" + mnames.get(i));
							%>
						</select></td>
			</tr>
			<tr>
				<td>개수</td>
				<td>현재 개수 : <%=rs.getString("ocnt")%>
					<p align=center>
						<select name="OCNT">
							<option value=1>1
							<option value=2>2
							<option value=3>3
							<option value=4>4
							<option value=5>5
						</select></td>
			</tr>
			<tr>
				<td>요구사항</td>
				<td>현재 요구 사항 : <%=rs.getString("request")%> <textarea
						name="request" cols="50" rows="5" placeholder="요구 사항을 남겨주세요."></textarea>
				</td>
			</tr>
			<tr>
				<td colspan=2 align="center"><input type="submit"
					value=" 수  정 ">&emsp;&emsp;
		</table>
	</form>
</body>
</html>