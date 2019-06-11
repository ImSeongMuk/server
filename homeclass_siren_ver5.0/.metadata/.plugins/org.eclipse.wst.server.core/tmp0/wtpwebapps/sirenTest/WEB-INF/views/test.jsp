<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>test</title>
</head>
<body>
	<table>
		<tr>
			<td>이메일:</td>
			<td>비밀번호:</td>
			<td>이름:</td>
			<td>생일:</td>
			<td>휴대전화:</td>
			<td>몸무게:</td>
			<td>자주가는병원:</td>
			<td>질병명:</td>
			<td>약이름:</td>
			<td>연락처:</td>
		</tr>
		<c:forEach items="${list}" var="user_db">
		<tr>
			<td>${user_db.email}</td>
			<td>${user_db.user_password}</td>
			<td>${user_db.name}</td>
			<td>${user_db.date_of_birth}</td>
			<td>${user_db.tel}</td>
			<td>${user_db.weight}</td>
			<td>${user_db.hospital}</td>
			<td>${user_db.disease1}, ${user_db.disease2}, ${user_db.disease3}, ${user_db.disease4}, ${user_db.disease5}</td>
			<td>${user_db.medicine1}, ${user_db.medicine2}, ${user_db.medicine3}, ${user_db.medicine4}, ${user_db.medicine5}</td>
			<td>${user_db.around1}, ${user_db.around2}, ${user_db.around3}, ${user_db.around4}, ${user_db.around5}</td>
			
		</tr>
		
		</c:forEach>
	</table>
</body>
</html>