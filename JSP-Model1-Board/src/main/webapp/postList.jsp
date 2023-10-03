<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="post.*" %>
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
    <%
        String userID = (String) session.getAttribute("userID");
        // 로그인 체크
        if (userID == null) {
            response.sendRedirect("signin.html");
        }
    %>
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
            <%
                // 게시물 가져오기
                PostDAO postDAO = new PostDAO();
                ArrayList<PostDTO> postList = postDAO.getPostList();
                for (int i = 0; i < postList.size(); i++) {
            %>
            <tr>

                <td><%= postList.get(i).getPostID() %> </td>
                <td><a href="postDetail.jsp?postID=<%=postList.get(i).getPostID()%>"><%= postList.get(i).getTitle() %></a></td>
                <td><%= postList.get(i).getUserID() %></td>
                <td><%= postList.get(i).getCreatedDate() %></td>
            </tr>
            
            <%
                }
            %>
        </tbody>
    </table>
    <h2><a href="createPost.html">게시글 작성</a></h2> <br>
</body>
</html>
