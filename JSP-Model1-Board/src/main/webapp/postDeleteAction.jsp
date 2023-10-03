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
		PostDAO postDAO = new PostDAO();
		boolean result = postDAO.deletePost(request.getParameter("postID"));
		
		if(result){
			response.sendRedirect("postList.jsp");
		}else{
			out.print("실패");
		}
		
	%>
</body>
</html>