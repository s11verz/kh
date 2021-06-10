<%@page import="home.beans.StudentInfoDto"%>
<%@page import="java.util.List"%>
<%@page import="home.beans.StudentInfoDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	StudentInfoDao studentInfoDao = new StudentInfoDao();
	List<StudentInfoDto> list = studentInfoDao.list();
%>


<jsp:include page="/template/header.jsp"></jsp:include>

<h1>학생 목록</h1>

<!-- 학생 수만큼 목록 출력 -->
<%for(StudentInfoDto studentInfoDto : list){ %>
<div>
	<!-- 
		다운로드 주소를 src에 적으면 이미지를 다운받아서 표시해준다
		다운로드 받도록 링크하고 싶다면 a태그에 다운로드 주소를 설정한다 
		
		만약 이미지가 없을 수 있다면 대체 이미지를 출력하는 것도 하나의 방법이 될 수 있다.
		= 더미이미지를 내가 가지고 있거나 CDN을 이용하여 설정해준다.
	-->
	<%if(studentInfoDto.getProfileNo() > 0){ %>
	<img src="studentProfile.kh?profileNo=<%=studentInfoDto.getProfileNo()%>" width="200" height="200">
	<a href="studentProfile.kh?profileNo=<%=studentInfoDto.getProfileNo()%>">다운로드</a>
	<%} else { %>
	<img src="https://via.placeholder.com/200x200?text=P" width="200" height="200">
	<%} %>
	<h2><%=studentInfoDto.getStudentName()%></h2>
</div>
<%} %>


<jsp:include page="/template/footer.jsp"></jsp:include>



