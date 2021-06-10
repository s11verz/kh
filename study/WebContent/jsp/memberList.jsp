<%@page import="study.beans.MemberDto"%>
<%@page import="java.util.List"%>
<%@page import="study.beans.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String type = request.getParameter("type");
	String keyword = request.getParameter("keyword");
	
	boolean isSearch = type != null && keyword != null;
	
	MemberDao memberDao = new MemberDao();
	//List<MemberDto> memberList = 목록 or 검색;
	List<MemberDto> memberList;
	
	if(isSearch){
		memberList = memberDao.searchList(type, keyword);
	}
	else{
		memberList = memberDao.selectList();
	}
%>


<!-- 화면 -->
<h1>회원 목록</h1>

<form action="memberList.jsp">
	<select name="type">
		<option value="member_id">아이디</option>
		<option value="member_nick">닉네임</option>
		<option value="member_grade">권한</option>
	</select>
	<input type="search" name="keyword" placeholder="검색어" required>
	<input type="submit" value="검색">
</form>

<table border="1" width="800">
	<thead>
		<tr>
			<th>회원번호</th>
			<th>아이디</th>
			<th>닉네임</th>
			<th>등급</th>
			<th>가입일</th>
		</tr>
	</thead>
	
	<tbody>
		<%for(MemberDto memberDto : memberList){ %>
		<tr>
			<td><%=memberDto.getMemberNo()%></td>
			<td>
<%-- 		<a href="/study/jsp/memberDetail.jsp?memberNo=<%=memberDto.getMemberNo()%>"> --%>
				<a href="memberDetail.jsp?memberNo=<%=memberDto.getMemberNo()%>">
					<%=memberDto.getMemberId()%>
				</a>
			</td>
			<td><%=memberDto.getMemberNick()%></td>
			<td><%=memberDto.getMemberGrade()%></td>
			<td><%=memberDto.getMemberJoin()%></td>
		</tr>
		<%} %>
	</tbody>
</table>






