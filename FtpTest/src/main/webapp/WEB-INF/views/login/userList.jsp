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
<h1>ㅎ_ㅎ시작</h1>
<div>
<table style="width:50%;float:left;text-align:center;" >
	<thead>
		<tr>
			<th>IDX</th>
			<th>FIRST_NAME</th>
			<th>LAST_NAME</th>
			<th>DATE</th>

		</tr>
	</thead>
	<tbody id="testBody">
		<c:forEach var="list" items="${list }">
			<tr><td>${list.actorId }</td>
				<td>${list.firstName }</td>
				<td>${list.lastName }</td>
				<td>${list.lastUpdate }</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</div>
<div id="detailUser" style="width:40%;float:right;">

</div>
</body>
</html>