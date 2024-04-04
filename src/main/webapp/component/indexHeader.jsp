<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index 화면 상단</title>

<style>
 input[type="button"] {
 		border: none;
 		background-color: transparent;
	 	border-radius: 0; /* 라운딩 없애기 */
	 }
th{
	background-color: orange;
}
</style>

</head>
<body>
	<table>
		<tr>
			<c:choose>
			    <c:when test="${ empty sessionScope.id }">
			      	<th><input type="button" value="로그인" onclick="location.href='<c:url value="/member/LoginServlet"/>'" /></th>
					<th><input type="button" value="회원가입" onclick="location.href='<c:url value="/member/SignUpServlet"/>'" /></th>
					<th><input type="button" value="상품목록" onclick="location.href='<c:url value="/member/LoginServlet"/>'"></th>
					<th><input type="button" value="장바구니" onclick="location.href='<c:url value="/member/LoginServlet"/>'"></th>
					<th><input type="button" value="구매목록" onclick="location.href='<c:url value="/member/LoginServlet"/>'"></th>
			    </c:when>
			    <c:otherwise>
			    	<th><input type="button" value="로그아웃" onclick="location.href='<c:url value="/member/LogoutServlet"/>'" /></th>
					<th><input type="button" value="회원수정" onclick="location.href='<c:url value="/member/UpdateServlet"/>'" /></th>
					<th><input type="button" value="상품목록" onclick="location.href='<c:url value="/ProductListServlet?isAdmin=false"/>'"></th>
					<th><input type="button" value="장바구니" onclick="location.href='<c:url value="/cart/CartListServlet"/>'"></th>
					<th><input type="button" value="구매목록" onclick="location.href='<c:url value="/orderList.jsp"/>'"></th>
			    </c:otherwise>
		    </c:choose>
			
		</tr>
	</table>
</body>
</html>