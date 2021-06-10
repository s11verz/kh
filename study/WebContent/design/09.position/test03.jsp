<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
	.loading-modal{
		position:fixed;
		top:0;
		left:0;
		right:0;
		bottom:0;
		
	}
	.loading-modal>.loading-icon{
		width:100px;
		height:100px;
		position:fixed;
		top:50%;
		left:50%;
		margin-left:-50px;
		margin-top:-50px;
	}
</style>

<a href="http://www.naver.com">검색하기</a>
<a href="http://www.naver.com">취소하기</a>
<div class="loading-modal">
<img src="/study/image/loading.gif" class="loading-icon">
</div>