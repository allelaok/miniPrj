<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }"></c:set>
<c:set var="productImage" value="${product.image}"></c:set>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>상품 수정 페이지</title>
	<script src="http://code.jquery.com/jquery-2.2.1.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
	
			var boolResult = "${bool}";
	
		    if (boolResult != null) {
		        if(boolResult === "true"){
		        	alert("수정하였습니다.");
					document.location = "ProductListServlet";
		        } else if(boolResult === "false"){
		        	alert("수정실패.");
		        }
		    }	
		}); 
		
	</script>
</head>
<body>
	<form action="ProductUpdateServlet" method="post" enctype="multipart/form-data">
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
					<td><input type="text" name="pname" value="${product.name}"/></td>
				</tr>
				<tr>
					<th align="center">상품가격</th>
					<td><input type="text" name="pprice" value="${product.price}"/></td>
				</tr>
				<tr>
					<th align="center">상품설명</th>
					<td><textarea name="pcontents" cols="100" rows="30" />${product.detail}</textarea></td>
				</tr>
				<tr>
					<th align="center">상품수량</th>
					<td><input type="text" name="pcount" value="${product.stock}" />개</td>
				</tr>
				<tr>
					<th align="center">상품이미지</th>
					<td style="text-align: center;">
            			<input type="file" name="image" accept="image/*"">
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
					
						<input type=hidden name="no" value="${product.no}" >
						<input type="submit" value="상품등록">   
						<input type="reset" value="다시쓰기">
					</td>
				</tr>
			
			</tbody>
		</table>

	</form>
</body>
</html>