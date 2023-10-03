<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="comment.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String userID = (String) session.getAttribute("userID");
		String postID = request.getParameter("postID");
		String text = request.getParameter("comment"); 
		
		CommentDTO comment = new CommentDTO();
		comment.setPostID(Integer.parseInt(postID));
		comment.setUserID(userID);
		comment.setText(text);
		
		CommentDAO commentDAO = new CommentDAO();
		commentDAO.createComment(comment);
		
		response.sendRedirect("postDetail.jsp?postID=" + postID);
	%>
</body>
</html>