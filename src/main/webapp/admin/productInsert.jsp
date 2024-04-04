<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>상품 등록 페이지</title>
	<script>
	function send()
	{
		//1. jQuery 의 ajax() 를 사용하여 요청 / 응답
		$.ajax
		({
			type:"post", 		// 요청 전송방식
			dataType:"text",	// 응답데이터 타입
			async:false,		
			url:"http://localhost:9000/shoppingMall/ProductRegisterServlet",
			
			success:function(data, textStatus)
			{
				if("success".equal(data)){
					alert("등록하였습니다.");
					document.location = "admin/productMgr.jsp";
				}else{
					alert("등록실패.");
				}
				
			},
			
			error:function(data, textStatus)
			{
				alert("에러가 발생!!!");
			},
			
			complete:function(data, textStatus)
			{
				alert("작업 완료!!!");
			}
		});
	}
</script>
	
</head>
<body>
	<form action="" method="post">
		<table border="1" summary="상품 수정">
			<colgroup>
			<col width="150">
			<col width="500">
			
			</colgroup>
			

			<tbody>
			<form action="ProductRegisterServlet" method="post">
			
				<tr>
					<td colspan="2" align="center">상품 등록(insert)</td>
				<tr>
					<th align="center">상품이름</th>
					<td><input type="text" name="pname" size="50"></td>
				</tr>
				<tr>
					<th align="center">상품가격</th>
					<td><input type="text" name="pprice" size="50"></td>
				</tr>
				<tr>
					<th align="center">상품설명</th>
					<td><textarea name="pcontents" cols="100" rows="30"></textarea></td>
				</tr>
				<tr>
					<th align="center">상품수량</th>
					<td><input type="text" name="pcount" size="20">개</td>
				</tr>
				<tr>
					<th align="center">상품이미지</th>
					<td>
					<input type="button" name="choosefile" value="파일선택">
					<input type="text" name="image" >
					
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="상품등록">   
						<input type="reset" value="다시쓰기">
					</td>
				</tr>
				
			</form>
			</tbody>
		</table>
	</form>

</body>
</html>