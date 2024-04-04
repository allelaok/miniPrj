<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
    
<c:set var="contextPath" value="${pageContext.request.contextPath }"></c:set>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 상세 페이지</title>
<style type="text/css">
* {
	font-size: 9pt;
}

btn {
	text-align: center;
}

table thead tr th {
	background-color: gray;
}

.custom-text {
    width: 40px;
}

.custom-image {
	width: 100px;
	height: 100px;
    vertical-align: middle;
}
</style>

<script type="text/javascript">
	function gotoCart(){
		alert("장바구니에 담았습니다.");
		
	}
</script>

</head>
<body>
	<table border="1">
		<colgroup>
			<col width="150" />
			<col width="80" />
			<col width="150" />
		</colgroup>
		<thead>
		<tr>
			<th colspan="3">${product.name}</th>
		</tr>
		</thead>
	
		<tr>
			<td style="text-align: center;"><img src="${contextPath}/images/SKY.jpeg" class="custom-image"></td>
			<td>
			<b>상품이름 : ${product.name}</b><br>
			<b>가 격 : </b>${product.price}원<br>
			<b>수 량 : </b><input type="number" value="${product.stock}" class="custom-text">개<br>
			<btn><input type="button" value="장바구니 담기" onclick="gotoCart()"></btn><br>
			</td>
			<td style="vertical-align: top;">
			<b>상세설명</b><br>
			<br>
			${product.detail}
			</td>
		</tr>
		
	</table>
</body>
</html>