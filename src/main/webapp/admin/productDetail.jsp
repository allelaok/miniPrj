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
<script src="http://code.jquery.com/jquery-2.2.1.min.js"></script>
<script type="text/javascript">

	function gotoUpdate(no){
		
		document.location = "ProductUpdateServlet?productno="+no;
	}
	
	function gotoDelete(no){
		document.location = "ProductDeleteServlet?productno="+no;
	}	
	
	$(document).ready(function(){

		var boolResult = "${bool}";

	    if (boolResult != null) {
	        if(boolResult === "true"){
	        	alert("삭제하였습니다.");
				document.location = "ProductListServlet";
	        } else if(boolResult === "false"){
	        	alert("삭제실패.");
	        }
	    }	
	}); 
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
			<td style="text-align: center;"><img src="${contextPath }/FileDownloadServlet?fileName=${product.image}" width="300" height="300"></td>
			<td>
				<table border="1">			
					<tr><td><b>상품이름 : </b>${product.name}</td></tr>
					<tr><td><b>가 격 : </b>${product.price}</td></tr>
					<tr><td><b>입고날짜 :</b>${product.date}</td></tr>
					<tr><td><b>재 고 : </b>${product.stock}</td></tr>
				</table>
			</td>
			<td style="vertical-align: top;">
			<b>상세설명</b><br>
			<br>
			${product.detail}
			</td>
		</tr>
		
		<tr>
				<td colspan="3" style="text-align:center;">
					<input type="button" value="수정하기" onclick="gotoUpdate('${product.no}')">
					<input type="button" value="삭제하기" onclick="gotoDelete('${product.no}')">
				</td>
			</tr>
		
	</table>
</body>
</html>