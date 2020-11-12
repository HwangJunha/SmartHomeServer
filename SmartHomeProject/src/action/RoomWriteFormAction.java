package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.DeviceDetailService;
import vo.ActionForward;
import vo.Device;

public class RoomWriteFormAction implements Action {
	
	 public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{
		 
		 	ActionForward forward = new ActionForward();
			String code=request.getParameter("code");
			
	   		request.setAttribute("code", code);
	   		
		   	forward.setPath("/room/qna_room_write.jsp");
	   		return forward;
	 }
}
