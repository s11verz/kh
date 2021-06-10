<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.kakao-map{
		border:1px solid black;
		width:500px;
		height:400px;
	}
</style>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=5377ab23c34abd4aae999578b43adff2"></script>
<script>
	function loadMap(){
		var container = document.querySelector(".kakao-map"); //지도를 담을 영역의 DOM 레퍼런스
		var position=new kakao.maps.LatLng(37.566286, 126.9779)
		
		var options = { //지도를 생성할 때 필요한 기본 옵션
			center: position, //지도의 중심좌표.
			level: 3 //지도의 레벨(확대, 축소 정도)
		};

		var map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴
		//var markerPosition  = new kakao.maps.LatLng(33.450701, 126.570667); 

		// 마커를 생성합니다
		var marker = new kakao.maps.Marker({
		    position: position
		});
		marker.setMap(map);
	}
	
</script>
</head>
<body onload="loadMap();">
	<div class="kakao-map"></div>
</body>
</html>