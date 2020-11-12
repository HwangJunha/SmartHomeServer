package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.RoomDetail;
import vo.ActionForward;
import vo.Room;

public class RoomModifyFormAction implements Action {
	
	 public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{
		 
		 	ActionForward forward = new ActionForward();
			String code=request.getParameter("code");
			String name=request.getParameter("name");
			
			
			RoomDetail roomDetailService= new RoomDetail();	
		   	
			Room article =roomDetailService.getArticle(name,code);
			
		   	request.setAttribute("article", article);
		   	request.setAttribute("code", code);
	   		
	   		
		   	forward.setPath("/room/qna_room_modify.jsp");
	   		return forward;
	   		
	 }
}
