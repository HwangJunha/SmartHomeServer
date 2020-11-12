package action;

import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.RoomUserModifyProService;
import vo.ActionForward;
import vo.Admin;

public class RoomUserModifyProAction implements Action {

	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{

		ActionForward forward = null;
		boolean isModifySuccess = false;
		
		String code=request.getParameter("code");
		String name = request.getParameter("name");
		
		
		
		Admin article=new Admin();
		
		RoomUserModifyProService roomUserModifyProService = new RoomUserModifyProService();
		
		boolean isRightRoom=roomUserModifyProService.isArticleWriter(name, code);
		
		if(!isRightRoom){
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out=response.getWriter();
			out.println("<script>");
			out.println("alert('수정할 권한이 없습니다.');");
			out.println("history.back();");
			out.println("</script>");
		}
		else{
			article.setName(request.getParameter("mName"));
			article.setEmail(request.getParameter("email"));
			article.setPhone(request.getParameter("number"));
			
			

			isModifySuccess = roomUserModifyProService.modifyArticle(article, name, code);

			if(!isModifySuccess){
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out=response.getWriter();
				out.println("<script>");
				out.println("alert('수정실패');");
				out.println("history.back()");
				out.println("</script>");
			}
			else{
				forward = new ActionForward();
				forward.setRedirect(true);
				forward.setPath("UserDetail.bo?name="+URLEncoder.encode(article.getName(),"UTF-8")+"&code="+code);				
			}

		}

		return forward;
	}
}
