<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이미지 스타일링</title>
<link rel="stylesheet" type="text/css" href="/study/design/common.css">
<style>
.image{

}
/*image라고 써진 애들 중에서 image-circle을 찾아라*/
.image.image-circle{
border-radius:50%;
}
.image.image-frame{
border:2px solid gray;
}
.image.image-shadow{
/*box-shadow: x위치 y위치 번짐정도 퍼짐정도 색상*/
box-shadow: 0px 0px 4px 4px gray;
}
.image.image-blur{
/*opacity:1 - 선명 0-투명*/
opacity:0.5;
}
.image.image-blur:hover{
/*마우스가 올라가면 선명도 1*/
opacity:1;
}
.image.image-leaf{
border-top-left-radius: 50%;
border-bottom-right-radius: 50%;
}
</style>
</head>
<body>
<img class="image image-circle" alt="귀여운 동물" src="/study/image/animal.jpg" width="200" height="200">
<img class="image image-frame" alt="귀여운 동물" src="/study/image/animal.jpg" width="200" height="200">
<img class="image image-circle image-frame" alt="귀여운 동물" src="/study/image/animal.jpg" width="200" height="200">
<img class="image image-shadow" alt="귀여운 동물" src="/study/image/animal.jpg" width="200" height="200">
<img class="image image-blur" alt="귀여운 동물" src="/study/image/animal.jpg" width="200" height="200">
<img class="image image-circle image-frame image-blur" alt="귀여운 동물" src="/study/image/animal.jpg" width="200" height="200">
<img class="image image-leaf" alt="귀여운 동물" src="/study/image/animal.jpg" width="200" height="200">
<img class="image" alt="귀여운 동물" src="/study/image/animal.jpg" width="200" height="200">
<img alt="귀여운 동물" src="/study/image/animal.jpg" width="200" height="200">
<img alt="귀여운 동물" src="/study/image/animal.jpg" width="200" height="200">
</body>
</html>