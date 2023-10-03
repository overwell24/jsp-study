package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import post.PostDAO;
import post.PostDTO;

@WebServlet("/postList")
public class PostListController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public PostListController() {
        super();
    }

    // GET 요청 처리
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 게시물 목록을 가져오기 위해 PostDAO 객체를 생성
        PostDAO postDAO = new PostDAO();
        // 게시물 목록을 조회하여 ArrayList에 저장
        ArrayList<PostDTO> postList = postDAO.getPostList();

        // request 객체에 게시물 목록을 저장
        request.setAttribute("postList", postList);

        // postList.jsp로 포워딩하여 게시물 목록을 표시
        RequestDispatcher dispatcher = request.getRequestDispatcher("postList.jsp");
        dispatcher.forward(request, response);
    }

    // POST 요청 처리 (GET 요청과 동일한 로직 수행)
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
