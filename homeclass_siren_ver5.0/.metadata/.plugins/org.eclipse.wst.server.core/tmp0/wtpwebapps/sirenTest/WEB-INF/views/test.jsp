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
			<td>유저번호  </td>
			<td>이메일     </td>
			<td>비밀번호  </td>
			<td>이름         </td>
			<td>생일         </td>
			<td>휴대전화   </td>
			<td>자주가는병원 </td>
		</tr>
		<c:forEach items="${list}" var="userinfo">
		<tr>
			<td>${userinfo.userNum}</td>
			<td>${userinfo.email}</td>
			<td>${userinfo.password}</td>
			<td>${userinfo.name}</td>
			<td>${userinfo.birth}</td>
			<td>${userinfo.phone}</td>
			<td>${userinfo.hospital}</td>
		</tr>
		
		</c:forEach>
	</table>
</body>
</html>