
<%@ page contentType="text/html;charset=utf-8"
	import="java.sql.*, delivery.*, java.util.Date"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");

		String ONUM = request.getParameter("ONUM");
		String CID = request.getParameter("CID");
		String MREVIEW = request.getParameter("mreview");
		int MGPA = Integer.parseInt(request.getParameter("MGPA"));

		String SNAME = request.getParameter("SNAME");
		String MNAME = request.getParameter("MNAME");

		MyDB.loadConnect();

		MyDB.updateReview(ONUM, MREVIEW, MGPA);

		MyDB.updateMReviewCountPlus(MNAME);

		MyDB.updateCustomerRcnt(CID);

		ResultSet rs = MyDB.selectReviewbyStorename(SNAME);

		request.setAttribute("title", "리뷰 내용");
		request.setAttribute("RS", rs);
		request.getRequestDispatcher("listRS.jsp").forward(request, response);
	%>
</body>
</html>