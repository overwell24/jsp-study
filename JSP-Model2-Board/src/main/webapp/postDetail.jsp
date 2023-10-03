<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>게시글 자세히 보기</h1>
<article>
    <h2>제목: ${post.title} </h2>
    <p>작성자: ${post.userID}</p>
    <p>날짜: ${post.createdDate} </p>
    <pre>${post.content}</pre>
</article>

<button onclick="location.href='postList'">목록</button>
<button onclick="location.href='updatePost?postID=${post.postID}'">수정</button>
<button onclick="location.href='deletePost?postID=${post.postID}'">삭제</button>


<h2>댓글</h2>
<hr>

<c:forEach var="comment" items="${commentList}">


<section>
    <p>${comment.userID}  ( ${comment.createdDate} )</p>
    <p> ${comment.text} </p>
</section>
<hr>
</c:forEach>
<h2>댓글 달기</h2>
<form action="createComment" method="get">
    <p>댓글 작성자: ${ userID }</p>
    <input type="hidden" name="postID" value="${post.postID} ">
    <input type="text" name="comment" size=40>
    <button type="submit">댓글 달기</button>
</form>
</body>
</html>
