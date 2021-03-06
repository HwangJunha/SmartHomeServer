package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.RoomDeleteProServic;
import vo.ActionForward;
import vo.Room;

public class RoomDeleteProAction implements Action {

	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) 
			throws Exception{	 

		ActionForward forward = null;
	
		
		String code=request.getParameter("code");
		String name = request.getParameter("name");
		
		
		RoomDeleteProServic roomDeviceDeleteProService = new RoomDeleteProServic();
		
		boolean isArticleWriter =roomDeviceDeleteProService.isArticleWriter(name, code);
		
		if(!isArticleWriter){
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out=response.getWriter();
			out.println("<script>");
			out.println("alert('삭제할 권한이 없습니다');");
			out.println("history.back();");
			out.println("</script>");
			out.close();
		}

		else{
			
			boolean isDeleteSuccess = roomDeviceDeleteProService.removeArticle(name,code);

			if(!isDeleteSuccess){
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out=response.getWriter();
				out.println("<script>");
				out.println("alert('삭제실패');");
				out.println("history.back();");
				out.println("</script>");
				out.close();
			}
			else{
				forward = new ActionForward();
				forward.setRedirect(true);
				forward.setPath("roomViewList.bo?code=" + code);
			}
			
		}


		return forward;
	}
}

