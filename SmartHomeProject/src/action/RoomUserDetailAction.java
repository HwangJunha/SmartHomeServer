package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.RoomUserDetailService;
import vo.ActionForward;
import vo.Admin;

public class RoomUserDetailAction implements Action {
public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{ 
	   	
		String name=request.getParameter("name");
		String code=request.getParameter("code");
		Admin article=null;
		
		RoomUserDetailService roomUserDetailService = new RoomUserDetailService();
		
		
		article=roomUserDetailService.getArticle(name, code);
		ActionForward forward = new ActionForward();
		request.setAttribute("article", article);
	   	request.setAttribute("code", code);
		
   		forward.setPath("/room/qna_room_image_view.jsp");
   		return forward;

	 }
}
