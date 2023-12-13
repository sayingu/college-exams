






<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" import="java.sql.*, delivery.*, util.*"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<HTML>
<HEAD>
<TITLE>메뉴 정보 입력</TITLE>
</HEAD>

<BODY>

	<table width=100%>
		<tr>
			<td bgcolor='#CCEEFF'><h1 align=center>요기따</h1>
				<div align=right>
					<%=session.getAttribute("id")%>님이 로그인 했습니다.<br> <input
						type=button value="로그아웃" onclick="location.href='Logout.jsp'">
					<button onclick="location.href='FindMenubySIDforAdmin.jsp'">홈으로</button>
					<br>
				</div></td>
		</tr>
	</table>
	<hr>
	<br>
	<%
		String sname = request.getParameter("sname");
		System.out.println("sname=" + sname);

		request.setAttribute("title", "** '" + sname + "'의 메뉴보기 **");
	%>
	<br>

	<H3 align=center>메뉴 정보 입력</H3>
	<form name=form1 method=post action=InsertMenu.jsp>
		<TABLE align=center valign=top border="1" cellpadding="8"
			cellspacing="0" bordercolor="#999999">

			<INPUT TYPE=hidden NAME=sname size=10 value=<%=sname%>>
			<TR align=left bgcolor=white cellspacing=1 cellpadding=5>
				<TD width=85>메뉴이름</TD>
				<TD><INPUT TYPE=text NAME=mname size=10 required></TD>
			</TR>

			<TR align=left bgcolor=white cellspacing=1 cellpadding=5>
				<TD width=85>가격</TD>
				<TD><INPUT TYPE="text" NAME=price size=10 value=""></TD>
			</TR>

			<TR align=left bgcolor=white cellspacing=1 cellpadding=5>
				<TD width=85>소개</TD>
				<TD><INPUT TYPE="text" NAME=intro size=20 value=""></TD>
			</TR>


		</TABLE>
		<H4 align=center>
			<input type="submit" value=" 추 가  " name="B1">
	</form>
</BODY>
</HTML>
