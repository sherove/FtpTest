<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>로그인</title>
<link rel="stylesheet" type="text/css" href="/resources/css/common.css">

</head>
<body>


<!-- wrapper -->
<div id="wrapper" class="wrapper">
    <div class="loginWrap">
        <div class="loginForm">
            <form>
                <fieldset>
                    <legend>Login</legend>
                    <ul>
                        <li><input type="text" id="userId" class="userId" placeholder="아이디" autofocus></li>
                        <li><input type="password" id="userPwd" class="userPw"></li>
                    </ul>
                    <div class="flexWrap">
                        <div class="flexBox saveWrap"><input type="checkbox" id="saveId" class="saveId"><label for="saveId" tabindex="0">아이디 저장</label></div>
                        <div class="flexBox joinWrap"><a href="#" class="join">회원가입</a></div>
                    </div>
                    <div class="btn-box"><button class="btn-login" onclick="javascript:fn_loginCheck();">Login</button></div>
                </fieldset>
            </form>
        </div>
    </div>
</div>



</body>
<!-- <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script> -->


<script>
function fn_loginCheck(){
	//var userId = $("#userId").val();
	//var userPwd = $("#userPwd").val();
	
	window.location.href="/login/adminPage";
	
	
	$.ajax({
		url : "/login/loginCheck",
		type : "POST",
		data : {
			userId:"aaaa",
			userPwd:"1111"},
		dataType : "json",
		success : function(data){

			if(data.resultVo=="" || data.resultVo==null){
				alert(data.resultMsg);
			}else{
				if(data.flag=="1"){
					//성공
					if(data.resultVo.userAuth=="Y"){
						window.location.href="/login/adminPage";
					}else{
						window.location.href="/login/userPage";
					}
				}
			}

		}//success 
		 
	});
	
	
}
</script>
</html>