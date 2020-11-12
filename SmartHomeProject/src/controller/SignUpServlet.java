package controller;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.SignUpService;
import vo.Admin;
/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/sign_up")

public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUpServlet()  {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Admin user = new Admin();
		String id = request.getParameter("id");
		String password = request.getParameter("pwd");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String zip_code = request.getParameter("zipcode");
		String address = request.getParameter("address");
		String address2 = request.getParameter("address2");
		String num_1 = request.getParameter("tel_1");
		String num_2 = request.getParameter("tel_2");
		String num_3 = request.getParameter("tel_3");
		
		String number=num_1+"-"+num_2+"-"+num_3;
		
		user.setId(id);
		user.setPwd(password);
		user.setName(name);
		user.setEmail(email);
		user.setZip_code(zip_code);
		user.setAddr(address);
		user.setAddr2(address2);
		user.setPhone(number);
		
		
		SignUpService signUpService = new SignUpService();
		boolean isWrite=false;
		
		try {
			isWrite = signUpService.registArticle(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(isWrite) {
			response.setContentType("text/html;charset=UTF-8");
			RequestDispatcher dispathcer = request.getRequestDispatcher("loginForm.html");
			dispathcer.forward(request, response);
		}
		else {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('회원가입 실패')");
			out.println("history.back()");
			out.println("</script>");
		}
		
	}
}
