<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>관리자페이지</title>
<style>
.bgActive {
        background-color: #BBDEFB;
}
</style>
</head>
<body>
관리자님 환영합니다.
<br><br>
<%-- <table>
	<tr><th>폴더명</th></tr>
	<c:forEach items="${list }" var="list">
		<tr>
			<td>
				<img src="/resources/images/folder2.png">${list }
			</td>
		</tr>
	</c:forEach>
</table> --%>

<h1>ㅎ_ㅎ시작</h1>
<div>
<table style="width:50%;float:left;text-align:center;" >
	<thead>
		<tr>
			<th>IDX</th>
			<th>NAME</th>
			<th>DATE</th>

		</tr>
	</thead>
	<tbody id="testBody">
	
	</tbody>
</table>
</div>
<div id="detailUser" style="width:40%;float:right;">

</div>
</body>


<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
var dataList= '[{"idx":0,"name":"Black Machine","date":"2020-02-28","content":"TEST_CONTENT_0","money":105166.823243745},{"idx":1,"name":"Playful Host","date":"2020-02-28","content":"TEST_CONTENT_1","money":102792.37053061783},{"idx":2,"name":"Sure-footed Trash","date":"2020-02-28","content":"TEST_CONTENT_2","money":238063.2377462746},{"idx":3,"name":"Blushing Pace","date":"2020-02-28","content":"TEST_CONTENT_3","money":256027.84303359324},{"idx":4,"name":"Second-hand Slice","date":"2020-02-28","content":"TEST_CONTENT_4","money":398845.76541184477},{"idx":5,"name":"Showy Relation","date":"2020-02-28","content":"TEST_CONTENT_5","money":287015.54291430325},{"idx":6,"name":"Phony Independence","date":"2020-02-28","content":"TEST_CONTENT_6","money":380466.42156417255},{"idx":7,"name":"Stained Pension","date":"2020-02-28","content":"TEST_CONTENT_7","money":243219.7523674703},{"idx":8,"name":"Tender Lunch","date":"2020-02-28","content":"TEST_CONTENT_8","money":114291.86789916387},{"idx":9,"name":"Euphoric Pause","date":"2020-02-28","content":"TEST_CONTENT_9","money":252849.5905748338},{"idx":10,"name":"Bubbly Worker","date":"2020-02-28","content":"TEST_CONTENT_10","money":224246.5891911194},{"idx":11,"name":"Stiff Self","date":"2020-02-28","content":"TEST_CONTENT_11","money":84061.3127184655},{"idx":12,"name":"Flimsy Great","date":"2020-02-28","content":"TEST_CONTENT_12","money":149444.9539433181},{"idx":13,"name":"Obvious Convert","date":"2020-02-28","content":"TEST_CONTENT_13","money":364172.2468362293},{"idx":14,"name":"Tight Possible","date":"2020-02-28","content":"TEST_CONTENT_14","money":315834.2760503046},{"idx":15,"name":"Common Sector","date":"2020-02-28","content":"TEST_CONTENT_15","money":271527.0384794326},{"idx":16,"name":"Frayed Length","date":"2020-02-28","content":"TEST_CONTENT_16","money":129923.15373307388},{"idx":17,"name":"Cute Account","date":"2020-02-28","content":"TEST_CONTENT_17","money":211649.4116902449},{"idx":18,"name":"Carefree Excuse","date":"2020-02-28","content":"TEST_CONTENT_18","money":225586.284176988},{"idx":19,"name":"Treasured Chain","date":"2020-02-28","content":"TEST_CONTENT_19","money":352222.618090259},{"idx":20,"name":"Sudden Button","date":"2020-02-28","content":"TEST_CONTENT_20","money":175230.68675979908},{"idx":21,"name":"Fat Presence","date":"2020-02-28","content":"TEST_CONTENT_21","money":136352.12138448204},{"idx":22,"name":"Snarling Recording","date":"2020-02-28","content":"TEST_CONTENT_22","money":212972.52116263047},{"idx":23,"name":"Oval Mood","date":"2020-02-28","content":"TEST_CONTENT_23","money":124539.88949914763},{"idx":24,"name":"Dreary Spirit","date":"2020-02-28","content":"TEST_CONTENT_24","money":214770.61349498402},{"idx":25,"name":"Flickering Pull","date":"2020-02-28","content":"TEST_CONTENT_25","money":84668.80832696529},{"idx":26,"name":"Spectacular Character","date":"2020-02-28","content":"TEST_CONTENT_26","money":122756.4819644031},{"idx":27,"name":"Kooky Fill","date":"2020-02-28","content":"TEST_CONTENT_27","money":386302.4918040958},{"idx":28,"name":"Exemplary Hire","date":"2020-02-28","content":"TEST_CONTENT_28","money":32066.75979048379},{"idx":29,"name":"Perky Fortune","date":"2020-02-28","content":"TEST_CONTENT_29","money":258066.58096112852},{"idx":30,"name":"Colorless Operation","date":"2020-02-28","content":"TEST_CONTENT_30","money":161955.7601717207},{"idx":31,"name":"Powerful Analysis","date":"2020-02-28","content":"TEST_CONTENT_31","money":84492.23607365601},{"idx":32,"name":"Fat Lake","date":"2020-02-28","content":"TEST_CONTENT_32","money":309287.8630534085},{"idx":33,"name":"Frightening Growth","date":"2020-02-28","content":"TEST_CONTENT_33","money":342070.2268277222},{"idx":34,"name":"Stiff Split","date":"2020-02-28","content":"TEST_CONTENT_34","money":53646.42707892173},{"idx":35,"name":"Infamous Pressure","date":"2020-02-28","content":"TEST_CONTENT_35","money":372265.62150207616},{"idx":36,"name":"Dirty Second","date":"2020-02-28","content":"TEST_CONTENT_36","money":261722.91531889647},{"idx":37,"name":"Worst Hat","date":"2020-02-28","content":"TEST_CONTENT_37","money":350771.2522770791},{"idx":38,"name":"Strange Trash","date":"2020-02-28","content":"TEST_CONTENT_38","money":319059.4067275695},{"idx":39,"name":"Weighty Lawyer","date":"2020-02-28","content":"TEST_CONTENT_39","money":386462.62638879294},{"idx":40,"name":"Young Report","date":"2020-02-28","content":"TEST_CONTENT_40","money":38345.48900182018},{"idx":41,"name":"Honored Mess","date":"2020-02-28","content":"TEST_CONTENT_41","money":232751.95830502958},{"idx":42,"name":"Mixed Difficulty","date":"2020-02-28","content":"TEST_CONTENT_42","money":332284.4818001496},{"idx":43,"name":"Unwritten Cancel","date":"2020-02-28","content":"TEST_CONTENT_43","money":192342.96338549984},{"idx":44,"name":"Prickly Economics","date":"2020-02-28","content":"TEST_CONTENT_44","money":5443.364517899063},{"idx":45,"name":"Heavy Project","date":"2020-02-28","content":"TEST_CONTENT_45","money":255843.4633119619},{"idx":46,"name":"Aggravating Hire","date":"2020-02-28","content":"TEST_CONTENT_46","money":38559.816980562544},{"idx":47,"name":"Prize Handle","date":"2020-02-28","content":"TEST_CONTENT_47","money":127321.15640317377},{"idx":48,"name":"Masculine Iron","date":"2020-02-28","content":"TEST_CONTENT_48","money":342994.92676500254},{"idx":49,"name":"Arid Radio","date":"2020-02-28","content":"TEST_CONTENT_49","money":265020.75086718786}]';
</script>
<script>

//사실 다큐멘트 레디 안에 모든 함수 밖으로 빼도됨...
var detailInfo = new Array();

$(document).ready(function(){
	dataList = JSON.parse(dataList);
	
	
	$(document).on("click",".bgClick",function(){  //이렇게 쓰는 경우는 document.문서만들어질때 동적으로 바인딩하는 함수 on() 언제든지 이 click함수는 동적으로 묶일수있다!!!!***+_+
		
		
		//$('#testBody tr').css("background-color",""); //tbdoy에 바로 안되고 tr로 넣어줘야되네 -1
		$(this).siblings().css("background-color",""); //자식형제요소 이용 -2
		
		
		$(this).css("background-color","orange");
		//$(this).next().childNodes().text("gg"); //테이블 tr td바로옆에다가 상세정보 넣어보고 싶었는데 실패..ㅠ
		
		
		
		var idx = $(this).index(); //(1).index()함수사용 해달 열이 몇번째인지
		//$("#detailUser").html(dataList[idx].content); 이렇게도 바로 content내용에 접근함 -정근씨가한거
		
		///////////(1)사건 : 해당 idx가 hide처리되거나 할때 밀리는 현상이 발생할수있음. 
		//(2)처리 : 그때 idx와 실제 자료의 idx 맞는지 체크 필수~
		//(3-1)사용 : $(this).find("td:eq(0)").text()
		//(3-2)사용 : $(this).children("td:eq(0)").text() 해당열의 자식노드에 접근하면 다 불러와짐 ㅠ
		
		for(var i=0; i<dataList.length; i++){
			//for문으로 0,1,2..dataList..49까지 돌거얌
			if(dataList[i].idx==$(this).find("td:eq(0)").text()){
				$("#detailUser").html(detailInfo[idx]);
				
			} 
		}
		
	

	});
	
	////////////우선주석처리test01();
	
	//요기다가 넣어줘도됨.... clickE();
	//원래 test01()하고 bgClick이 생성되므로 요기 자리에다가 클릭이벤트를 줘야하나...
	
	//테이블은 아직 생성이 안됐는데 클릭에 대한 이벤트는 무조건 실행될 예정인거임
});




//class='' 주고  클릭이벤트 발생하게 하는 경우
function test01(){
	
	for( var i=0; i<dataList.length ;i++){ 
		var userInfo = dataList[i];
		detailInfo[i] =  " content : " + userInfo.content+" <br> money : "+userInfo.money;
		$("#testBody").append(
				"<tr class='bgClick' onclick=''> "
				+" <td>"+ userInfo.idx +"</td>" 
				+" <td>"+ userInfo.name +"</td>"
				+" <td>"+ userInfo.date +"</td>"
				+"</tr>"
		);
		
		
	}
	

	//요기다가 넣어줘도됨.... clickE();
}
//class='' 주고  클릭이벤트 발생하게 하는 경우-2 이어서 실제 태그
function clickE(){
	$(".bgClick").click(function(e){
		$(this).css("background-color","lightgray"); 
	});
}




//onclick=''으로 클릭이벤트 발생하게 하는 경우
function test02(){
	for( var i=0; i<dataList.length ;i++){
		var userInfo = dataList[i];
		$("#testBody").append(
				"<tr onclick='clickRow(this)'> "
				+" <td>"+userInfo.idx+"</td>" 
				+" <td>"+ userInfo.name +"</td>"
				+" <td>"+userInfo.date+"</td>"
				+"</tr>"
		);
		
	}
}

function clickRow(el){
	$(el).css("background-color","lightgray");
}


//*********** click(ㅁㅁㅁㅁㅁㅁㅁ) 안에 함수 넣을때. 콜백함수ㅇㅇ ***********

//var test01 = function(){} <- 이렇게 함수 정의가능

/*
$(".bgClick").click(test01); <- 이렇게 test01() 아니고 test01으로 넣어줌. 오 신기방기
*/




</script>
</html>