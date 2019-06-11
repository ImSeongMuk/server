<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="false" %>
<html>
<head>
    <title>유저 정보 입력</title>
</head>
<body>
<h1>
    유저 정보 입력
</h1>
    <form role="form" method="POST">
        <div class="createForm">
            <label>ID</label>
            <input type="text" name="userid" class="createForm" placeholder = "아이디">
        </div>
        <div class="createForm">
            <label>비밀번호</label>
            <input type="text" name="user_password" class="createForm" placeholder = "비밀번호">
        </div>
        <div class="createForm">
            <label>이름</label>
            <input type="text" name="name" class="createForm" placeholder = "이름">
        </div>
        <div class="createForm">
            <label>생년월일</label>
            <input type="text" name="date_of_birth" class="createForm" placeholder = "나이">
        </div>
        <div class="createForm">
            <label>핸드폰</label>
            <input type="text" name="tel" class="createForm" placeholder = "핸드폰 번호">
        </div>
        <div class="createForm">
            <label>주소</label>
            <input type="text" name="addr" class="createForm" placeholder = "주소">
        </div>
        <div class="createForm">
            <label>이메일</label>
            <input type="text" name="user_email" class="createForm" placeholder = "이메일">
        </div>
        <div class="createForm">
            <label>먹는 약</label>
            <input type="text" name="medicament" class="createForm" placeholder = "먹는 약">
        </div>
        <div class="createForm">
            <label>혈액형</label>
            <input type="text" name="blood_type" class="createForm" placeholder = "혈액형">
        </div>
        <div class="createForm">
            <label>몸무게</label>
            <input type="text" name="user_weight" class="createForm" placeholder = "몸무게">
        </div>
        <div class="createForm">
            <label>자주가는 병원</label>
            <input type="text" name="oft_hospital" class="createForm" placeholder = "자주가는 병원">
        </div>
        <div class="createForm">
            <label>질병 명</label>
            <input type="text" name="disease_name" class="createForm" placeholder = "질병명">
        </div>
        
        
        <div class="Formfooter">
           	<button type="submit" class="btn_button">작성하기</button>
        </div>   
    </form>
 
    
</body>
</html>

