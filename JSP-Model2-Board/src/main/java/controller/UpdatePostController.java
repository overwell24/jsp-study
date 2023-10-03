package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import post.PostDAO;
import post.PostDTO;

@WebServlet("/updatePost")
public class UpdatePostController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public UpdatePostController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String reqPostID = request.getParameter("postID");

        PostDAO postDAO = new PostDAO();
        PostDTO postDTO = postDAO.getPost(reqPostID);

        request.setAttribute("post", postDTO);

        RequestDispatcher dispatcher = request.getRequestDispatcher("updatePost.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 세션에서 사용자 ID를 가져옵니다.
        HttpSession session = request.getSession();
        String userID = (String) session.getAttribute("userID");

        // 게시물 정보 설정
        PostDTO postDTO = new PostDTO();
        postDTO.setUserID(userID);
        postDTO.setPostID(Integer.parseInt(request.getParameter("postID")));
        postDTO.setTitle(request.getParameter("title"));
        postDTO.setContent(request.getParameter("content"));

        // 게시물 업데이트
        PostDAO postDAO = new PostDAO();
        boolean result = postDAO.update(postDTO);

        if (result) {
            response.sendRedirect("postList");
        }else {
        	
        }
    }
}
