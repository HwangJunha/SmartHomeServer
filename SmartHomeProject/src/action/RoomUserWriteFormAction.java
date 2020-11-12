package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.ActionForward;

public class RoomUserWriteFormAction implements Action {
	
	 public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{
		 
		 	ActionForward forward = new ActionForward();
			String code=request.getParameter("code");
			
	   		request.setAttribute("code", code);
	   		
		   	forward.setPath("/room/qna_room_image_write.jsp");
	   		return forward;
	 }
}