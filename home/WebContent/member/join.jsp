<%@page import="home.beans.MemberDto"%>
<%@page import="java.util.List"%>
<%@page import="home.beans.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/template/header.jsp"></jsp:include>
   
 <div class="container-600">
	<div class="row">
		<h2>회원 정보 입력</h2>
	</div>
	<form action="join.kh" method="post">
		<div class="row text-left">
			<label>아이디</label>
			<input type="text" name="memberId" required class="form-input form-input-underline" 
			placeholder="8~20자 이내의 영문 소문자, 숫자">
		</div>
		<div class="row text-left">
			<label>비밀번호</label>
			<input type="password" name="memberPw" required class="form-input from-input-underline"
			placeholder="8~16자 내의 영문 소문자, 숫자, 특수문자">
		</div>
		<div class="row text-left">
			<label>비밀번호 확인</label>
			<input type="password" class="form-input form-input-underline" >
		</div>
		<div class="row text-left">
			<label>닉네임</label>
			<input type="text" name="memberNick" required class="form-input from-input-underline"
			placeholder="한글 3~10자 이내">
		</div>
		<div class="row text-left">
			<label>생년월일</label>
			<input type="date" name="memberBirth" required class="form-input from-input-underline">
		</div>
		<div class="row text-left">
			<label>전화번호</label>
			<input type="text" name="memberPhone" required class="form-input from-input-underline"
			placeholder="-를 포함하여 입력">
		</div>
		<div class="row text-left">
			<label>이메일</label>
			<input type="email" name="memberEmail" class="form-input from-input-underline"
			>
		</div>
		<div class="row">
			<input type="submit" value="등록" class="form-btn form-btn-normal"> 
		</div>
	</form>
 </div>  
   
<jsp:include page="/template/footer.jsp" ></jsp:include>