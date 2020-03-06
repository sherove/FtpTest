<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

<title>Main</title>
<style>
table th,table td {text-align:center;}
</style>
</head>
<body>
<div style="padding:40px;overflow:hidden;">
	<h1>😍환영함😍</h1>
	<br><br>
	<div id="searchDiv" style="width:25%;margin:0px;padding-bottm:40px;">
	 	<input type="text" id="searchCon" class="form-control" placeholder=""> 
		<button type="button" id="searchBtn" class="btn btn-default btn-xs">검색</button>
	</div>
	<br>
	<div style="width:50%;float:left;text-align:center;">
		<table style="width:100%;text-align:center;">
			<thead>
				<tr style="background-color: #dda0dd;">
					<th>No.</th>
					<th>영화명</th>
					<th>점포명</th>
					<th>재고위치</th>
					<th>대여 고객명</th>
				</tr>
			</thead>
			<tbody id="testBody">
			
			</tbody>
		</table>
	</div>
	

	<div id="detailDiv" style="width:25%;padding-left:60px;float:left;">
		<br>
		<h3>대여 등록👀</h3>
		<input type="text" class="form-control" placeholder="고객 이메일">
		<br>
		<input type="text" class="form-control" placeholder="반납일">
		<br>
		<input type="text" class="form-control" placeholder="대여금액">
		
	</div>
</div>
<div id="pagingDiv" style="padding-left:120px;cursor:pointer;">

</div>
</body>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
var nowIdx = 1;
$(document).ready(function(){
	getList();
});

/* 검색 버튼 클릭했을 경우 */
$('#searchBtn').on("click",function(){
	nowIdx = 1;
	getList();
});
/* 검색 엔터키 눌렀을 경우 */
$("#searchCon").keydown(function(key) {
	if(key.keyCode == 13){
		nowIdx = 1;
		getList();
	}
});
	

function getList(idx){
	var searchData = $("#searchCon").val();
	
	if(idx!=null){
			nowIdx = idx;
	}
	
	$.ajax({
        url : "/login/rentalList",
        type: 'POST',
        data : { searchData : searchData 
        	   , nowIdx : nowIdx}, 
        dataType : "json",
        success: function(data) {
        	$("#testBody").empty();//비우고
        	console.log(data.list);
        	console.log(data.totcnt);
        	
        	
        	for(var i in data.list){
        		$("#testBody").append(
        				"<tr class=''>" 
        				  + "<td>" + data.list[i].rownum + "</td>"
        				  + "<td>" + data.list[i].title + "</td>"
        				  + "<td>" + data.list[i].storeId + "</td>"
        				  + "<td>" + data.list[i].inventoryId + "</td>"
        				  + "<td>" + data.list[i].customerNm + "</td>"
        				  + "</tr>"
        		);
        		
        		idx++;
        	}
        	//총카운트까지 가지고옴 그리고 pageBtn 만들기 
        	var totcnt = data.totcnt;
        	var unitCnt = "10";
        	var PageCnt =  Math.ceil(totcnt/unitCnt);
        	
        	var pagingHtml = "";
        	
        	for(var i=0; i<PageCnt;i++){
    			pagingHtml += "<a onClick='getList("+(i+1)+")'> ["+ (i+1) + "]</a> ";
    		}
    		$("#pagingDiv").html(pagingHtml);
        	
        },
        /* error: function(e){
        	console.error(e);
        	alert("실패");
        } */
	 });
}

function pageBtn(){
	
}
</script>
</html>