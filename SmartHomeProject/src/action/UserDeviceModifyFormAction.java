package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.UserDeviceDetailService;
import vo.ActionForward;
import vo.UserDevice;

public class UserDeviceModifyFormAction implements Action {
	
	 public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{
		 
		 	ActionForward forward = new ActionForward();
			String model=request.getParameter("model");
			String page=request.getParameter("page");
			
			
			
			UserDeviceDetailService userDeviceDetailService= new UserDeviceDetailService();	
		   	
			UserDevice article =userDeviceDetailService.getArticle(model);
			
		   	request.setAttribute("article", article);
	   		request.setAttribute("nowPage", page);
	   		
		   	forward.setPath("/UserDevice/qna_user_device_modify.jsp");
	   		return forward;
	   		
	 }
}
