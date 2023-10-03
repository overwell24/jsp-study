package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.UserDAO;
import user.UserDTO;

@WebServlet("/signin")
public class SigninController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public SigninController() {
        super();
    }

    // GET 요청 처리
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 로그인 페이지(signin.jsp)로 리다이렉트
        response.sendRedirect("signin.jsp");
    }

    // POST 요청 처리
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // UserDAO 객체 생성
        UserDAO userDAO = new UserDAO();
        // UserDTO 객체 생성
        UserDTO userDTO = new UserDTO();

        // 사용자가 입력한 userID와 userPasswd 파라미터를 UserDTO에 설정
        userDTO.setUserID(request.getParameter("userID"));
        userDTO.setUserPasswd(request.getParameter("userPasswd"));

        // 사용자 로그인을 시도하고 결과를 받아옴
        boolean result = userDAO.login(userDTO);

        if (result) {
            // 로그인에 성공하면 세션을 생성하고 사용자 정보를 세션에 저장
            HttpSession session = request.getSession();
            session.setAttribute("userID", userDTO.getUserID());

            // 로그인 성공 시 /postList 페이지로 리다이렉트
            response.sendRedirect("postList");
        } else {
            // 로그인 실패 시 다시 로그인 페이지(signin.jsp)로 리다이렉트
            response.sendRedirect("signin");
        }
    }
}
