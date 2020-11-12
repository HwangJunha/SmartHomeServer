package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.DeviceDeleteProServic;
import vo.ActionForward;

public class DeviceDeleteProAction implements Action {

	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) 
			throws Exception{	 

		ActionForward forward = null;
		String model=request.getParameter("model");
		String nowPage = request.getParameter("page");
		
		
		
		DeviceDeleteProServic deviceDeleteProService = new DeviceDeleteProServic();
		
		boolean isArticleWriter =deviceDeleteProService.isArticleWriter(model);
		
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
			
			boolean isDeleteSuccess = deviceDeleteProService.removeArticle(model);

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
				forward.setPath("UserList.am?page=" + nowPage);
			}
			
		}


		return forward;
	}
}