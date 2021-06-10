<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
int p;
try{
	p=Integer.parseInt(request.getParameter("p"));
}catch(Exception e){
	p=1;
}
%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Pagination 만들기</title>
<link rel="stylesheet" type="text/css" href="/study/design/common.css">
<style>
	.pagination>a{
		color:gray;
		text-decoration: none;
		display:inline-block;
		min-width:35px;
		border:1px solid transparent;
		padding:0.5rem;
		text-align:center;
	}
	.pagination>a:hover,
	.pagination>a.on{
		border:1px solid lightgray;
		color:rgb(255,85,146);
	
	}
</style>
</head>
<body>
	<div class="pagination">
		<a href="#">&lt;이전</a>
		<%for(int i=1;i<10;i++){ %>
			<%if(p==i){ %>
			<a href="#" class="on"><%=i %></a>
			<%}else{ %>
			<a href="#"><%=i %></a>
			<%} %>
		<%} %>
		<a href="#">다음&gt;</a>
	</div>
</body>
</html>