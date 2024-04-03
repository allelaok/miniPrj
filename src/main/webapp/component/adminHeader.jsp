<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
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
			<th><input type="button" value="홈"></th>
			<th><input type="button" value="로그아웃"></th>
			<th><input type="button" value="회원관리"></th>
			<th><input type="button" value="상품관리"></th>
			<th><input type="button" value="주문관리"></th>
		</tr>
	</table>
</body>
</html>