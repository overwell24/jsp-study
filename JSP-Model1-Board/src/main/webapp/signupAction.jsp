<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="user.*"%>

<jsp:useBean id="user" class="user.UserDTO" scope="page" />
<jsp:setProperty name="user" property="*" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%

	// 회원가입 처리
	UserDAO userDAO = new UserDAO();
	boolean result = userDAO.register(user);
	if(result){
		response.sendRedirect("signin.html");
	}else{
		response.sendRedirect("signup.html");
	}
%>


</body>
</html>