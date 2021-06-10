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
      $(function(){
         
         $(".signup").on("click", function(e){
            
            if($("#id").val() == $("#name").val()){
               window.alert("아이디와 이름의 값은 일치하면 안됩니다");
               e.preventDefault();
            }
            
            var count = 0;
            $(".check-subject").each(function(){
               var current = $(this).prop("checked");
               if(current){
                  count += 1;
               }
            });
            
            console.log(count);
            if(count < 2){
               window.alert("취미는 2개 이상 선택하세요");
               e.preventDefault();
            }
            

            var tel = $("#tel").val();
            var regex = /^0[0-9]{1,2}-[0-9]{3,4}-[0-9]{4}$/;
            if(!regex.test(tel)){
               window.alert("전화번호 형식을 확인하세요");
               $("#tel").val("");
               $("#tel").focus();
               e.preventDefault();
            }
            if($("#tel").val() == null){
               e.preventDefault();
            }
         });
         
         
      });
   </script>
</head>
<body>
   <form action="result.html" method="post">
   
      아이디:<input type="text" name="id" id="id" required><br>
      이름:<input type="text" id="name"required><br>
      
      
      취미:
      <div class="row">
       
         <input type="checkbox" class="check-subject" id="piano" data-subject="피아노">
         <label for="piano">피아노</label> <br>
         
         <input type="checkbox" class="check-subject" id="game" data-subject="게임">
         <label for="game">게임</label> <br>
         
         <input type="checkbox" class="check-subject" id="tennis" data-subject="테니스">
         <label for="tennis">테니스</label> <br>
         
         <input type="checkbox" class="check-subject" id="climbing" data-subject="등산">
         <label for="climbing">등산</label> <br>

      </div>
      <label for ="tel">전화번호</label>
      <input type="text" name="tel" id="tel" required>
      <br>
      <input type="submit" value="회원가입" class="signup">
      <input type="reset" value="취소">
   </form>

</body>
</html>