
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
	<%
		request.setCharacterEncoding("utf-8");
		MyDB.loadConnect();

		String ONUM = request.getParameter("ONUM");

		ResultSet rs = MyDB.selectOrderbyONUM(ONUM); //주문번호로 주문튜플 선택
		rs.next();
	%>
	<table width=100%>
		<tr>
			<td bgcolor='#CCEEFF'><h1 align=center>요기따</h1>
				<div align=right>
					<%=session.getAttribute("id")%>님이 로그인 했습니다.<br> <input
						type=button value="로그아웃" onclick="location.href='Logout.jsp'">
					<button onclick="location.href='CustomerStart.jsp'">홈으로</button>
					<br>
				</div><
			/td>
		</tr>
	</table>
	<hr>
	<br>
	<form name=form1 method=post action=CustomerReviewPrint.jsp>
		<table align=center valign=top border="1" cellpadding="8"
			cellspacing="0" bordercolor="#999999">
			<tr bgcolor=#CCCCCC>
				<th>주문번호</th>
				<th>가게</th>
				<th>메뉴</th>
				<th>주문수량</th>
				<th>요구사항</th>
				<th>총 가격</th>
			</tr>
			<tr>
				<td><%=ONUM%></td>
				<td><%=rs.getString("SNAME")%></td>
				<td><%=rs.getString("MNAME")%></td>
				<td><%=rs.getString("OCNT")%></td>
				<td><%=rs.getString("REQUEST")%></td>
				<td><%=rs.getString("TP")%></td>
			</tr>
		</table>
		<TABLE border=1 width=320 align=center valign=top bgcolor=white
			cellspacing=1 cellpadding=1 bordercolor=black>
			<tr>
				<td><input type="hidden" name="ONUM" value=<%=ONUM%>> <input
					type="hidden" name="SNAME" value=<%=rs.getString("SNAME")%>>
					<input type="hidden" name="MNAME" value=<%=rs.getString("MNAME")%>>
				</td>
			</tr>
			<TR align=center>
				<TD>음식 리뷰</TD>
				<TD><textarea name="mreview" cols="50" rows="5"
						placeholder="메뉴 리뷰를 남겨주세요."></textarea>
			<TR align=center>
				<TD>음식 평점</TD>
				<TD>
					<p align=center>
						<select name="MGPA">
							<option value=1>1
							<option value=2>2
							<option value=3>3
							<option value=4>4
							<option value=5>5
						</select>
					</p>
				</TD>
			<TR align=center>
				<TD colspan="2"><H4 align=center></H4> 
				<input type="submit" value=" 확 인"></TD>
			</TR>
		</TABLE>
	</form>
</body>
</html>