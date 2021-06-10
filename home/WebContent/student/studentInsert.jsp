<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 
	파일은 구성정보가 다양하기 때문에 기존의 전송방식(application/x-www-form-urlencoded)으로 전송 불가
	= 전송량이 많기 때문에 무조건 POST 방식을 사용해야 한다.
	= 전송 인코딩 방식을 기존 방식에서 multipart/form-data 방식으로 변경해야 한다.
 -->

<jsp:include page="/template/header.jsp"></jsp:include>

<form action="studentInsert.kh" method="post" enctype="multipart/form-data">
	
	이름 : <input type="text" name="studentName" required>
	<br><br>
	이메일 <input type="text" name="studentEmail" required>
	<br><br>
	프로필 사진 : <input type="file" name="studentProfile" accept=".png, .jpg, .gif">
	<br><br>
	<input type="submit" value="등록">	 
	
</form>

<jsp:include page="/template/footer.jsp"></jsp:include>    