<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>ajax file upload</h1>

<input type="file" name="f" accept=".jpg,.png,.gif">

 <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script>
	$(function(){
		$("input[name=f]").on("input",function(){
			//console.log(this.files);
			if(this.files&&this.files[0]){
			//if(this.files&&this.files.length>0){
				console.log("파일이 선택되었습니다.");
				
				//jquery ajax에서 파일 업로드를 하려면 formData 객체가 필요 
				var fd=new FormData();
				//fd.append(이름, 데이터 또는 파일 )
				fd.append("f",this.files[0]);
				//주의 : 반드시 ajax file upload 에서는 다음 세가지 설정을 해야 함 
				//1. processData : false 설정 
				//2. contentType : false 설정 
				//3. type : "post" 설정 
				$.ajax({
					url:"${pageContext.request.contextPath}/data/student/upload",
					type:"post",
					processData:false,
					contentType:false,
					data:fd,
					success:function(resp){
						window.alert("업로드 완료");
					},
					error:function(){
						window.alert("업로드 실패");
					}
				});
				
				
			}else{
				console.log("파일 선택이 취소되었습니다.");
			}
		});
		
	});
</script>
