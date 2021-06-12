<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
	EL
	= Expression Language. 표현 언어
	= 표현식을 간편하게 만들기 위한 언어
	= MVC Pattern 2에서 값을 쉽게 출력하는 것이 목표
	= ${값} 또는 ${식} 의 형태로 사용한다
	= 표현식의 대부분의 기능이 표현 언어로 대체 가능하다
	
	= (주의) 스크립트릿의 변수를 출력할 수 없다.
	= 의존성(el-api.jar) - 톰캣에 내장되어 있다
--%>

<%
	int a = 10;
%>

<h1><%=a%> , ${a}</h1>
<h1><%=10 + 20%> , ${10 + 20}</h1>
<h1><%=10 * 20%> , ${10 * 20}</h1>
<h1><%=10 == 20%> , ${10 == 20} , ${10 eq 20}</h1>
<h1><%="java".equals("python")%> , ${"java" == "python"} , ${'java' == 'python'} , ${"java" eq "python"}</h1>






