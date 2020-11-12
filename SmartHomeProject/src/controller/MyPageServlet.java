package controller;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.LoginService;
import utils.AllUser;
import vo.Admin;
/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/MyPage")

public class MyPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPageServlet()  {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		LoginService service = new LoginService();
		Admin loginMember;
		String code = request.getParameter("code");
		System.out.println(code);
		
		service.getUserCode(code);
		loginMember=AllUser.users.get(code);
		
		System.out.println("loginMember:"+loginMember.toString());
		
		request.setAttribute("loginMember", loginMember);
		RequestDispatcher dispathcer = request.getRequestDispatcher("Member/MyPage.jsp");
		
		dispathcer.forward(request, response);
		
		
	}
}
