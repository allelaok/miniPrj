<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
    
<c:set var="contextPath" value="${pageContext.request.contextPath }"></c:set>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>cartList.jsp</title>
	<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script>
	function gotoList(){
		document.location="${contextPath}/member/listMembers.do"; 
	}
	</script>
<style>
	table {
		text-align: center;
		width: 100%;
	}
	th, td {
		padding: 10px;
	}
</style>
</head>
<body>
	<table border="1">
		<thead>
			<tr>
				<th>제품</th>
				<th>수량</th>	
				<th>가격</th>
				<th>수정/삭제</th>
				<th>조회</th>
			</tr>
		</thead>
		<tbody>
				<c:forEach var="cart" items="${cartList}">
						<tr>
							<td>${ cart.productno }</td>
							<td><input type="number" value="${cart.quantity }"/></td>
							<td>800,000</td>
							<td>
								<input type="button" value="수정">
								<input type="button" value="삭제">
							</td>
							<td><a href="productDetail.jsp">상세보기</a></td>
						</tr>
				</c:forEach>
					<tr>
						<td colspan="4">총 주문금액 : 800,000원</td>
						<td><input type="button" value="주문하기"></td>
					</tr>
		</tbody>

	</table>
</body>
</html>