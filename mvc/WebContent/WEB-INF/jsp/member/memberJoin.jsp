<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<h1>회원가입</h1>
<form action="memberJoin.kh" method="post">
	아이디: <input type="text" name="memberId"><br><br> 
	비밀번호: <input type="password" name="memberPw"><br><br> 	
	닉네임: <input type="text" name="memberNick"><br><br> 
	생일: <input type="date" name="memberBirth"><br><br> 
	번호: <input type="text" name="memberPhone"><br><br> 
	이메일: <input type="text" name="memberEmail"><br><br> 
	
	<input type="submit" value="회원가입">
</form>