
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


    <table>
    	<thead>
    		<tr>
    			<th>상품번호 </th>
    			<th>상품이름 </th>
    			<th>상품유형 </th>
    			<th>상품가격 </th>
    			<th>만든날짜 </th>
    			<th>유통기한 </th>
    		</tr>
    	</thead>
    	<tbody>
    		<tr>
    			<td>${productDto.no}</td>
    			<td>${productDto.name}</td>
    			<td>${productDto.type}</td>
    			<td>${productDto.price}</td>
    			<td>${productDto.made}</td>
    			<td>${productDto.expire}</td>
    		</tr>
    	</tbody>
    </table>