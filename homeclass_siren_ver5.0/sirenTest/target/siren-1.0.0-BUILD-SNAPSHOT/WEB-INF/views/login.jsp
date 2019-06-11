<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인창</title>
</head>
<body>
 
	<form role="form" method="POST">
		<div class="createForm">
            <label>ID</label>
            <input type="text" name="userid" class="createForm" placeholder = "아이디">
        </div>
		<div class="createForm">
            <label>Password</label>
            <input type="text" name="user_password" class="createForm" placeholder = "비밀번호">
        </div>	
		<div class="Formfooter">
           	<button type="submit" class="btn_button">로그인</button>
        </div>  
	</form>
 	
</body>
</html>