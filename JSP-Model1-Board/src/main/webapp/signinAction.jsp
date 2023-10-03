<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="user.*"%>
<jsp:useBean id="user" class="user.UserDTO" scope="page" />
<jsp:setProperty name="user" property="*" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign in</title>
</head>
<body>


<%	
	UserDAO userDAO = new UserDAO();
	boolean result = userDAO.login(user);
	if(result){
		session.setAttribute("userID", user.getUserID());
		response.sendRedirect("postList.jsp");
	}else{
		response.sendRedirect("signin.html");
	}
%>

</body>
</html>

