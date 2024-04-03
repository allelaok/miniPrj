<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입 확인 화면: memberCheck.jsp</title>
</head>
<body>
	<form action="" method="post">
		<table border="1" >
			<colgroup>
				<col width="150" />
				<col width="600" />
			</colgroup>
			<thead>
				<tr><th align="center" colspan="2">테스트 회원님이 작성하신 내용입니다. 확인해 주세요</th></tr>
			</thead>
			<tbody>
				<tr>
					<td>아이디</td>
					<td>
						<input type="text" name="id" size="20" maxlength="20"/>
					</td>
				</tr>
				<tr>
					<td>패스워드</td>
					<td>
						<input type="text" name="pwd" size="20" maxlength="20"/>
					</td>
				</tr>
				<tr>
					<td>이름</td>
					<td>
						<input type="text" name="name" size="20" maxlength="20"/>
					</td>
				</tr>
				<tr>
					<td>성별</td>
					<td>
					 <label for="male">남</label>
					<input type="radio" id="male" name="gender" value="male" checked>
					 <label for="female">여</label>
					  <input type="radio" id="female" name="gender" value="female">
					</td>
				</tr>
				<tr>
					<td>생년월일</td>
					<td>
						<input type="text" name="birthday" size="10" maxlength="20"/>
					</td>
				</tr>
				<tr>
					<td>이메일</td>
					<td>
						<input type="text" name="email" size="30" maxlength="30"/>
					</td>
				</tr>
				<tr>
					<td>우편번호</td>
					<td>
						<input type="text" name="zipcode" size="10" maxlength="10"/>
					</td>
				</tr>
				<tr>
					<td>주소</td>
					<td>
						<input type="text" name="address" size="50" maxlength="50"/>
					</td>
				</tr>
				<tr>
					<td>직업</td>
					<td>
						<input type="text" name="birthday" size="10" maxlength="20"/>
					</td>
				</tr>
				<tr>
					<td>취미</td>
					<td>
						<label><input type="checkbox" name="hobby" value="internet">인터넷</label>
						<label><input type="checkbox" name="hobby" value="travel">여행</label>
						<label><input type="checkbox" name="hobby" value="gaming">게임</label>
						<label><input type="checkbox" name="hobby" value="movie">영화</label>
						<label><input type="checkbox" name="hobby" value="exercise">운동</label>
					</td>
				</tr>
			</tbody>
			<tfoot>
				<tr><th align="center" colspan="3">
					<input type="submit" value="확인완료" />
					&nbsp;&nbsp;&nbsp;
					<input type="reset" value="다시쓰기" />
				</th></tr>
			</tfoot>
		</table>
	</form>
</body>
</html>