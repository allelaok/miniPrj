<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문 관리 페이지</title>
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
<c:import url="/component/adminHeader.jsp" />
	<form action="" method="post">
		<table border="1" summary="주문 내역 리스트 관리">
			<colgroup>
				<col width="100">
				<col width="80">
				<col width="60">
				<col width="100">
				<col width="100">
				<col width="100">
				<col width="100">

			</colgroup>
			<thead>
				<tr>
					<th>주문번호</th>
					<th>주문자</th>
					<th>제품</th>
					<th>주문수량</th>
					<th>주문날짜</th>
					<th>주문상태</th>
					<th>상세보기</th>
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
								<!-- 주문 번호 -->
								<td><c:out value="${order.no}" /></td>

								<!-- 주문자 -->
								<td><c:out value="${order.id}" /></td>

								<!-- 제품 -->
								<td><c:out value="${order.productname}" /></td>
																
								<!-- 주문수량 -->
								<td><c:out value="${order.quantity}" /></td>

								<!-- 주문날짜 -->
								<td><c:out value="${order.date}" /></td>

								<!-- 주문상태 -->
								<td><c:out value="${order.state}" /></td>

								<!-- 상세보기 -->
								<td><a
									href="${contextPath}/admin/orderDetail.do?id=${order.id}">상세보기</a></td>
							</tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>

			</tbody>
			<tfoot>
				<!-- 페이지 번호 -->
				<tr>
					<td align="center" colspan="5"><c:out value="${pageNavigator}"
							escapeXml="false" /></td>
				</tr>
			</tfoot>
		</table>
	</form>
	<c:import url="/component/adminFooter.jsp" />
</body>
</html>