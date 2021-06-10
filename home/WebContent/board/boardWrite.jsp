<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/template/header.jsp"></jsp:include>

<h2>게시글 등록</h2>

<form action="boardWrite.kh" method="post">
	말머리 : 
	<select name="boardHeader">
		<option value="">선택하세요</option>
		<option>공지</option>
		<option>정보</option>
		<option>자유</option>
		<option>유머</option>
	</select>
	<br><br>
	제목 : <input type="text" name="boardTitle">
	<br><br>
	내용 : <textarea name="boardContent"></textarea>
	<br><br>
	<input type="submit" value="작성">
</form>

<jsp:include page="/template/footer.jsp"></jsp:include>