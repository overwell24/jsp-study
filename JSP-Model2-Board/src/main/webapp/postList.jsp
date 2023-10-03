<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>게시판</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
            border-top: 1px solid #444444;
        }

        th, td {
            text-align: center;
            padding: 10px;
            border-bottom: 1px solid #444444;
        }
    </style>
</head>
<body>

    <h1>게시판 페이지</h1>
    <table border="">
        <thead>
            <tr>
                <th>NO</th>
                <th>제목</th>
                <th>글쓴이</th>
                <th>날짜</th>
            </tr>
        </thead>
        <tbody>
			<c:forEach var="post" items="${postList}">
            	<tr>
                	<td>${post.postID} </td>
                	<td><a href="postDetail?postID=${post.postID}">${post.title} </a></td>
                	<td>${post.userID}</td>
                	<td>${post.createdDate}</td>
            	</tr>
			</c:forEach>
        </tbody>
    </table>
    <h2><a href="createPost">게시글 작성</a></h2> <br>
</body>
</html>
