package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.LoginService;
import vo.Admin;
/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Cookie[] cookieArray = request.getCookies();
	
		String id = "";
		String passwd = "";
		
		//쿠키 사용으로 자동 로그인유지 
		if(cookieArray!=null) {
			for(int i=0; i<cookieArray.length; i++) {
				if(cookieArray[i].getName().equals("id")) {
					id=cookieArray[i].getValue();
				}else if(cookieArray[i].getValue().equals("passwd")) {
					passwd = cookieArray[i].getValue();
				}
			}
		}
		
		
		LoginService loginService = new LoginService();
		Admin loginMember = loginService.getLoginAdmin(id,passwd);
		
		if(loginMember != null){
			if(loginMember.getCode().equals("admin")) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("admin.jsp");
				//response.sendRedirect("roomList.bo");
				dispatcher.forward(request, response);
			}else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
				//response.sendRedirect("roomList.bo");
				request.setAttribute("loginMember", loginMember);
				dispatcher.forward(request, response);
			}
		}
		else{
			RequestDispatcher dispatcher = request.getRequestDispatcher("loginForm.html");
			dispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		String useCookie = request.getParameter("useCookie");
		LoginService loginService = new LoginService();
		Admin loginMember = loginService.getLoginAdmin(id,passwd);
		
		if(useCookie != null) {
			Cookie idCookie = new Cookie("id", id);
			idCookie.setMaxAge(60*60*24);
			Cookie passwdCookie = new Cookie("passwd", passwd);
			passwdCookie.setMaxAge(60*60*24);
			response.addCookie(idCookie);
			response.addCookie(passwdCookie);
			
		}
		if(loginMember != null) {
			RequestDispatcher dispathcer = null;
			if(loginMember.getId().equals("admin")) {
				dispathcer = request.getRequestDispatcher("UserList.am");
			}else {
				dispathcer = request.getRequestDispatcher("index.jsp");
				request.setAttribute("loginMember", loginMember);
			}
			dispathcer.forward(request, response);
		}
		else {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('로그인 실패')");
			out.println("history.back()");
			out.println("</script>");
		}
		
	}
}









