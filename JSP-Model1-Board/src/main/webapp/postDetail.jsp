<%@page import="java.util.ArrayList"%>
<%@ page import="java.sql.Timestamp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="post.*" %>
<%@ page import="comment.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	// 로그인 체크
	String userID = (String) session.getAttribute("userID");	
	if (userID == null) {
    	response.sendRedirect("signin.html");
	}
    
	String author = null;
    String content = null;
    String title = null;
    Timestamp createDate = null;


    PostDAO postDAO = new PostDAO();
    PostDTO post = postDAO.getPost(request.getParameter("postID"));

    if (post != null) {
    	author = post.getUserID();
        content = post.getContent();
        title = post.getTitle();
        createDate = post.getCreatedDate();
    } else {
        out.print("게시물을 찾을 수 없습니다.");
    }

    // comment 가져오기
    CommentDAO commentDAO = new CommentDAO();
	ArrayList<CommentDTO> commentList = new ArrayList<CommentDTO>();
	commentList = commentDAO.getCommentList(request.getParameter("postID"));
%>

<h1>게시글 자세히 보기</h1>
<article>
    <h2>제목: <%= title %></h2>
    <p>작성자: <%= author %></p>
    <p>날짜: <%= createDate %></p>
    <pre><%= content %></pre>
</article>

<button onclick="location.href='postList.jsp'">목록</button>
<button onclick="location.href='updatePost.jsp?postID=<%=request.getParameter("postID")%>'">수정</button>
<button onclick="location.href='postDeleteAction.jsp?postID=<%=request.getParameter("postID")%>'">삭제</button>


<h2>댓글</h2>
<hr>
<% 
	for(int i=0; i < commentList.size(); i++){
%>
<section>
    <p><%= commentList.get(i).getUserID() %> (<%= commentList.get(i).getCreatedDate() %>)</p>
    <p><%= commentList.get(i).getText() %></p>
</section>
<hr>
<% 
	}
%>
<h2>댓글 달기</h2>
<form action="createCommentAction.jsp" method="get">
    <p>댓글 작성자: <%= userID %></p>
    <input type="hidden" name="postID" value="<%= request.getParameter("postID") %>">
    <input type="text" name="comment" size=40>
    <button type="submit">댓글 달기</button>
</form>
</body>
</html>
