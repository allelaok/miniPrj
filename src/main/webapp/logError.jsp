<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그 에러 페이지</title>
<style>
	 /* 중앙 정렬을 위한 스타일 */
	 body {
	     display: flex;
	     flex-direction: column;
	     justify-content: center;
	     align-items: center;
	     height: 100vh;
	     margin: 0;
	 }
	  /* 아이디 및 비밀번호 안내 메시지 가운데 정렬 */
	 p {
	 	text-align: center;
	 }
	 
	  /* input 요소 중앙 정렬 */
	 input[type="button"] {
	 	margin-top: 20px; /* 버튼과 상단 간격 조정 */
	 }
</style>
</head>
<body>
	<p>로그인에 실패하셨습니다.<br>
	<br>
	아이디 및 비밀번호를 다시 확인하시기 바랍니다.</p>
	<input type="button" value="다시쓰기">
</body>
</html>