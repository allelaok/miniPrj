<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 수정 화면: memberUpdate.jsp</title>
</head>
<body>
	<form action="<c:url value="/member/UpdateServlet" />" method="post">
		<table border="1" >
			<colgroup>
				<col width="150" />
				<col width="600" />
			</colgroup>
			<thead>
				<tr><th align="center" colspan="2">${ member.name } 회원님의 정보를 수정합니다.</th></tr>
			</thead>
			<tbody>
				<tr>
					<td>아이디</td>
					<td>
						${ member.id }
					</td>
				</tr>
				<tr>
					<td>패스워드</td>
					<td>
						<input type="password" name="pwd" size="20" maxlength="20" value="${ member.pwd }" required />
					</td>
				</tr>
				<tr>
					<td>이름</td>
					<td>
						<input type="text" name="name" size="20" maxlength="20" value="${ member.name }" required />
					</td>
				</tr>
				<tr>
					<td>성별</td>
					<td>
					 <label for="male">남</label>
					<input type="radio" id="male" name="gender" value="M" ${member.gender == 'M' ? 'checked' : ''}>
					 <label for="female">여</label>
					  <input type="radio" id="female" name="gender" value="F" ${member.gender != 'M' ? 'checked' : ''}>
					</td>
				</tr>
				<tr>
					<td>생년월일</td>
					<td>
						<input type="text" name="birthday" size="10" value="${ member.birthday }"  maxlength="6" pattern="[0-9]{6}" required />
						 ex)830815
					</td>
				</tr>
				<tr>
					<td>이메일</td>
					<td>
						<input type="email" name="email" size="30" maxlength="30"  value="${ member.email }" required />
					</td>
				</tr>
				<tr>
					<td>우편번호</td>
					<td>
						<input type="text" name="zipcode" size="10" maxlength="5" pattern="[0-9]{5}" value="${ member.zipcode }" required />
						<input type="button" name="findZipcode" value="우편번호찾기" />
					</td>
				</tr>
				<tr>
					<td>주소</td>
					<td>
						<input type="text" name="address" size="50" maxlength="50" value="${ member.address }" required />
					</td>
				</tr>
				<tr>
					<td>직업</td>
					<td>
						<select name="job" required >
						  <option value="" disabled>선택하세요</option>
						  <option value="unemployed" ${ member.job eq 'unemployed' ? selected : '' }>무직</option>
						  <option value="student" ${ member.job eq 'student' ? selected : '' }>교직학생</option>
						  <option value="homemaker" ${ member.job eq 'homemaker' ? selected : '' }>주부</option>
						  <option value="employee" ${ member.job eq 'employee' ? selected : '' }>직장인</option>
						  <option value="entrepreneur" ${ member.job eq 'entrepreneur' ? selected : '' }>사업가</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>취미</td>
					<td>
						<label><input type="checkbox" name="internet" value="i" ${fn:contains(member.hobby, 'i') ? 'checked' : '' }>인터넷</label>
						<label><input type="checkbox" name="travel" value="t" ${fn:contains(member.hobby, 't') ? 'checked' : '' }>여행</label>
						<label><input type="checkbox" name="gaming" value="g" ${fn:contains(member.hobby, 'g') ? 'checked' : '' }>게임</label>
						<label><input type="checkbox" name="movie" value="m" ${fn:contains(member.hobby, 'm') ? 'checked' : '' }>영화</label>
						<label><input type="checkbox" name="exercise" value="e" ${fn:contains(member.hobby, 'e') ? 'checked' : '' }>운동</label>
					</td>
				</tr>
			</tbody>
			<tfoot>
				<tr><th align="center" colspan="3">
					<input type="hidden" name="nowPath" value="m"/>
					<input type="submit" value="수정완료" />
					&nbsp;&nbsp;&nbsp;
					<input type="reset" value="다시쓰기" />
				</th></tr>
			</tfoot>
		</table>
	</form>
</body>
</html>