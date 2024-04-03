<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원관리 페이지 : memberMgr.jsp</title>
</head>
<body>
	<table border="1" summary="회원목록">
		<colgroup>
			<col width="80" />
			<col width="100" />
			<col width="80" />
			<col width="50" />
			<col width="80" />
			<col width="150" />
			<col width="80" />
			<col width="100" />
		</colgroup>
		<thead>
			<!-- 회원목록제목 -->
			<tr>
				<th>회원이름</th>
				<th>회원아이디</th>
				<th>패스워드</th>
				<th>성별</th>
				<th>생년월일</th>
				<th>이메일</th>
				<th>수정</th>
				<th>메일보내기</th>
			</tr>
		</thead>
			<!-- 회원목록의 데이터부분 시작 -->
		<tbody>
			<c:choose>
				<c:when test="${ memberList.length == 0 }">
					<%-- if() 부분 --%>
					<tr>
						<td align="center" colspan="5">등록된 게시물이 없습니다.</td>
					</tr>
				</c:when>
				<c:otherwise>
					<%-- else 부분 --%>
					<c:forEach var="member" items="${ memberList }" varStatus="status">
						<tr>
							<!-- 회원 이름 -->
							<td align="center"><c:out value="${ member.name }" /></td>
							<!-- 회원아이디 -->
							<td align="center"><c:out value="${ member.id }" /></td>
							<!-- 패스워드 -->
							<td align="center"><c:out value="${ member.pwd }" /></td>
							<!-- 성별 -->
							<td align="center">
								<c:choose>
									<c:when test="${member.gender == 'm'}">
										남자
									</c:when>
									<c:otherwise>
										여자
									</c:otherwise>
								</c:choose>
							</td>
							<!-- 생년월일 -->
							<td align="center"><c:out value="${ member.birthday }" /></td>
							<!-- 이메일 -->
							<td align="center"><c:out value="${ member.email }" /></td>
							<!-- 수정 -->
							<td>
								<a href="<c:url value="/member/UpdateServlet?id=${ member.id }" /> ">
									수정하기
								</a>
							</td>
							<!-- 메일보내기 -->
							<td>
								<button>메일보내기</button>
							</td>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</tbody>
	</table>
</body>
</html>