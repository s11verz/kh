<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>입력창 스타일링</title>
<style>
input:first-child{}
input:nth-child(1){}
.input-item{
/*테두리 스타일*/
border-color:gray;
border-style:solid;
border-width:1px;
border-radius:5px;
/*여백 스타일
margin-외부 여백
padding-내부 여백 */
padding:10px; /*상하5 좌우10*/
/*padding: 1px 2px 3px 4px : 시계방향(상 우 하 좌)*/
/*글꼴 스타일*/
font-size:0.8rem;
/*크기 속성*/
 
}

</style>
</head>
<body>

<form action="" method="get">

<input id="keyword-input" class="input-item" type="text" name="keyword" placeholder="무엇을 찾으세요?">
<input type="submit" value="검색">

</form>

</body>
</html>