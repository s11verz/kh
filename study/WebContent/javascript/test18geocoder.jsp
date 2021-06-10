<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>카카오 지도 불러오기</title>
	<style>
		.kakao-map {
			border:1px solid black;
			width:500px;
			height:400px;
		}
	</style>
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=f57a5e791dbd78116ad7a86d5b20eb21&libraries=services"></script>
	<script>
		var map;//전역변수(Global Variable, 페이지 전체에 영향을 미치는 변수)
		
		function loadMap(){
			
			//지도를 표시할 영역을 선택하는 코드
			var container = document.querySelector(".kakao-map");
			
			//지도의 표시 옵션을 설정하는 코드
			var options = {
				center: new kakao.maps.LatLng(37.566286, 126.977929), //지도의 중심좌표.
				level: 3 //지도의 레벨(확대, 축소 정도)
			};
			//지도 생성 및 객체 리턴 코드
			map = new kakao.maps.Map(container, options); 
		}
		
		function searchAddress(){
			//1. 주소창의 입력값을 불러온다.
			var addressInput = document.querySelector("input[name=address]");
			var address = addressInput.value;
			
			//2. 입력값이 올바른지 검사한다(미입력 배제, 유연한 검사)
			//if(address == false){
			if(!address){
				window.alert("주소를 입력하세요");
				return;
			}
			
			//3. 입력값이 올바르다면 카카오 Geocoder를 이용하여 검색을 수행한다
			// 주소-좌표 변환 객체를 생성합니다
			var geocoder = new kakao.maps.services.Geocoder();
			// 주소로 좌표를 검색합니다
			geocoder.addressSearch(address, function(result, status) {
			    // 정상적으로 검색이 완료됐으면 
			     if (status === kakao.maps.services.Status.OK) {
			        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
			        // 결과값으로 받은 위치를 마커로 표시합니다
			        var marker = new kakao.maps.Marker({
			            map: map,
			            position: coords
			        });
			        // 인포윈도우로 장소에 대한 설명을 표시합니다
			        var infowindow = new kakao.maps.InfoWindow({
			            content: '<div style="width:150px;text-align:center;padding:6px 0;">'+address+'</div>'
			        });
			        infowindow.open(map, marker);
			        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
			        map.setCenter(coords);
			    } 
			});    
		}
	</script>
</head>
<!-- onload는 로딩이 완료된 시점을 의미한다 -->
<body onload="loadMap();">
	<input type="text" name="address" placeholder="주소 입력">
	<input type="button" value="검색" onclick="searchAddress();">
	<hr>
	<div class="kakao-map"></div>
</body>
</html>