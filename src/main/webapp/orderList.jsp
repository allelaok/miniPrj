<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구매 목록 페이지</title>
<style type="text/css">
* {
	font-size: 9pt;
}

table thead tr th {
	background-color: gray;
}

td {
	text-align: center;
}

.custom-btn{
	background-color: transparent;
	border: none;
}

</style>
</head>
<body>

	<table border="1">
		<colgroup>
			<col width="80" />
			<col width="80" />
			<col width="80" />
			<col width="80" />
			<col width="80" />
			<col width="80" />
			<col width="80" />

			
		</colgroup>
		<thead>
		<tr>
			<th>주문번호</th>
			<th>주문자</th>
			<th>제품</th>
			<th>주문수량</th>
			<th>주문날짜</th>
			<th>주문상태</th>
			<th>상태보기</th>
		</tr>
		</thead>
		
		<c:forEach var="order" items="${orderArray}">
			<tr>
				<td>${order.no}</td>
				<td>${order.id}</td>
				<c:forEach var="product" items="${productArray}">
					<c:if test="${order.productno eq product.no}">
					<td>${product.name}</td>
					</c:if>
				</c:forEach>
				<td>${order.quantity}</td>
				<td>${order.date}</td>
				<td>${order.state}</td>
				<td><input type="button" value="상태보기" class="custom-btn"></td>
			</tr>
		</c:forEach>
		
		<!-- Obsolete -->
			<tr>
				<td>test</td>
				<td>test</td>
				<td>test</td>
				<td>test</td>
				<td>test</td>
				<td>test</td>
				<td><input type="button" value="상태보기" class="custom-btn"></td>
			</tr>
		<!-- /Obsolete -->
		
	</table>
</body>
</html>