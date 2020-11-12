package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.RoomDetail;
import vo.ActionForward;
import vo.Room;


public class RoomDetailAction implements Action {
public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{ 
	   	
		String name=request.getParameter("name");
		String code=request.getParameter("code");
		Room article=null;
		
		RoomDetail roomDetailService = new RoomDetail();
		
		
		article=roomDetailService.getArticle(name, code);
		ActionForward forward = new ActionForward();
		request.setAttribute("article", article);
	   	request.setAttribute("code", code);
		
   		forward.setPath("/room/qna_room_view.jsp");
   		
   		return forward;

	 }
}