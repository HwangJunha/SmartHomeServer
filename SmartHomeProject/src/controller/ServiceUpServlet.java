package controller;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.ServiceUpServcie;
import utils.AllUser;
import vo.Admin;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/serviceUp")

public class ServiceUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServiceUpServlet()  {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String code= request.getParameter("code");
		String [] product= request.getParameterValues("product"); //checkBox 값 가져오기 
		ServiceUpServcie service= new ServiceUpServcie();
		boolean isWrite=false;
		
		try {
			for(int i=0; i<product.length; i++) {
				isWrite=service.registArticle(code, product[i]);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Admin loginMember = AllUser.users.get(code);
		if(isWrite) {
			RequestDispatcher dispathcer = request.getRequestDispatcher("index.jsp");
			request.setAttribute("loginMember", loginMember);
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
