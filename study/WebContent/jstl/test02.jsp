<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%-- JSTL을 사용하고 싶은 페이지마다 따로 등록 설정을 해주어야 한다. --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
	권장하지는 않지만 필요한 경우에는 변수를 만들 수 있어야 한다.
	- ex : context path 등
	
	JSTL에서 만든 데이터들은 전부다 pageScope로 접근이 가능하다.
	JSTL은 자료형을 구분하지 않는다.
--%>

<c:set var="a" value="10"></c:set>
<%
	//참고 : 위의 코드는 자바로 다음 코드와 같다
	//pageContext.setAttribute("a", 10);
%>

<h1>a = <%=pageContext.getAttribute("a")%></h1>
<h1>a = ${pageScope.a}</h1>
<h1>a = ${a}</h1>

<c:set var="b" value="hello"/>
<h1>b = ${b}</h1>

<%-- EL만으로 출력할 경우 HTML과 관련된 글자들이 해석이 되는 현상이 발생하므로 c:out을 사용하는 것이 좋다 --%>
<c:set var="c" value="<h1>hello</h1>"></c:set>
<h1>c = ${c}</h1>
<h1>c = <c:out value="${c}"></c:out></h1>



