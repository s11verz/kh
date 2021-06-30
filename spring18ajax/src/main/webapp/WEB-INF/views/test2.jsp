<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>비동기 통신 화면 구현</title>

    <!-- bootstrap 이용을 위한 CSS 의존성 등록 -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
    <style>
		.product-item{
			border: 1px solid lightgray;
		}
    </style>

    <!-- bootstrap 이용을 위한 JS 의존성 등록 (jQuery/popper/BS) -->
    <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js" integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF" crossorigin="anonymous"></script>
    <script>
		$(function(){
			//테스트1 : #search-btn을 누르면 목록 조회 요청을 발생 
			$("#search-btn").click(function(){
				$.ajax({
					url:"${pageContext.request.contextPath}/data/product/list1",
					//url:"../data/product/list1",
					//data:{},
					type:"get",
					dataType:"json",
					success:function(resp){
							//console.log("성공");
							//console.log(resp);
							$("#search-result").empty();
							//첫번째 방법 : 문자열로 작성하여 추가(가장 비효율적)
							for(var i=0;i<resp.length;i++){
							var content="";
							
							$("#search-result").append(content);
							}
					
					},
				});
			});
		});
    </script>

</head>
<body>
    
    <!-- 컨테이너 시작 -->
    <div class="container-fluid">
    
    	<!-- 점보트론 시작 -->
    	<div class="jumbotron text-center mt-3">
    		<h1>상품 찾아보기</h1>
    	</div>
    	<!-- 점보트론 종료 -->
    	
    	<!-- 검색화면 시작 -->
    	<div class="row">
    		<div class="col-md-10">
    			<button id="search-btn"class="btn btn-outline-primary">조회</button>
    		</div>
    	</div>
    	<!-- 검색화면 종료 -->
    	
    	<!-- 검색결과 시작 -->
    	<div class="row mt-5" id="search-result">
    		<!-- 아이템 시작 -->
    		<div class="col-md-4 col-sm-6">
	    		<div class="row product-item">
	    			<div class="col-4 p-2">
	    				<img src="https://via.placeholder.com/100x100?test=P" width="100%">
	    			</div>
	    			<div class="col-8 p-2">
	    				<div class="row">
	    					<div class="col-12">스크류바</div>
	    				</div>
	    				<div class="row">
	    					<div class="col-12">아이스크림</div>
	    				</div>
	    				<div class="row">
	    					<div class="col-12">판매가: 00원</div>
	    				</div>
	    			</div>
	    		</div>
    		</div>
    		<!-- 아이템 종료 -->
    	</div>
    	<!-- 검색결과 종료 -->
    </div>
    <!-- 컨테이너 종료 -->
    
</body>
</html>



















