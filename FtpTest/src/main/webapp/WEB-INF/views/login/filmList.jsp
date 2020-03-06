<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1>😍필름리스트페이지😍</h1>
<div>
<table style="width:60%;float:left;text-align:center;" >
	<thead>
		<tr>
			<th>FILM ID</th>
			<th>TITLE</th>
			<th>YEAR</th>
			<th>RATING</th>

		</tr>
	</thead>
	<tbody id="testBody">
		<c:forEach var="list" items="${list }">
			<tr class="filmClick"><td>${list.filmId }</td>
				<td>${list.title }</td>
				<td>${list.releaseYear }</td>
				<td>${list.rating }</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</div>

<div id="detailDiv" style="width:40%;float:right;">
<br>
</div>
<div style="width:100%;float:left;inline:block;cursor:pointer;" id="pagingDiv">
ㅎㅎgg
</div>
</body>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
var nowIdx = "1";
$(document).ready(function() {
	pageBtn();
});
	function pageBtn(){
		var totCnt = '<c:out value="${totCnt }"/>';
		var totCnt2 = 25;
		var unitCnt = "10";
		var PageCnt =  Math.ceil(totCnt2/unitCnt);
		
		var pagingHtml = "";
		
		for(var i=0; i<PageCnt;i++){
			pagingHtml += "<a onClick='pagingSet("+(i+1)+")'> ["+ (i+1) + "]</a> ";
		}
		$("#pagingDiv").html(pagingHtml);

	}
	
	function pagingSet(idx){
		var nowIdx = idx;

		$.ajax({
	        url : "/login/filmPage",
	        type: 'POST',
	        data: { nowIdx:nowIdx },
	        dataType : "json",
	        success: function(data) { 
	        	console.log("gg",data);
	        	$("#testBody").empty();
	        	
	        	for(var i in data){
	        		$("#testBody").append(
    	        		"<tr class=filmClick>"
    	        		+ "<td>" + data[i].filmId +"</td>" 
    	        		+ "<td>" + data[i].title +"</td>" 
    	        		+ "<td>" + data[i].releaseYear +"</td>" 
    	        		+ "<td>" + data[i].rating +"</td>" 
    	        		+ "</tr>"
	    	        );
	        	}
	        	
	        }
	    });
	}

	//ROW 클릭시 , 필름상세정보
	$(document).on("click",".filmClick",function(){
		console.log($(this).find("td:eq(0)").text());
		var filmId = $(this).find("td:eq(0)").text();
		$.ajax({
	        url : "/login/filmDetail",
	        type: 'POST',
	        data: { filmId:filmId },
	        dataType : "json",
	        success: function(data) {
	        	console.log(data);
	        	var nameHtml = "<h4>배우목록👀</h4>";
	        	for(var i in data){
	        		nameHtml += data[i].actorName + "<br>";
	        	}
	        	$("#detailDiv").html(nameHtml);
	        }
		 });
	});
</script>
</html>