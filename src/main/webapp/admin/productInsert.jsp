<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<c:set var="contextPath" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>상품 등록 페이지</title>
	<script src="http://code.jquery.com/jquery-2.2.1.min.js"></script>
	<script type="text/javascript">

	$(document).ready(function(){

		var boolResult = "${bool}";

	    if (boolResult != null) {
	        if(boolResult === "true"){
	        	alert("등록하였습니다.");
				document.location = "ProductListServlet";
	        } else if(boolResult === "false"){
	        	alert("등록실패.");
	        }
	    }	
	}); 
	</script>
	
</head>
<body>
	<form action="${contextPath}/ProductRegisterServlet" method="post" enctype="multipart/form-data">
		<table border="1" summary="상품 수정">
			<colgroup>
			<col width="150">
			<col width="500">
			
			</colgroup>
			

			<tbody>
			
				<tr>
					<td colspan="2" align="center">상품 등록(insert)</td>
				<tr>
					<th align="center">상품이름</th>
					<td><input type="text" name="pname" size="50"></td>
				</tr>
				<tr>
					<th align="center">상품가격</th>
					<td><input type="text" name="pprice" size="50"></td>
				</tr>
				<tr>
					<th align="center">상품설명</th>
					<td><textarea name="pcontents" cols="100" rows="30"></textarea></td>
				</tr>
				<tr>
					<th align="center">상품수량</th>
					<td><input type="text" name="pcount" size="20">개</td>
				</tr>
				<tr>
					<th align="center">상품이미지</th>
					<td>
					<input type="file" name="file" accept="image/*">
					
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="상품등록">   
						<input type="reset" value="다시쓰기">
					</td>
				</tr>
				
			</tbody>
		</table>
	</form>

</body>
</html>