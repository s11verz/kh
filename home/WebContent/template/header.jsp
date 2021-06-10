
      
      <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//템플릿 페이지의 모든 경로는 절대경로로 
	String root=request.getContextPath();

	Integer memberNo=(Integer)session.getAttribute("memberNo");
	boolean isLogin=memberNo!=null;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내가 만든 홈페이지</title>
<link rel="stylesheet" type="text/css" href="<%=root%>/css/common.css">
<link rel="stylesheet" type="text/css" href="<%=root%>/css/menu.css">
<link rel="stylesheet" type="text/css" href="<%=root%>/css/layout.css">
<link rel="stylesheet" type="text/css" href="<%=root%>/css/test.css">
<style>
	main{
		width:1200px;
		margin-left:auto;
		margin-right:auto;
	}
	header,section,footer{
		text-align:center;
		padding:25px;
	}
</style>
</head>
<body>
	<main>
		<header>
			<h1>홈페이지 1달만에 박살내기</h1>
		</header>
		<nav>
			<ul class="menu">
		<li>
			<a href="#">회원기능</a>
			<ul>
				<%if(isLogin){ %>
				
				<li><a href="<%=root%>/member/logout.kh">로그아웃</a></li>
				<li><a href="<%=root%>/member/myinfo.jsp">내정보보기</a></li>
				<li><a href="#">내정보수정</a></li>
				<li><a href="<%=root%>/member/exit.kh">회원 탈퇴</a></li>
				<li><a href="#">회원조회/검색</a></li>
				<%}else{ %>
				<li><a href="<%=root%>/member/join.jsp">회원가입</a></li>
				<li><a href="<%=root%>/member/login.jsp">로그인</a></li>
				<%} %>
			</ul>
		</li>
		<li>
			<a href="#">아이템 관리</a>
			<ul>
				<li><a href="#">아이템 등록</a></li>
				<li><a href="<%=root%>/item/itemList.jsp">아이템 목록</a></li>
			</ul>
		</li>
		<li>
			<a href="#">상품관리</a>
			<ul>
						<li><a href="<%=root%>/product/productInsert.jsp">상품 등록</a></li>
						<li><a href="<%=root%>/product/productList.jsp">상품 목록</a></li>
						<li><a href="<%=root%>/product/productRank.jsp">상품 검색(1)</a></li>
						<li><a href="<%=root%>/product/productSearch.jsp">상품 검색(2)</a></li>
					</ul>
		</li>
		<li>
			<a href="#">자유게시판</a>
			<ul>
				<li><a href="<%=root%>/board/boardWrite.jsp">게시글 작성</a></li>
				<li><a href="<%=root%>/board/boardList.jsp">게시글 목록</a></li>
				
			</ul>
		</li>
	</ul>
		</nav>
		<section>
    