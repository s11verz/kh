<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
<h1>회원 정보 입력</h1>

<form action="/study/jsp/memberInsert.kh" method="get">

<table >
<tr>
<th>아이디</th>
<td>
<input type="text" name="memberId" required></td>
</tr>
<tr>
<th>비밀번호</th>
<td>
<input type="text" name="memberPw" required></td>
</tr>
<tr>
<th>닉네임</th>
<td>
<input type="text" name="memberNick" required></td>
</tr>
<tr>
<th>생년월일</th>
<td>
<input type="date" name="memberBirth" required></td>
</tr>
<tr>
<th>전화번호</th>
<td>
<input type="tel" name="memberPhone" required></td>
</tr>
<tr>
<th>이메일</th>
<td>
<input type="email" name="memberEmail"></td>
</tr>
<tr>
				<th colspan="2" align="right">
					<input type="submit" value="가입">		
				</th>
			</tr>
</table>

</form>
</body>
</html>