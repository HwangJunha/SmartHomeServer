package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.RoomDeviceDeleteProServic;
import vo.ActionForward;
import vo.Device;

public class RoomDeviceDeleteProAction implements Action {

	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) 
			throws Exception{	 

		ActionForward forward = null;
		boolean isModifySuccess = false;
		
		String code=request.getParameter("code");
		String model = request.getParameter("model");
		
		Device article=new Device();
		
		
		RoomDeviceDeleteProServic roomDeviceDeleteProService = new RoomDeviceDeleteProServic();
		
		boolean isArticleWriter =roomDeviceDeleteProService.isArticleWriter(model, code);
		
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
			
			boolean isDeleteSuccess = roomDeviceDeleteProService.removeArticle(model,code);

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
				forward.setPath("deviceViewList.bo?code=" + code);
			}
			
		}


		return forward;
	}
}
