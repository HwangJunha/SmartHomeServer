package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.RoomUserWriteService;
import vo.ActionForward;
import vo.Admin;

public class RoomUserWriteProAction implements Action {
	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{

		ActionForward forward=null;
		Admin user = null;
		
		user = new  Admin();
		
		String code = request.getParameter("code");
		String name = request.getParameter("name");
		String number = request.getParameter("number");
		String email = request.getParameter("email");
		
		RoomUserWriteService roomUserWriteProService= new RoomUserWriteService();
		
		user.setName(name);
		user.setPhone(number);
		user.setEmail(email);
		
		boolean isWriteSuccess =roomUserWriteProService.registArticle(user,code);
		
		if(!isWriteSuccess){
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('등록 실패')");
			out.println("history.back();");
			out.println("</script>");
		}
		else{
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("UserViewList.bo?code="+code);
		}

		return forward;
		
	}
}
