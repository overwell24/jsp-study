<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="post.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%	
	int postID = Integer.parseInt(request.getParameter("postID")); 
	String userID = (String) session.getAttribute("userID");	
	String title = request.getParameter("title");
	String content = request.getParameter("content");
	
	PostDAO postDAO = new PostDAO();
	PostDTO post = new PostDTO();
	
	post.setPostID(postID);
	post.setUserID(userID);
	post.setTitle(title);
	post.setContent(content);
	
	boolean result = postDAO.update(post);
	if(result){
		response.sendRedirect("postDetail.jsp?postID=" + postID);
	}
%>
</body>
</html>