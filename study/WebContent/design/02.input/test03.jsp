<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠팡 로그인</title>
<style>
h1:first-child{color:#906D3B;}
h1:nth-child(2){color:#EB3232;}
h1:nth-child(3){color:#FFC800;}
h1:nth-child(4){color:	#6ED746;}
h1:nth-child(5){color:#3CA0FF;}
#coupang-login{
width:400px;
font-family:sans-serif;
margin-left:auto;
margin-right:auto;

}
#coupang-logo{
margin:0px 30px;
}
.coupang-logo{
font-weight:bold;
font-size:60px;
text-align:center;
display:inline-block;
}
.input-login{
width:100%;
padding:1rem;
font-size:15px;
box-sizing:border-box;
margin:5px 0px;
}
#coupang-id-input,#coupang-pw-input{
padding-left:50px;
}
#coupang-submit{
color:white;
background-color:#1e90ff;
border-color:silver;
}
#coupang-join{
color:#1e90ff;
background-color:white;
border-color:silver;
}
#remark{
color:gray;
font-size:10px;
margin:110px;
}
</style>
</head>
<body>
<div id="coupang-login">
<div id="coupang-logo">
<h1 class="coupang-logo">COU</h1>
<h1 class="coupang-logo">P</h1>
<h1 class="coupang-logo">A</h1>
<h1 class="coupang-logo">N</h1>
<h1 class="coupang-logo">G</h1>
</div>
<form action="" method="post">
<input id="coupang-id-input" class="input-login" type="text" name="memberId" placeholder="아이디(이메일)" required>
<input id="coupang-pw-input" class="input-login" type="password" name="memberPw" placeholder="비밀번호" required>
<input id="coupang-submit" class="input-login" type="submit" value="로그인">
<hr>
<input id="coupang-join" class="input-login" type="submit" value="회원가입">
<hd id="remark">ⓒCoupang Corp, All rights reserved.</hd>
</form>
</div>
</body>
</html>