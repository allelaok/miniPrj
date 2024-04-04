<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<style>
.modal {
    display: none;
    position: fixed;
    z-index: 1000;
    left: 0;
    top: 0;
    width: 100%;
    height: 100%;
    overflow: auto;
    background-color: rgba(0, 0, 0, 0.4);
}

.modal-content {
    background-color: #fefefe;
    margin: 15% auto;
    padding: 20px;
    border: 1px solid #888;
    width: 40%;
}

.modal-buttons {
    text-align: right;
}

.modal-buttons button {
    margin-left: 10px;
}
</style>
</head>
<body>

<div id="myModal" class="modal">
  <div class="modal-content">
    <form action="/member/SignUpServlet" method="post">
		<p> 도로명 검색: 
			<input type="text" name="searchText" id="search_text"/>
			<input type="button" id="searchBtn" value="검색" />
		</p>
	</form>
	<div id="search_result"></div>
    <div class="modal-buttons">
        <button id="cancelBtn">닫기</button>
    </div>
  </div>
</div>

<input type="button" name="findZipcode" value="우편번호찾기" id="openFindModal" />

<script>
var modal = document.getElementById("myModal");
var addAddress = document.getElementById("addAddress");
var cancelBtn = document.getElementById("cancelBtn");
var customConfirmBtn = document.getElementById("customConfirmBtn");

openFindModal.onclick = function() {
    modal.style.display = "block";
}

searchBtn.onclick = function() {
	var _searchText = $("#search_text").val();
	
	$.ajax({
		type: "post",
		async: false,
		url: "http://localhost:9000/shoppingMall/member/SignUpServlet/findZipcode.do",
		dataType: "json",
		data: {address: _searchText},
		
		success:function(data, textStatus) {
			var html = '';
			if (data.length == 0) {
				html = '<b>검색 결과가 없습니다.</b>'
			} else {
				html += '<p> #검색 후, 아래 우편번호를 클릭하면 자동으로 입력됩니다. </p>' 
				
				data.forEach(function (item) {
	                html += '<a class="addAddress">' + item.zipcode + " ";
	                html += item.area1 + " ";
	                html += item.area2 + " ";
	                html += item.area3 + " ";
	                html += '</a><br>';
	            });
			}
			$('#search_result').html(html);
		},
		error:function(data, textStatus) {
			alert("다시 한 번 시도해주세요.");
		},
		complete: function(data, textStatus) {
			
		}
	})
}

$(document).on('click', '.addAddress', function() {
	var fullAddress = $(this).text();
	
	var zipcode = fullAddress.substring(0, 5);
	var address = fullAddress.substring(6);
	
	$('#zipcode').val(zipcode);
	$('#address').val(address);
	
	$('#search_text').val('');
	$('#search_result').empty();
    modal.style.display = "none";
});

cancelBtn.onclick = function() {
	$('#search_text').val('');
	$('#search_result').empty();
    modal.style.display = "none";
}

</script>

