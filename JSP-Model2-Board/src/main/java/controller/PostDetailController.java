package controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import comment.CommentDAO;
import comment.CommentDTO;
import post.PostDAO;
import post.PostDTO;

@WebServlet("/postDetail")
public class PostDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PostDetailController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 요청에서 postID 매개변수를 가져옵니다.
        String reqPostID = request.getParameter("postID");
        
        // PostDAO를 사용하여 게시물 정보를 가져옵니다.
        PostDAO postDAO = new PostDAO();
        PostDTO postDTO = postDAO.getPost(reqPostID);
        
        // 게시물 정보를 request에 설정하여 뷰로 전달합니다.
        request.setAttribute("post", postDTO);
        
        // CommentDAO를 사용하여 댓글 목록을 가져옵니다.
        CommentDAO commentDAO = new CommentDAO();
        ArrayList<CommentDTO> commentList = commentDAO.getCommentList(reqPostID);
        
        // 댓글 목록을 request에 설정하여 뷰로 전달합니다.
        request.setAttribute("commentList", commentList);
        
        // 현재 요청의 세션을 가져옵니다.
        HttpSession session = request.getSession();
        
        // 세션에서 사용자 ID를 가져와서 게시물 생성을 위한 PostDTO 객체에 설정합니다.
        String sseUserID = (String) session.getAttribute("userID");
        request.setAttribute("userID", sseUserID);
        
        // 게시물 상세 정보를 표시하는 뷰로 포워딩합니다.
        RequestDispatcher dispatcher = request.getRequestDispatcher("postDetail.jsp");
        dispatcher.forward(request, response);
    }



}
