<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문 관리 페이지</title>
</head>
<body>
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
					<c:when test="${orderCount == 0 }">
						<%-- if() 부분 --%>
						<tr>
							<td align=center colspan="5">주문내역이 없습니다.</td>
						</tr>
					</c:when>

					<c:otherwise>
						<%-- else 부분 --%>
						<c:forEach var="order" items="${orderList}" varStatus="status">
							
							<tr>
								<!-- 주문 번호 -->
								<td align="center"><c:out
										value="${orderCount - (status.index+1) + 1 - (orderModel.pageNum - 1) * orderModel.listCount}" />

								<!-- 주문자 -->
								<td align="center"><c:out value="${order.member}" /></td>

								<!-- 제품 -->
								<td align="center"><c:out value="${order.product}" /></td>

								<!-- 주문수량 -->
								<td align="center"><c:out value="${order.count}" /></td>

								<!-- 주문날짜 -->
								<td align="center"><c:out value="${order.date}" /></td>
								
								<!-- 주문상태 -->
								<td align="center"><c:out value="${order.state}" /></td>
								
								<!-- 상세보기 -->
								<td align="center"><c:out value="${order.detail}" /></td>
								
							</tr>
						</c:forEach>

					</c:otherwise>
				</c:choose>
			</tbody>
		</table>
	</form>
</body>
</html>