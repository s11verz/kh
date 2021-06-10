<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠팡 로그인</title>
<style>
.coupang-login{
text-align:center;
width:400px;
margin: 0 auto;
}
.coupang-logo{
font-family:Neo Sans pro, sans-serif;
font-size:60px;
font-weight:bold;
}
.coupang-logo>span{
display:inline-block;
margin-left:-8px;
margin-right:-8px;
}
.coupang-logo>span:nth-child(1),.coupang-logo>span:nth-child(2),.coupang-logo>span:nth-child(3){
color:rgb(147,82,39);
}
.coupang-logo>span:nth-child(4){color:rgb(247,85,47);}
.coupang-logo>span:nth-child(5){color:rgb(255,197,5);}
.coupang-logo>span:nth-child(6){color:rgb(136,204,47);}
.coupang-logo>span:nth-child(7){color:rgb(49,180,221);}
.form-input,.form-btn{
width:100%;
box-sizing:border-box;
margin-top:10px;
margin-bottom:10px;
font-size:20px;
padding:1rem;
}
.form-input{
padding-left:4rem;
}
.form-btn{
border-style:solid;
border-color:gray;
}
.id-input{}
.pw-input{}
.btn-normal{
background-color:white;
color:rgb(0,116,233);
}
.btn-submit{
background-color:rgb(0,116,233);
color:white;
}
</style>
</head>
<body>
	<!-- div는 한줄에 하나씩만 
	 span은 한줄에 여러개 가능 -->
	 <div class="coupang-login">
	<div class="coupang-logo">
		<span>c</span>
		<span>o</span>
		<span>u</span>
		<span>p</span>
		<span>a</span>
		<span>n</span>
		<span>g</span>
	</div>
	
	<form action="#" method="post">
		<input type="text" name="memberId" placeholder="아이디(이메일)" required class="form-input id-input">
		<input type="password" name="memberPw" placeholder="비밀번호" required class="form-input pw-input">
		<input type="submit" value="로그인" class="form-btn btn-submit">
		<hr>
		<input type="button" value="회원가입" class="form-btn btn-normal">
	</form>
	</div>
</body>
</html>