<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>게시글 수정</title>
</head>
<body>
    <h1>게시글 수정</h1>
    

    <form action="updatePost" method="post">
    	<input type="hidden" name="postID" value="${post.postID }">
        <label for="title">제목:</label> <br>
        <input type="text" name="title" id="title" size="40" value="${post.title }"><br>

        <label for="content">내용:</label> <br>
        <textarea name="content" id="content" rows="5" cols="40">${post.content }</textarea><br>
        
        <input type="submit" value="수정">
    </form>
</body>
</html>
