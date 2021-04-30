<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>입력창 스타일링</title>
<link rel="stylesheet" type="text/css" href="/study/design/common.css">
<style>
	.form-input , .form-btn{
			width:100%;
			padding:0.5rem;
			outline:none;
		}
		
		.form-input.form-input-underline {
			border:none;
			border-bottom: 2px solid lightgray;
		}
		.form-input.form-input-underline:focus {
			border-bottom-color: black;		
		}
		
		.form-input.form-input-inline,
		.form-btn.form-btn-inline {
			width:auto;
		}
		textarea.form-input {
			resize: vertical;
			min-height:150px;/*수치는 자유롭게 설정*/
			height:150px;/*수치는 자유롭게 설정*/
			max-height:500px;/*수치는 자유롭게 설정*/
		}
		
		.form-btn {
			border:none;
		}
		.form-btn.form-btn-normal {
			background-color: white;
			color:gray;
			border:1px solid gray;	
		}
		.form-btn.form-btn-positive {
			background-color: rgb(46, 163, 79);
			color:white;
		}
		.form-btn.form-btn-negative {
			background-color: rgb(202, 36, 49);
			color:white;
		}
		
		.row{
			margin:30px 0px;
		}
</style>
</head>
<body>

	<form action="?" method="post">
		<div class="container-400">
			
			<div class="row">
				<label>아이디</label>
				<input type="text" name="memberId" class="form-input form-input-underline" autocomplete="off">
			</div>
			
			<div class="row">
				<label>비밀번호</label>
				<input type="password" name="memberPw" class="form-input form-input-underline">
			</div>
			
			<div class="row">
				<label>성별</label>
				<select name="gender" class="form-input form-input-inline">
					<option>남자</option>
					<option>여자</option>
				</select>
			</div>
			
			<div class="row">
				<label>자기소개</label>
				<textarea name="intro" class="form-input"></textarea>
			</div>
			
			<div class="row">
				<input type="submit" value="가입" class="form-btn form-btn-positive">
			</div>
			
			<div class="row">
				<input type="reset" value="초기화" class="form-btn form-btn-negative">
			</div>
			
			<div class="row">
				<input type="button" value="이동" class="form-btn form-btn-normal">
			</div>
			
		</div>
	</form>
</body>
</html>