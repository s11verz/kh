<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/design/common.css">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script>
	
	$(".check-item").click(function(){
		var str="";
		$(".check-item").each(function(){
			if($(this).is(":checked")){
				str+=$(this).val()+"";
			}
		});
		$("#result").text(str);
	});
</script>
</head>
<body>
	<div>가장 재미있었던 과목은?(복수선택 가능)</div><br>
	<form>
		<input type="checkbox" name="subject" class="check-item" value="자바">자바<br>
		<input type="checkbox" name="subject" class="check-item" value="데이터베이스">데이터베이스<br>
		<input type="checkbox" name="subject" class="check-item" value="JSP/Servlet">JSP/Servlet<br>
		<input type="checkbox" name="subject" class="check-item" value="HTML/CSS">HTML/CSS<br>
		<input type="checkbox" name="subject" class="check-item" value="Javascript/jQuery">Javascript/jQuery<br><br>
		
		<button onclick="getCheckboxValue()">제출</button>
		
		<hr>
		<span id="result"></span>
	</form>
	
</body>

</html>