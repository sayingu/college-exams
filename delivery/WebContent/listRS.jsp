<%@ page contentType="text/html;charset=euc-kr"
	import="java.sql.*, java.util.Date"%>
<HTML>
<BODY>
	<table style="width: 100%;">
		<tr>
			<td bgcolor='#CCEEFF'><h1 align=center>����</h1>
				<div align=right>
					<%=session.getAttribute("id")%>���� �α��� �߽��ϴ�.<br> <input
						type=button value="�α׾ƿ�" onclick="location.href='Logout.jsp'">
					<button onclick="location.href='CustomerStart.jsp'">Ȩ����</button>
					<br>
					<button onclick="window.history.go(-2)">���ư���</button>

				</div></td>
		</tr>
	</table>
	<hr>
	<br>
	<br>
	<H3 align=center>
		<%
			out.print(request.getAttribute("title"));
		%>
	</H3>
	<%
		request.setCharacterEncoding("euc-kr");

		ResultSet rs = (ResultSet) request.getAttribute("RS");

		rs.last(); // rs Ŀ���� ������ �̵��Ͽ� ���� ���� Ȯ��
		int cntTuples = rs.getRow(); // ���� ������ ����
		rs.beforeFirst(); // rs Ŀ���� ó������ �̵�
		System.out.print("   >> cntTuples = " + cntTuples + "\n");

		if (cntTuples == 0) { // ���� ������ 0�̸�
			out.println("<center>(��� ����)</center>");
			return;
		}

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
	<%
		out.print("<table align=center valign=top border=1 cellpadding=8 cellspacing=0 bordercolor=#999999>");
		out.print("<tr bgcolor=#DDDDDD>");
		for (int i = 0; i < columns.length; i++) {
			out.print("<th>" + columns[i] + "</th>");
		}
		out.print("</tr>");

		while (rs.next()) {
			out.print("<tr>");

			for (int i = 0; i < columns.length; i++) {

				Object obj = rs.getObject(columns[i]);
				// System.out.print("   >> col value : " + (obj) + "\n");
				if (obj == null) // null ��ü�̸� null�� ���
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
			out.print("</tr>");
		}
		out.print("</table>");
	%>
</BODY>
</HTML>
