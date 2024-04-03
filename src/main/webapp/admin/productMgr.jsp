<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 상품 목록 페이지</title>
<style type="text/css">
* {
	font-size: 9pt;
}

p {
	width: 600px;
	text-align: right;
}

table thead tr th {
	background-color: gray;
}

td {
	text-align: center;
}

input{
    background-color: transparent;
    border: none;
}

</style>
</head>
<body>


	<table border="1">
		<colgroup>
			<col width="50" />
			<col width="80" />
			<col width="150" />
			<col width="40" />
			<col width="100" />
		</colgroup>
		<thead>
		<tr>
			<th>이름</th>
			<th>가격</th>
			<th>날짜</th>
			<th>재고</th>
			<th>상세보기</th>
		</tr>
		</thead>
		<c:forEach var="product" items="${productArray}">
			<tr>
				<td>${product.name}</td>
				<td>${product.price}</td>
				<td>${product.date}</td>
				<td>${product.stock}</td>
				<td><input type="button" value="상세보기"></td>
			</tr>
		</c:forEach>
		
		<!-- Obsolete -->
			<tr>
				<td>test</td>
				<td>test</td>
				<td>test</td>
				<td>test</td>
				<td><input type="button" value="상세보기"></td>
			</tr>
		<!-- /Obsolete -->
		
		<tr>
			<td colspan="5">
				<input type="button" value="상품등록">
			</td>
		</tr>
		
	</table>
	
</body>
</html>