<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/template/header.jsp"></jsp:include>

<div class="container-600">
	<div class="row">
		<h2>로그인</h2>
	</div>
	
	<form action="login.kh" method="post">
		<div class="row text-left">
			<label>아이디</label>
			<input type="text" name="memberId" required class="form-input form-input-underline" >
		</div>
		<div class="row text-left">
			<label>비밀번호</label>
			<input type="password" name="memberPw" required class="form-input form-input-underline">
		</div>
		<div class="row">
			<input type="submit" value="로그인" class="form-btn form-btn-normal">
		</div>
		<div class="row ">
<!-- 			<h4 class="form-btn form-btn-normal form-style"><a href="#" >아이디 찾기</a></h4> -->
				<input type="submit" value="아이디 찾기" class="form-btn form-btn-normal">
		</div>
		<div class="row">
<!-- 			<h4 class="form-btn form-btn-normal form-style"><a href="#">비밀번호 찾기</a></h4> -->
				<input type="submit" value="비밀번호찾기" class="form-btn form-btn-normal">
		</div>
	</form>
</div>

<jsp:include page="/template/footer.jsp"></jsp:include>