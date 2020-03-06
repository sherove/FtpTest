<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"  %>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

<title>Insert title here</title>
<script type="text/javascript">

/* Date.prototype.getYesterDay = function(e){
	var d = Number(this.format("dd"))-1;
	return new Date(this.format("yyyy"),this.format("MM"),d);
}


$("#btn").on("click",function(e){
	e.target
	$(this).siblings().each(function(idx,el){
	});
}); */

</script> 
</head>
<body>

<div class="container">
<h3>${sessionScope.uId }님~ 하잇</h3>
<table>
	<tr><th>폴더명</th></tr>
	
	<c:set var="countM" value="-1"/>
	<c:forEach var="list2" items="${ list2 }" varStatus="status">
		<tr height="30px">
			<td>
				<button type="button" class="btn btn-default btn-xs" onclick="deleteFile(this, '${list2}');">삭제</button>
				<img src="/resources/images/folder2.png">
				
 				<span id="listNm${countM }">${ list2 }</span>
 				<c:set var="countM" value="${countM+1 }"/>
			</td>
		</tr>
	</c:forEach>
	
	
	<c:forEach var="list" items="${ list }" varStatus="status">
		<tr height="30px">
			<td>
				<button type="button" class="btn btn-default btn-xs" onclick="deleteFile(this);">삭제</button>
				<c:if test="${listType[status.index] eq 'c' }"><img src="/resources/images/chrome.png"></c:if>
				<c:if test="${listType[status.index] eq 'n' }"><img src="/resources/images/fileicon.png"></c:if>
				<c:if test="${listType[status.index] eq 't' }"><img src="/resources/images/txticon.png"></c:if>
				<c:if test="${listType[status.index] eq 'z' }"><img src="/resources/images/zipicon.png"></c:if>
				<c:if test="${listType[status.index] eq 'p' }"><img src="/resources/images/imgicon2.png"></c:if>
 				<span id="listNm${countM }">${ list }</span>
 				<c:set var="countM" value="${countM+1 }"/>
			</td>
		</tr>
	</c:forEach>
</table>
<br><br>
<form name="fileForm" id="fileForm" action="/login/uploadFile" method="post" enctype="multipart/form-data">
	<input type="file" id="fileOb1" name="fileOb1">
	<br>
	<button type="button" class="btn btn-primary btn-grnl-submit" onclick="submitFile();">업로드</button>
  </form>	
	<br>
<!-- 	<input type="file" id="fileOb2" name="fileOb2">  -->
<!-- 	<input type="text" name="testName"> -->
	
<!-- 	</form>
        <h3>File Upload Test</h3>
        <form id="frm-upload" enctype="multipart/form-data" action="/file/upload" method="post">
            <div class="form-group">
                <label for="exampleInputFile">File input</label>
                <input type="file" id="test-file" name="file">
            </div>
            <div class="form-group">
                <input type="file" multiple="multiple" name="file">
            </div>
            <div class="form-group">
                <input type="text" name="userName" placeholder="Enter user name">
            </div>
            
            Form 태그 자체로 전송하기
            <button type="button" class="btn btn-primary btn-form-submit">Form Submit</button>
            
            jquery ajax으로 전송하기
            <button type="button" class="btn btn-primary btn-grnl-submit">Form Data Submit</button>
            <button type="button" class="btn btn-primary btn-ajax-submit">Ajax Submit</button>
            <button type="button" class="btn btn-primary btn-ajaxform-submit">Ajax Form Submit</button>
          </form>
    
   -->
   </div>    
    <br><br>

</body>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	
	test01("pPoooyY");
	
	//console.log(new Date().format("yyyy-MM-dd"));
	
	var initFuntion = "fn_init()";
	//eval(fn_init());
});

	function fn_init(){
		alert("ㅎㅎ");
	}
	function test01(s){
		
		var answer = true;
		var s1 = s.toLowerCase();
		console.log("tesT",s1);
		
		var tempArr = [];
		for(var i in s1){
			tempArr.push(s1[i]);
		}
		
		console.log("TEST1",tempArr);
		console.log("TEST2",new String); 
		
		var countP = 0;
		var countY = 0;
		tempArr.filter(function(element,index,array){
			if(element=="p"){
				countP++;
			}else if(element=="y"){
				countY++;
			}
		}); 
		if(countP==countY){
			return true;
		}else{
			return false;
		}
		
	}

	function deleteFile(obj, f){
		
		var fileNm = f;
		
		$.ajax({ 
			type: "POST", 
			url: '/login/deleteFile',
			data: fileNm, 
			dataType: 'text', 
			success: function (result) {
				
				
				
				
			}
		});
	}
	
	function submitFile(){
		var form = $('#fileForm')[0];
		var formData = new FormData(document.getElementById('fileForm'));
		console.log(formData);
		
		$.ajax({ 
			type: "POST", 
			url: '/login/uploadFile',
			data: formData, 
			dataType: 'text', 
			processData: false, 
			contentType: false,
			success: function (result) {
				
				if(result=="s"){
					alert("업로드 성공");
					location.reload();
				}else {
					alert("업로드 실패");
				}
				
				
			}
		});
	}
</script>
</html>


