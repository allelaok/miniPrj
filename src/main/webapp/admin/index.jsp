<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:import url="/component/adminHeader.jsp" />
    <c:choose>
	    <c:when test="${ not empty sessionScope.adminId }">
	      	<p>${ sessionScope.adminId }님 방문해 주셔서 감사합니다.</p>
	    </c:when>
	    <c:otherwise>
	    	<p>로그인 하신 후 이용해 주세요.</p>
	    </c:otherwise>
    </c:choose>
    </div>
    <c:import url="/component/adminFooter.jsp" />
</body>
</html>