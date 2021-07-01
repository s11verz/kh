<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h1>ajax file upload</h1>

<input type="file" name="f" accept=".jpg, .png, .gif">
<br>
<img id="preview" width="200">

<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script>
	$(function(){
		$("input[name=f]").on("input", function(){
// 			console.log(this.files);
			
// 		if(this.files && this.files[0]){//파일 저장소 존재 및 0번 위치에 파일 존재
			if(this.files && this.files.length > 0){
				console.log("파일이 선택되었습니다");
				
// 				jquery ajax에서 파일 업로드를 하려면 formData 객체가 필요
				var fd = new FormData();
// 				fd.append(이름, 데이터또는파일);
				fd.append("f", this.files[0]);
				
				var that = this;//$("input[name=f]")
				
// 				(주의) 반드시 ajax file upload에서는 다음 세 가지 설정을 해야 한다.
//					1. processData : false 설정
//					2. contentType : false 설정
//					3. type : "post" 설정
				$.ajax({
					url:"${pageContext.request.contextPath}/data/student/upload2",
					type:"post",
					processData:false,
					contentType:false,
					data:fd,
					success:function(resp){
						//window.alert("업로드 완료!");
						//만약 초기화 하고 싶다면
						//$(that).val("");
						//console.log(resp);
						
						var url = "${pageContext.request.contextPath}/data/student/download/"+resp.profileNo;
						$("#preview").attr("src", url);
					},
					error:function(){
						window.alert("업로드 실패..");
					}
				});
			}
			else{
				console.log("파일 선택이 취소되었습니다");
			}
		});
	});
</script>


