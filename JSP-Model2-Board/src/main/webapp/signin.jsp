<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1>로그인 페이지</h1>
    <form action="signin" method="post">
        <label for="userID">ID:</label>
        <input type="text" name="userID" id="userID"> <br>
        
        <label for="userPasswd">PW:</label>
        <input type="password" name="userPasswd" id="userPasswd"> <br>
        
        <input type="submit" value="Sign in">
    </form>

    <h2><a href="signup">회원가입 페이지 이동</a></h2>
</body>
</html>