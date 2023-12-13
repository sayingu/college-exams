<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" import="java.sql.*, delivery.*, util.*"%>
<%
	request.setCharacterEncoding("utf-8");
%>
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
	<div align="right"></div>
	<table
		style="align =: enter; valign: top; border: 1; cellpadding: 8; cellspacing: 0; bordercolor: #999999;">
		<%
			out.print(
					"<script>function move(sname){document.location.href=\"GetMenuInfo.html?sname=\"+sname;     }</script>");
			out.print("<tr bgcolor=#CCCCCC>");
			int cnt = 0;
			int price = 0;
			int sale = 0;

			String sname = (String) session.getAttribute("sname");
			System.out.println("\n  ShowStore: sname=" + sname);
			String mname = "";
			String intro = "";
			for (int i = 0; i < columns.length; i++) {
				out.print("<th>" + columns[i] + "</th>");
			}
		%>
		<th>
			<form action="GetMenuInfo.jsp" method="POST">
				<input type="hidden" name="sname" value=<%=sname%>> <input
					type="submit" style="float: left" value="메뉴 추가"><br>
			</form>
		</th>
		<%
			while (rs.next()) {
				for (int i = 0; i < columns.length; i++) {
					Object obj = rs.getObject(columns[i]);

					if (i == 0) {
						if (cnt == 0) {
							sname = obj.toString();
						}
						out.print("<tr>");

						if (obj == null) {// null 객체이면 null을 출력
							out.print("<td> null </td>");
						} else if (columnTypes[i].equals("INTEGER") || columnTypes[i].equals("FLOAT")
								|| columnTypes[i].equals("DOUBLE") || columnTypes[i].equals("BIGINT")) {
							out.print("<td align=right>" + obj + "</td>");
						} else if (columnTypes[i].equals("VARCHAR") && ((String) obj).equals("")) {
							out.print("<td> &nbsp; </td>");
						} else if (columnTypes[i].equals("VARCHAR")) {
							out.print("<td align=left>" + obj + "</td>");
						} else {
							out.print("<td>" + obj + "</td>");
						}
					} else {
						if (obj == null) // null 객체이면 null을 출력
							out.print("<td> null </td>");
						else if (columnTypes[i].equals("INTEGER") || columnTypes[i].equals("FLOAT")
								|| columnTypes[i].equals("DOUBLE") || columnTypes[i].equals("BIGINT"))
							out.print("<td align=right>" + obj + "</td>");
						else if (columnTypes[i].equals("VARCHAR") && ((String) obj).equals(""))
							out.print("<td> &nbsp; </td>");
						else if (columnTypes[i].equals("VARCHAR")) {
							out.print("<td align=left>" + obj + "</td>");
							if (cnt % 10 == 1) {
								mname = obj.toString();
							}
							if (cnt % 10 == 3) {
								intro = obj.toString();
							}
						} else {
							out.print("<td>" + obj + "</td>");
							if (cnt % 10 == 2) {
								price = Integer.parseInt(obj.toString());
							}

							else if (cnt % 10 == 5) {
								sale = Integer.parseInt(obj.toString());
							}
						}
					}
					cnt++;
				}
		%>
		<td>
			<form action="GetInfoUpdateMenu.jsp" method="POST">
				<input type="hidden" name="sname" value=<%=sname%>> <input
					type="hidden" name="mname" value=<%=mname%>> <input
					type="hidden" name="intro" value=<%=intro%>> <input
					type="hidden" name="price" value=<%=price%>> <input
					type="hidden" name="sale" value=<%=sale%>> <input
					type="submit" style="float: left" value="메뉴 수정"><br>
			</form>
		</td>
		<%
			out.print("</tr>");
			}
		%>
	</table>
	<form action="MyStoreOrderTablePrint.jsp" method="POST">
		<INPUT TYPE=hidden NAME=sname size=10 value=<%=sname%>>
		<input type="submit" value="주문내역보기"><br> <br>

	</form>

</body>
</html>