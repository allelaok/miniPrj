<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문 상세 페이지</title>
</head>
<body>
	<form action="" method="post">
		<table align="center" border="1" summary="상품 수정">
			<colgroup>
				<col width="500">
				<col width="500">
			</colgroup>
			<thead>
				<tr>
					<th colspan="2" align="center" >주문상세내역</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td align="center">고객아이디</td>
					<td><c:out value='${member.id}' /></td>
				<tr>
					<td align="center">주문번호</td>
					<td><c:out value='${order.no}' /></td>
				</tr>
				<tr>
					<td align="center">제품번호</td>
					<td><c:out value='${order.no}' /></td>
				</tr>
				<tr>
					<td align="center">제품이름</td>
					<td><c:out value='${order.name}' /></td>
				</tr>
				<tr>
					<td align="center">제품가격</td>
					<td><c:out value='${order.price}' /></td>
				</tr>
				<tr>
					<td align="center">주문수량</td>
					<td><c:out value='${order.count}' /></td>
				</tr>
				<tr>
					<td align="center">재고수량</td>
					<td><c:out value='${product.count}' /></td>
				</tr>
				<tr>
					<td align="center">주문날짜</td>
					<td><c:out value='${order.date}' /></td>
				</tr>
				<tr>
					<td align="center">금액</td>
					<td><c:out value='${total.price}' /></td>
				</tr>
				<tr>
					<td align="center">주문상태</td>
					<td align="center"><select name="state">
							<option value="APPLY_ING"
								${orderModel.state eq 'APPLY_ING' ? 'selected' : ''}>접수중</option>
							<option value="APPLY"
								${orderModel.state eq 'APPLY' ? 'selected' : ''}>접수</option>
							<option value="PAY"
									${orderModel.state eq 'PAY' ? 'selected' : ''}>입금확인</option>
							<option value="DELIVERY_READY"
									${orderModel.state eq 'DELIVERY_READY' ? 'selected' : ''}>배송준비</option>
							<option value="DELIVERY"
								${orderModel.state eq 'APPLY' ? 'DELIVERY' : ''}>배송</option>
							<option value="COMPLETE"
								${orderModel.state eq 'APPLY' ? 'COMPLETE' : ''}>완료</option>
					</select>
			
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						name="update" value="수정"> / <input type="reset" value="삭제">
					</td>
				</tr>



			</tbody>

		</table>
	</form>

</body>
</html>