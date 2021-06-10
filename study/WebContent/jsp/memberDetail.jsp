<%@page import="study.beans.MemberDto"%>
<%@page import="study.beans.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	int memberNo = Integer.parseInt(request.getParameter("memberNo"));
	MemberDao memberDao = new MemberDao();
	MemberDto memberDto = memberDao.find(memberNo);
%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 상세 정보</title>
</head>
<body>

	<h1>회원 상세 정보</h1>
	
	<table border="1" width="400">
		<tr>
			<th width="35%">회원번호</th>
			<td><%=memberDto.getMemberNo()%></td>
		</tr>
		<tr>
			<th>회원아이디</th>
			<td><%=memberDto.getMemberId()%></td>
		</tr>
	</table>

</body>
</html>