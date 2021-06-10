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
	var map;

	function loadMap(){
		var container = document.querySelector(".kakao-map"); //지도를 담을 영역의 DOM 레퍼런스
		var position=new kakao.maps.LatLng(37.566286, 126.9779)
		
		var options = { //지도를 생성할 때 필요한 기본 옵션
			center: position, //지도의 중심좌표.
			level: 3 //지도의 레벨(확대, 축소 정도)
		};

		map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴
		//var markerPosition  = new kakao.maps.LatLng(33.450701, 126.570667); 

		// 마커를 생성합니다
		var marker = new kakao.maps.Marker({
		    position: position
		});
		marker.setMap(map);
	}
	function changeMapPosition(){
		var latInput=document.querySelector("input[name=lat]");
		var lngInput=document.querySelector("input[name=lng]");
		
		var lat=parseFloat(latInput.value);
		var lng=parseFloat(lngInput.value);
		
		var correct=lat&&lat>=0&&lat<=90&&lng&&lng>=0&&lng<=180;
		if(correct){
			var loc=new kakao.maps.LatLng(lat,lng);
			map.panTo(loc);
		}else{
			window.alert("올바른 위도, 경도를 입력하세요.");
		}
	}
	
</script>
</head>
<body onload="loadMap();">
	<input type="text" name="lat" placeholder="위도">
	<input type="text" name="lng" placeholder="경도">
	<input type="button" value="보기" onclick="changeMapPosition();">
	<div class="kakao-map"></div>
</body>
</html>