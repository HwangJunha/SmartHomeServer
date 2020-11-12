package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.RoomDeviceDetail;
import vo.ActionForward;
import vo.Device;

public class RoomDeviceDetailAction implements Action {
	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{ 
	   	
		String model=request.getParameter("model");
		String code=request.getParameter("code");
		
		Device article=null;
		
		RoomDeviceDetail roomDeviceDetailService = new RoomDeviceDetail();
		
		
		article=roomDeviceDetailService.getArticle(model,code);
		
		ActionForward forward = new ActionForward();
		
		request.setAttribute("article", article);
	   	request.setAttribute("code", code);
		
   		forward.setPath("/room/qna_room_device_view.jsp");
   		
   		return forward;

	 }
}