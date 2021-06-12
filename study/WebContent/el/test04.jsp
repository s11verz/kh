<%@page import="study.beans.QuizDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%--
	EL의 객체 접근
	= 경우에 따라서는 request, session 등에 "객체" 가 들어갈 수 있다.
	= (ex) DTO , List , ...
	
	= 변수명을 작성하면 getter 메소드로 자동 변환하여 처리해준다
	= 메소드명을 직접 호출하여 사용하는 것도 가능하다
	= (주의) setter 메소드는 부를 수 없으며 불러봤자 의미가 없다.
--%>

<%
	//테스트를 위해 DTO를 만들어서 첨부
	QuizDto quizDto = new QuizDto();
	quizDto.setQuizNo(5);
	
	quizDto.setQuizContent("천만명이 말을 하면?");
	
	request.setAttribute("quizDto", quizDto);
%>

<h1>quizNo : <%=((QuizDto)request.getAttribute("quizDto")).getQuizNo()%></h1>
<h1>quizContent : <%=((QuizDto)request.getAttribute("quizDto")).getQuizContent()%></h1>

<h1>quizNo : ${requestScope.quizDto.getQuizNo()}</h1>
<h1>quizNo : ${quizDto.getQuizNo()}</h1>
<h1>quizNo : ${quizDto.quizNo}</h1>

<h1>quizContent : ${quizDto.quizContent}</h1>

