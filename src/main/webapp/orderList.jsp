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

.custom-btn {
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


		</colgroup>
		<thead>
			<tr>
				<th>주문번호</th>
				<th>제품</th>
				<th>주문수량</th>
				<th>주문날짜</th>
				<th>주문상태</th>

			</tr>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="${empty orderList}">
					<tr>
						<td align=center colspan="7">주문내역이 없습니다.</td>
					</tr>
				</c:when>
				<c:otherwise>
				<c:forEach var="order" items="${orderArray}">
					<tr>
						<td>${order.no}</td>

						<c:forEach var="product" items="${productArray}">
							<c:if test="${order.productNo eq product.no}">
								<td>${product.name}</td>
							</c:if>
						</c:forEach>
						<td>${order.quantity}</td>
						<td>${order.date}</td>
						<td>${order.state}</td>
					</tr>
				</c:forEach>
				</c:otherwise>
				</c:choose>

				<!-- Obsolete -->

				<!-- /Obsolete -->
	</table>
</body>
</html>