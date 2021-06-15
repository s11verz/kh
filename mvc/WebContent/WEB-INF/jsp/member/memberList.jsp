<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:forEach var="memberDto" items="${list }">
	<div>
		${memberDto.memberNo}
		${memberDto.memberId}
		${memberDto.memberPw}
		${memberDto.memberNick}
		${memberDto.memberBirth}
		${memberDto.memberPhone}
		${memberDto.memberJoin}
		${memberDto.memberEmail}
		${memberDto.memberPoint}
		${memberDto.memberGrade}
	</div>
</c:forEach>
