<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/study/design/common.css">
</head>
<style>
main,aside,section,header,footer{
border:1px solid black;
	}
.head{
text-align:center;
padding:3rem 0rem;
font-size:30px;
}
header{
background-color:silver
}
.nevigation{
list-style:none;
margin:0px;
padding:0px;
text-align:center;
border-top:1px solid black;
background-color:lightgray;
}
.nevigation>li{
display:inline-block;
padding:0.5rem 2rem;

text-decoration:underline;
}
aside{
float:left;
width:20%;
min-height:500px;
background-color:lightgray;
}
section{
float:left;
width:100%;
min-height:500px;
}

.title{
text-align:center;
font-size:20px;
font-weight:bold;
}
.table{
width:70%;
text-align:center;
}
.table>thead{
background-color:lightgray;
}
.table > thead > tr > th, 
		.table > thead > tr > td,
		.table > tbody > tr > th,
		.table > tbody > tr > td,
		.table > tfoot > tr > th,
		.table > tfoot > tr > td {
			padding:0.5rem;
		}
.table.table-border {
			border: 1px solid black;
			border-collapse: collapse; 
		}
.search{
text-align:center;
}
.pagination-list{
list-style:none;
margin:0px;
padding:0px;
}
.page{
text-align:center;
}
.pagination-list>li{
display:inline-block;
min-width:35px;
border:none;
backgrond-color:lightgray;
color:black;
}
.pagination-list>li.on{
background-color:gray;
color:white;
}
.footer-message{
text-align:center;
}
aside>div{
padding-top:1rem;
padding-bottom:1rem;
}

</style>
<body>
<main>
<header>
<div class="head">도서 정보 관리 프로그램 ver 1.0</div>
<nav>
<ul class="nevigation">
<li>도서등록</li>
<li>도서목록조회/수정</li>
<li>도서주문등록</li>
<li>도서주문조회</li>
<li>매출조회</li>
<li>홈으로</li>
</ul>
</nav>
</header>

<section>

<aside>
<div>관리메뉴</div>
<div>-주문조회</div>
<div>-재고현황</div>
<div>-재고현황</div>
<div>-거래처현황</div>
</aside>
<article>
	<div class="title"><h1>도서 주문조회</h1></div>
	<div class="search">
		<select name="검색분류"><option value="검색분류">검색분류</option></select>
		<input type="text" placeholder="내용을 입력해주세요">
		<input type="submit" value="검색">
	</div>
	<div class="row">
		<table class="table table-border container-center">
			<thead>
				<tr>
				<th>주문일</th>
				<th>주문순서</th>
				<th>도서번호</th>
				<th>도서수량</th>
				<th>판매금액</th>
				<th>주문자</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>2019-09-27</td>
					<td>1</td>
					<td>200002</td>
					<td>5</td>
					<td>58,500</td>
					<td>뽀로로</td>
				</tr>
				<tr>
					<td>2019-09-27</td>
					<td>2</td>
					<td>100001</td>
					<td>1</td>
					<td>14,400</td>
					<td>뽀로로</td>
				</tr>
				<tr>
					<td>2019-09-22</td>
					<td>1</td>
					<td>200002</td>
					<td>3</td>
					<td>35,100</td>
					<td>파라오</td>
				</tr>
				<tr>
					<td>2019-09-22</td>
					<td>2</td>
					<td>300001</td>
					<td>15</td>
					<td>513,000</td>
					<td>뽀로로</td>
				</tr>
				<tr>
					<td>2019-09-22</td>
					<td>3</td>
					<td>300001</td>
					<td>12</td>
					<td>410,400</td>
					<td>타잔</td>
				</tr>
				<tr>
					<td>2019-09-22</td>
					<td>4</td>
					<td>300002</td>
					<td>1</td>
					<td>54,000</td>
					<td>슈퍼맨</td>
				</tr>
			</tbody>
		</table>
	</div>
	<div class="page">
		<ol class="pagination-list">
			<li>&lt;</li>
			<li>1</li>
			<li class="on">2</li>
			<li>3</li>
			<li>4</li>
			<li>&gt;</li>
		</ol>
	</div>
</article>
</section>
<footer>
<div class="footer-message">KH 정보교육원 황인빈 강사 ⓒ2021 All right reserved.</div>
</footer>
</main>
</body>
</html>