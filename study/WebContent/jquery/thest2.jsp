<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="kr">
<head>
  <meta charset="UTF-8">
  <title>Document</title>
  <style>
    .tab{
      overflow: hidden;
      border: 1px solid #ccc;
      background-color: #f1f1f1;
    }
    .tab > div{
      float: left;
      width: 100px;
      height: 50px;
      line-height: 50px;
      text-align: center;
      cursor: pointer;
      font-size: 17px;
    }
    .tab > div:hover{
      background-color: #ddd;
    }
    .tabcontent{
      padding: 10px;
      border: 1px solid #ccc;
      border-top: none;
      display: none;
    }
  </style>
</head>
<body>
  <h2>탭메뉴를 선택해보세요</h2>
  <hr>
  <div class="tab">
    <div class="tablink on" onclick="changeTab(this);">html</div>
    <div class="tablink" onclick="changeTab(this);">css</div>
    <div class="tablink" onclick="changeTab(this);">javascript</div>
  </div>
  <div id="html" class="tabcontent">
    <h3>HTML</h3>
    <p>HyperText Markup Language</p>
  </div>
  <div id="css" class="tabcontent">
    <h3>CSS</h3>
    <p>Cascading Style Sheet</p>
  </div>
  <div id="javascript" class="tabcontent">
    <h3>JAVASCRIPT</h3>
    <p>JAVASCRIPT</p>
  </div>
  <script>
    var tabs = document.getElementsByClassName('tablink');
    var content = document.getElementsByClassName('tabcontent');
    tabs[0].click();
    function changeTab(obj){      
      for(var i=0;i<3;i++){
    	  
        tabs[i].style.backgroundColor="#f1f1f1";
        content.classList.remove("on");
        tabs.classList.add("on");
       
      }
      
      obj.style.backgroundColor="#ccc";      
      var selectTab = document.getElementById(obj.innerHTML);
      selectTab.style.display="block";
    }
  </script>
</body>
</html>