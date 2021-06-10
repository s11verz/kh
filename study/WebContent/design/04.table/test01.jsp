<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>테이블 스타일링</title>
	<link rel="stylesheet" type="text/css" href="/study/design/common.css">
	<style>
	.table {
			width:100%;
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
		.table.table-border > thead > tr > th, 
		.table.table-border > thead > tr > td,
		.table.table-border > tbody > tr > th,
		.table.table-border > tbody > tr > td,
		.table.table-border > tfoot > tr > th,
		.table.table-border > tfoot > tr > td {
			border: 1px solid black;
		}
		.table.table-hover > thead > tr,		
		.table.table-hover > tbody > tr:hover {
			background-color:rgb(231, 241, 253);
		}
		
		.table.table-striped > thead > tr,
		.table.table-striped > tbody > tr:nth-child(2n) {
			background-color:rgb(231, 241, 253);
		}
	</style>
</head>
<body>
	
	<div class="container-600">
		<div class="row text-center">
			<h1>오늘의 날씨</h1>
		</div>
		<div class="row">
			<table class="table table-border table-striped"> 
				<thead>
					<tr>
						<th>지역</th>
						<th>현재기온</th>
						<th colspan="2">불쾌지수/습도(%)</th>
						<th>풍속</th>
					</tr> 
				</thead>
				
				<tbody>
					<tr>
						<td rowspan="2">서울/경기</td>
						<td>23</td>
						<td>60</td>
						<td>80</td>
						<td>4.7</td>
					</tr>
					<tr>
						<td>20</td>
						<td>60</td>
						<td>80</td>
						<td>5.0</td>
					</tr>
					<tr>
						<td>제주도</td>
						<td>21</td>
						<td>65</td>
						<td>85</td>
						<td>3.6</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	
</body>
</html>