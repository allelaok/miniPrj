<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<% request.setCharacterEncoding("UTF-8"); %>
<c:set var="contextPath" value="${pageContext.request.contextPath }"></c:set>

<c:set var="jobName" value="${ param.job }" />
<c:choose>
	<c:when test="${ param.job eq 'unemployed' }">
		<c:set var="jobName" value="무직" />
	</c:when>
	<c:when test="${ param.job eq 'student' }">
		<c:set var="jobName" value="교직학생" />
	</c:when>
	<c:when test="${ param.job eq 'homemaker' }">
		<c:set var="jobName" value="주부" />
	</c:when>
	<c:when test="${ param.job eq 'employee' }">
		<c:set var="jobName" value="직장인" />
	</c:when>
	<c:when test="${ param.job eq 'entrepreneur' }">
		<c:set var="jobName" value="사업가" />
	</c:when>
</c:choose>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입 확인 화면: memberCheck.jsp</title>
</head>
<body>
<c:import url="/component/indexHeader.jsp" />
	<form action="<c:url value="/member/SignUpServlet" />" method="post">
		<table border="1" >
			<colgroup>
				<col width="150" />
				<col width="600" />
			</colgroup>
			<thead>
				<tr><th align="center" colspan="2">${ param.name } 회원님이 작성하신 내용입니다. 확인해 주세요</th></tr>
			</thead>
			<tbody>
				<tr>
					<td>아이디</td>
					<td>
						<input type="text" name="id" size="20" maxlength="20" value="${ param.id }" required />
					</td>
				</tr>
				<tr>
					<td>패스워드</td>
					<td>
						<input type="password" name="pwd" size="20" maxlength="20" value="${ param.pwd }" required />
					</td>
				</tr>
				<tr>
					<td>이름</td>
					<td>
						<input type="text" name="name" size="20" maxlength="20" value="${ param.name }" required />
					</td>
				</tr>
				<tr>
					<td>성별</td>
					<td>
					 <label for="male">남</label>
					<input type="radio" id="male" name="gender" value="M" ${param.gender == 'M' ? 'checked' : ''}>
					 <label for="female">여</label>
					  <input type="radio" id="female" name="gender" value="F" ${param.gender != 'M' ? 'checked' : ''}>
					</td>
				</tr>
				<tr>
					<td>생년월일</td>
					<td>
						<input type="text" name="birthday" size="10" value="${ param.birthday }"  maxlength="6" pattern="[0-9]{6}" required />
					</td>
				</tr>
				<tr>
					<td>이메일</td>
					<td>
						<input type="email" name="email" size="30" maxlength="30" value="${ param.email }" required />
					</td>
				</tr>
				<tr>
					<td>우편번호</td>
					<td>
						<input type="text" name="zipcode" size="10" maxlength="5"  pattern="[0-9]{5}" value="${ param.zipcode }" required />
					</td>
				</tr>
				<tr>
					<td>주소</td>
					<td>
						<input type="text" name="address" size="50" maxlength="50" value="${ param.address }" required />
					</td>
				</tr>
				<tr>
					<td>직업</td>
					<td>
						<input type="text" name="job" size="10" maxlength="20" value="${ jobName }" required />
					</td>
				</tr>
				<tr>
					<td>취미</td>
					<td>
						<c:if test="${ not empty param.internet }">
							<label><input type="checkbox" name="internet" value="i" checked>인터넷</label>
						</c:if>
						<c:if test="${ not empty param.travel }">
							<label><input type="checkbox" name="travel" value="t" checked>여행</label>
						</c:if>
						<c:if test="${ not empty param.gaming }">
							<label><input type="checkbox" name="gaming" value="g" checked>게임</label>
						</c:if>
						<c:if test="${ not empty param.movie }">
							<label><input type="checkbox" name="movie" value="m" checked>영화</label>
						</c:if>
						<c:if test="${ not empty param.exercise }">
							<label><input type="checkbox" name="exercise" value="e" checked>운동</label>
						</c:if>
					</td>
				</tr>
			</tbody>
			<tfoot>
				<tr><th align="center" colspan="3">
					<input type="submit" value="확인완료" />
					&nbsp;&nbsp;&nbsp;
					<button onclick="location.href='<c:url value="/signup.jsp"/>'" >다시쓰기</button>
				</th></tr>
			</tfoot>
		</table>
	</form>
	<c:import url="/component/indexFooter.jsp" />
</body>
</html>