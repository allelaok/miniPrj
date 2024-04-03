<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>cartList.jsp</title>
<style>
 table {
 	text-align: center;
 }
</style>
</head>
<body>
	<table border="1">
		<thead>
			<th>제품</th>
			<th>수량</th>
			<th>가격</th>
			<th>수정/삭제</th>
			<th>조회</th>
		</thead>
		<tbody>
			<tr>
				<td>SKY폰</td>
				<td><input type="number"></td>
				<td>800,000</td>
				<td>
					<input type="button" value="수정">/
					<input type="button" value="삭제">
				</td>
				<td>상세보기</td>
			</tr>
			<tr>
				<td colspan="4">총 주문금액 : 800,000원</td>
				<td>주문하기</td>
			</tr>
		</tbody>

	</table>
</body>
</html>