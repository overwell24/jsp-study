<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="post.*"%>
<jsp:useBean id="post" class="post.PostDTO" scope="page" />
<jsp:setProperty name="post" property="*" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%	
	request.setCharacterEncoding("UTF-8");
	//PosDTO에 userID 추가
	post.setUserID((String)session.getAttribute("userID"));
	
	PostDAO postDAO = new PostDAO();	
	boolean result = postDAO.createPost(post);
	
	if (result == true){
		response.sendRedirect("postList.jsp");
	}
%>

</body>
</html>