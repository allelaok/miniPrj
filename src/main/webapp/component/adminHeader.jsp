<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }"></c:set>
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
		<th><input type="button" value="홈" onclick="location.href='<c:url value="/index.jsp"/>'"></th>
			<c:choose>
			    <c:when test="${ empty sessionScope.adminId }">
			      	<th><input type="button" value="로그인" onclick="location.href='<c:url value="/admin/AdminLoginServlet"/>'" /></th>
			      	<th><input type="button" value="회원관리" onclick="location.href='<c:url value="/admin/AdminLoginServlet"/>'" /></th>
			      	<th><input type="button" value="상품관리" onclick="location.href='<c:url value="/admin/AdminLoginServlet"/>'"></th>
					<th><input type="button" value="주문관리" onclick="location.href='<c:url value="/admin/AdminLoginServlet"/>'"></th>
			    </c:when>
			    <c:otherwise>
			    	<th><input type="button" value="로그아웃" onclick="location.href='<c:url value="/admin/AdminLogoutServlet"/>'" /></th>
			    	<th><input type="button" value="회원관리" onclick="location.href='<c:url value="/member/MemberListServlet"/>'" /></th>
			    	<th><input type="button" value="상품관리" onclick="location.href='<c:url value="/ProductListServlet?isAdmin=true"/>'"></th>
					<th><input type="button" value="주문관리" onclick="location.href='<c:url value="/admin/orderListMgr.jsp"/>'"></th>
			    </c:otherwise>
		    </c:choose>

		</tr>
	</table>
</body>
</html>