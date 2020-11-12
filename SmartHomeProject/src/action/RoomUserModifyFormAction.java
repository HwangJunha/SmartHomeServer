package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.RoomUserDetailService;
import vo.ActionForward;
import vo.Admin;

public class RoomUserModifyFormAction implements Action {
		
		 public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{
			 
			 	ActionForward forward = new ActionForward();
				String code=request.getParameter("code");
				String name=request.getParameter("name");
				
				
				RoomUserDetailService roomDetailService= new RoomUserDetailService();	
			   	
				Admin article =roomDetailService.getArticle(name,code);
				
			   	request.setAttribute("article", article);
			   	request.setAttribute("code", code);
		   		
		   		
			   	forward.setPath("/room/qna_room_image_modify.jsp");
		   		return forward;
		 }
		   		
}
