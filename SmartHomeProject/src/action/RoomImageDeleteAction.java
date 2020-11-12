package action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.LoginService;
import vo.ActionForward;

public class RoomImageDeleteAction implements Action{
	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{
		 
		LoginService service= new LoginService();
		ActionForward forward= new ActionForward();
		String code=request.getParameter("code");
		String name=request.getParameter("name");
		
		request.setAttribute("code", code);  
		
		service.getUserCode(code); //방의 데이터 정보를 받아 오기전에 객체를 등록 해줘야함
		
		
		request.setAttribute("name", name);
		request.setAttribute("code", code);
		
		forward.setPath("/image/ImageDelete.jsp");
   		return forward;
	 }
}
