package action;

import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.RoomDeviceModifyProService;

import vo.ActionForward;
import vo.Device;

public class RoomDeviceModifyProAction implements Action {

	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) 
			throws Exception{

		ActionForward forward = null;
		boolean isModifySuccess = false;
		
		String code=request.getParameter("code");
		String model = request.getParameter("model");
		
		
		
		Device article=new Device();
		
		RoomDeviceModifyProService roomDeviceModifyProService = new RoomDeviceModifyProService();
		
		boolean isRightRoom=roomDeviceModifyProService.isArticleWriter(model, code);
		
		if(!isRightRoom){
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out=response.getWriter();
			out.println("<script>");
			out.println("alert('수정할 권한이 없습니다.');");
			out.println("history.back();");
			out.println("</script>");
		}
		else{
			article.setDeviceKind(request.getParameter("kind"));
			article.setModel(request.getParameter("model"));
			article.setRoomName(request.getParameter("room"));
			article.setName(request.getParameter("name"));
			
			

			isModifySuccess =roomDeviceModifyProService.modifyArticle(article, model, code);

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
				forward.setPath("DeviceDetail.bo?model="+URLEncoder.encode(article.getModel(),"UTF-8")+"&code="+code); 
				
			}

		}

		return forward;
	}
}
