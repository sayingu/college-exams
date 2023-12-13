<%@ page contentType="text/html;charset=utf-8"
	import="java.sql.*, java.util.Date"%>
<html>
<head>
</head>
<body>

	<table style="width: 100%;">
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

				</div></td>
		</tr>
	</table>
	<hr>
	<br>

	<%
		request.setCharacterEncoding("utf-8");

		ResultSet rs = (ResultSet) request.getAttribute("RS");

		System.out.print("   >> rs : " + rs + "\n");
		ResultSetMetaData md = rs.getMetaData();
		int count = md.getColumnCount();
		String[] columns = new String[count];
		String[] columnTypes = new String[count];
		for (int i = 0; i < count; i++) {
			columns[i] = md.getColumnLabel(i + 1);
			columnTypes[i] = md.getColumnTypeName(i + 1);
			System.out.print("   >> clms : " + columns[i] + " " + columnTypes[i] + "\n");
		}
	%>
	<br>
	<H3 align=center>
		<%
			out.print(request.getAttribute("title"));
		%>
	</H3>
	<div style="align: right;">
		<table
			style="align: center; valign: top; border: 1; cellpadding: 8; cellspacing: 0; bordercolor: #999999;">
			<%
				out.print("<tr bgcolor=#CCCCCC>");
				out.print("<th>" + "  " + "</th>");
				for (int i = 0; i < columns.length; i++) {
					out.print("<th>" + columns[i] + "</th>");
				}
				out.print("</tr>");

				while (rs.next()) {
					out.print("<tr>");

					for (int i = 0; i < columns.length; i++) {

						Object obj = rs.getObject(columns[i]);

						if (i == 0) {
							String sname = obj.toString();
			%>
			<td>
				<form action="ShowMenubyStore.jsp" method="POST">
					<input type="hidden" name="sname" value=<%=sname%>> <input
						type="submit" value="가게보기"><br>
				</form>
			</td>
			<%
				if (obj == null) // null 객체이면 null을 출력
							
								out.print("<td> null </td>");
							else if (columnTypes[i].equals("INTEGER") || columnTypes[i].equals("FLOAT")
									|| columnTypes[i].equals("DOUBLE") || columnTypes[i].equals("BIGINT")) {
								out.print("<td align=right>" + obj + "</td>");
							} else if (columnTypes[i].equals("VARCHAR") && ((String) obj).equals("")) {
								out.print("<td> &nbsp; </td>");
							} else if (columnTypes[i].equals("VARCHAR")) {
								out.print("<td align=left>" + obj + "</td>");
							} else
								out.print("<td>" + obj + "</td>");

						} else {
							if (obj == null) // null 객체이면 null을 출력
								out.print("<td> null </td>");
							else if (columnTypes[i].equals("INTEGER") || columnTypes[i].equals("FLOAT")
									|| columnTypes[i].equals("DOUBLE") || columnTypes[i].equals("BIGINT"))
								out.print("<td align=right>" + obj + "</td>");
							else if (columnTypes[i].equals("VARCHAR") && ((String) obj).equals(""))
								out.print("<td> &nbsp; </td>");
							else if (columnTypes[i].equals("VARCHAR"))
								out.print("<td align=left>" + obj + "</td>");
							else
								out.print("<td>" + obj + "</td>");
						}
					}
					out.print("</tr>");
				}
			%>
		</table>
	</div>
</body>
</html>