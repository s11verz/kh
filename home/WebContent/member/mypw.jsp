<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/template/header.jsp"></jsp:include>

<div class="container-600">
	<div class="row">비밀번호 변경</div>
	
	<form action="mhpw.kh" method="post">
		<div class="row">
			<input type="password" name="curPw" placeholder="현재 비밀번호" required class="form-input form-input-underline">
		</div>
		<div class="row">
			<input type="password" name="newPw" placeholder="변경할 비밀번호" required class="form-input form-input-underline">
		</div>
		<div class="row">
			<input type="submit" value="변경하기" class="form-btn form-btn-normal">
		</div>
		<%if(request.getParameter("error") != null){ %>
		<div class="row">
			<h5 class="error">정보가 일치하지 않습니다</h5>
		</div>
		<%} %>
		
	</form>
	


</div>

<jsp:include page="/template/footer.jsp"></jsp:include>