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
                    <div class="btn-box"><button type="button" class="btn-login" id="loginBtn">Login</button></div>
                </fieldset>
            </form>
        </div>
    </div>
</div>



</body>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
$("#loginBtn").on("click",function(){
	console.log("asd");
	$.ajax({
        url : "/login/loginCheck2",
        type: 'POST',
        data: { staffId:"3",
				password:"1111"},
        dataType : "json",
        success: function(data) {
        	console.log("결과",data.flag);
        	if(data.flag=="1"){
        		alert(data.msg);
         		window.location.href="/login/rentalMain";
        	}else{
        		alert(data.msg);
        	}
        }
	 });
});
</script>
</html>