<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jQuery</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/design/common.css">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script>
	$(function(){
		$(".confirm-link").on("click",function(){
			var choice=window.alert("정말 이동하시겠습니까?");
			if(choice){
				return true;
			}else{
				return false;
			}
		});
	});
</script>
</head>
<body>
	<a class="confirm-link" href="http://www.naver.com">네이버로 이동</a>
</body>
</html>