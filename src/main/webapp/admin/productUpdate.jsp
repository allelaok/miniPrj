<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 수정 페이지</title>
</head>
<body>
	<form action="" method="post">
		<table border="1" summary="상품 수정">
			<colgroup>
			<col width="150">
			<col width="500">
			
			</colgroup>
			

			<tbody>
				<tr>
					<td colspan="2" align="center">상품 등록(update)</td>
				<tr>
					<th align="center">상품이름</th>
					<td><input type="text" name="pname" value="<c:out value='${member.id}' />"/></td>
				</tr>
				<tr>
					<th align="center">상품가격</th>
					<td><input type="text" name="pname" value="<c:out value="${product.price}"/>"/></td>
				</tr>
				<tr>
					<th align="center">상품설명</th>
					<td><textarea name="pcontents" cols="100" rows="30" value="<c:out value="${product.count}"/>"/></textarea></td>
				</tr>
				<tr>
					<th align="center">상품수량</th>
					<td><input type="text" name="pcount" value="<c:out value="${product.count}"/>"/>개</td>
				</tr>
				<tr>
					<th align="center">상품이미지</th>
					<td>
					<input type="button" name="choosefile" value="파일선택">
					<input type="text" name="pcount" value="상품이미지다!">
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" name="pregiste" value="상품등록">   
						<input type="reset" value="다시쓰기">
					</td>
				</tr>



			</tbody>
		</table>
	</form>

</body>
</html>