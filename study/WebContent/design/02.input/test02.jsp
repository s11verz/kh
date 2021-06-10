<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>네이버 로그인 화면</title>
<style>
#naver-login{
width:400px;
font-family:sans-serif;
margin-left:auto;
margin-right:auto;
}
#naver-logo{
font-weight:bold;
font-size:60px;
color:#2db400;
text-align: center;

}
#naver-id-input,#naver-pw-input,#naver-submit{
width:100%;
padding:1rem;
font-size:20px;
box-sizing:border-box;
margin:5px 0px;
}

#naver-submit{
background-color: #2db400;
color:white;
border-style:none;
}
</style>
</head>
<body>
<div id="naver-login">
<h1 id="naver-logo">NAVER</h1>
<form action="" method="post">

<input id="naver-id-input" class="input-login" type="text" name="memberId" placeholder="아이디" required>
<input id="naver-pw-input" class="input-login" type="password" name="memberPw" placeholder="비밀번호" required>
<input id="naver-submit" type="submit" value="로그인">

</form>
</div>
</body>
</html>