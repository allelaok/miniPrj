<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
	
		html,body {width:100%;  }
		body,div,ul,li{margin:0; padding:0;}
		ul,li {list-style:none;}
	
	/*tab css*/
		.tab{float:left; width:700px; height:290px; text-aligh:center;}
		.tabnav{font-size:0; width:700px; border:1px solid #ddd;}
		.tabnav li{display: inline-block;  height:46px; text-align:center; border-right:1px solid #ddd;}
		.tabnav li a:before{content:""; position:absolute; left:0; top:0px; width:100%; height:3px; }
		.tabnav li a.active:before{background:#7ea21e;}
		.tabnav li a.active{border-bottom:1px solid #fff;}
		.tabnav li a{ position:relative; display:block; background: #f8f8f8; color: #000; padding:0 30px; line-height:46px; text-decoration:none; font-size:16px;}
		.tabnav li a:hover,
		.tabnav li a.active{background:#fff; color:#7ea21e; }
		.tabcontent{padding: 20px; height:244px; border:1px solid #ddd; border-top:none;}
	</style>
	<script src="http://code.jquery.com/jquery-2.2.1.min.js"></script>
	<script>
/* 		$(function(){
			  $('.tabcontent > div').hide();
			  $('.tabnav a').click(function () {
			    $('.tabcontent > div').hide().filter(this.hash).fadeIn();
			    $('.tabnav a').removeClass('active');
			    $(this).addClass('active');
			    return false;
			  }).filter(':eq(0)').click();
			  }); */
	</script>
</head>
<body>
	<c:import url="/component/indexHeader.jsp" />
	<%-- <div class="tab">
	    <ul class="tabnav">
	      <li><a href="<c:url value="/member/LoginServlet" />">로그인</a></li>
	      <li><a href="<c:url value="/member/SignUpServlet" />">회원가입</a></li>
	      <li><a href="#tab03">상품목록</a></li>
	      <li><a href="#tab04">장바구니</a></li>
	      <li><a href="#tab05">구매목록</a></li>
	    </ul>
    <div class="tabcontent"> --%>
    <c:choose>
	    <c:when test="${ not empty sessionScope.id }">
	      	<p>${ sessionScope.id }님 방문해 주셔서 감사합니다.</p>
	    </c:when>
	    <c:otherwise>
	    	<p>로그인 하신 후 이용해 주세요.</p>
	    </c:otherwise>
    </c:choose>
    </div>
    <c:import url="/component/indexFooter.jsp" />
</body>
</html>