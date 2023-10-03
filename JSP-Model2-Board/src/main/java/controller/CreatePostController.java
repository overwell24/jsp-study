package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import post.PostDAO;
import post.PostDTO;

@WebServlet("/createPost")
public class CreatePostController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CreatePostController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("createPost.jsp");
 
	}

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 현재 요청의 세션을 가져옵니다.
        HttpSession session = request.getSession();
        
        // 세션에서 사용자 ID를 가져와서 게시물 생성을 위한 PostDTO 객체에 설정합니다.
        String userID = (String) session.getAttribute("userID");
        
        PostDTO postDTO = new PostDTO();
        postDTO.setUserID(userID);
        postDTO.setTitle(request.getParameter("title"));
        postDTO.setContent(request.getParameter("content"));
        
        // PostDAO를 사용하여 게시물 생성을 시도하고, 결과를 반환합니다.
        PostDAO postDAO = new PostDAO();
        boolean result = postDAO.createPost(postDTO);

        if (result) {
            // 게시물 생성이 성공하면 게시물 목록 페이지로 리다이렉트합니다.
            response.sendRedirect("postList");
        } else {
            // 게시물 생성이 실패한 경우 처리할 로직 추가
            // 예: 오류 메시지를 표시하거나 다른 페이지로 리다이렉트
            // 예: response.sendRedirect("errorPage");
        }
    }

}
