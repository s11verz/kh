<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>파일 업로드 예제</h1>


<h3>파일 1개 업로드</h3>
<form action="upload1" method="post" enctype="multipart/form-data">
	<input type="file" name="f">
	<input type="submit" value="업로드">
</form>

<hr>

<h3>파일 여러개 업로드</h3>
<form action="upload2" method="post" enctype="multipart/form-data">
	<input type="file" name="f" multiple>
	<br><br>
	<input type="submit" value="업로드">
</form>

<hr>

<h3>정보와 파일이 섞여서 업로드(1)</h3>
<form action="upload3" method="post" enctype="multipart/form-data">
	이름 : <input type="text" name="studentName">
	<br><br>
	이메일 : <input type="text" name="studentEmail">
	<br><br>
	사진 : <input type="file" name="studentProfile">
	<br><br>
	<input type="submit" value="등록">
</form>

<hr>

<h3>정보와 파일이 섞여서 업로드(2)</h3>
<form action="upload4" method="post" enctype="multipart/form-data">
	이름 : <input type="text" name="studentName">
	<br><br>
	이메일 : <input type="text" name="studentEmail">
	<br><br>
	사진 : <input type="file" name="studentProfile">
	<br><br>
	<input type="submit" value="등록">
</form>
