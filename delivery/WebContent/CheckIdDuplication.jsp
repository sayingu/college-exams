<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" import="java.sql.*, delivery.*, util.*"%>
<%
	request.setCharacterEncoding("utf-8");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	Check Id Duplication

	<%
	// 아이디 중복 검사 실시

	String CID = request.getParameter("CID");
	String usertype = request.getParameter("usertype");

	System.out.println(" CID = " + CID);

	session.setAttribute("idDuplicationChecked", false);

	if (!usertype.equals("1")) {
		if (CID == null || CID.equals("")) {
			out.println(
					"<script language=javascript> alert('아이디가 입력되지 않았습니다'); window.history.go(-1); </script>");
			return;
		} else if (MyDB.isDuplicatedCId(CID)) {
			out.println("<script language=javascript> alert('" + CID
					+ ": 중복된 아이디로 사용할 수 없습니다'); window.history.go(-1); </script>");
			return;
		} else {

			session.setAttribute("idDuplicationChecked", true);

			out.println("<script language=javascript> alert('" + CID
					+ ": 사용 가능한 아이디입니다'); window.history.go(-1); </script>");
		}

	} else {
		session.setAttribute("SIdDuplicationChecked", false);
		if (CID == null || CID.equals("")) {
			out.println(
					"<script language=javascript> alert('아이디가 입력되지 않았습니다'); window.history.go(-1); </script>");
			return;
		} else if (MyDB.isDuplicatedSId(CID)) {
			out.println("<script language=javascript> alert('" + CID
					+ ": 중복된 아이디로 사용할 수 없습니다'); window.history.go(-1); </script>");
			return;
		} else {
			session.setAttribute("SIDDuplicationChecked", true);

			out.println("<script language=javascript> alert('" + CID
					+ ": 사용 가능한 아이디입니다'); window.history.go(-1); </script>");
		}
	}
%>

</body>
</html>

