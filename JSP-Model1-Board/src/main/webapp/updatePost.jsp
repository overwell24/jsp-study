<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="post.*" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>게시글 수정</title>
</head>
<body>
    <h1>게시글 수정</h1>
    
    <% 
        String postID = request.getParameter("postID");
    	PostDAO postDAO = new PostDAO();
    	PostDTO post = postDAO.getPost(postID);
    %>

    <form action="updatePostAction.jsp" method="post">
    	<input type="hidden" name="postID" value="<%= postID %>">
        <label for="title">제목:</label> <br>
        <input type="text" name="title" id="title" size="40" value="<%= post.getTitle() %>"><br>

        <label for="content">내용:</label> <br>
        <textarea name="content" id="content" rows="5" cols="40"><%= post.getContent() %></textarea><br>
        
        <input type="submit" value="수정">
    </form>
</body>
</html>
