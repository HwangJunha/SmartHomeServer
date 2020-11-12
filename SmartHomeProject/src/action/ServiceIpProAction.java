package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.ServiceIpProService;
import vo.ActionForward;

public class ServiceIpProAction implements Action {

	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) 
			throws Exception{	 

		ActionForward forward = null;
		String id=request.getParameter("id");
		String ip=request.getParameter("ip");
		String nowPage = request.getParameter("page");
		
		
		
		ServiceIpProService serviceIpProService = new ServiceIpProService();
		
		boolean isArticleWriter =serviceIpProService.isArticleWriter(id);
		
		if(!isArticleWriter){
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out=response.getWriter();
			out.println("<script>");
			out.println("alert('등록할 권한이 없습니다');");
			out.println("history.back();");
			out.println("</script>");
			out.close();
		}

		else{
			
			boolean isDeleteSuccess = serviceIpProService.insertArticle(id,ip);

			if(!isDeleteSuccess){
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out=response.getWriter();
				out.println("<script>");
				out.println("alert('등록 실패');");
				out.println("history.back();");
				out.println("</script>");
				out.close();
			}
			else{
				forward = new ActionForward();
				forward.setRedirect(true);
				forward.setPath("ServiceList.am?page=" + nowPage);
			}
			
		}


		return forward;
	}
}