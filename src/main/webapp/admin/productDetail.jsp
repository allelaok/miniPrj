<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
    
<c:set var="contextPath" value="${pageContext.request.contextPath }"></c:set>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 상품 상세 페이지</title>
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
			<th colspan="3">SKY폰</th>
		</tr>
		</thead>
	
		<tr>
			<td style="text-align: center;"><img src="${contextPath}/images/SKY.jpeg" class="custom-image"></td>
			<td>
				<table border="1">			
					<tr><td><b>상품이름 : </b>SKY폰</td></tr>
					<tr><td><b>가 격 : </b>800,000원</td></tr>
					<tr><td><b>입고날짜 :</b>2305454545454544</td></tr>
					<tr><td><b>재 고 : </b>45</td></tr>
				</table>
			</td>
			<td style="vertical-align: top;">
			<b>상세설명</b><br>
			<br>
			SKY폰 상세설명
			</td>
		</tr>
		
		<tr>
				<td colspan="3" style="text-align:center;">
					<input type="button" value="수정하기" onclick="gotoUpdate()">
					<input type="button" value="삭제하기" onclick="gotoDelete()">
				</td>
			</tr>
		
	</table>
</body>
</html>