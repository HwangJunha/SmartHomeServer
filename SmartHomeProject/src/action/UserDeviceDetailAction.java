package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.UserDeviceDetailService;
import vo.ActionForward;
import vo.UserDevice;

public class UserDeviceDetailAction implements Action {
public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{ 
	   	
		String model=request.getParameter("model");
		String page = request.getParameter("page");
		
		
		UserDeviceDetailService userDeviceDetailService = new UserDeviceDetailService();
		
		UserDevice article = userDeviceDetailService.getArticle(model);
		
		ActionForward forward = new ActionForward();
		request.setAttribute("page", page);
	   	
		request.setAttribute("article", article);
   		forward.setPath("/UserDevice/qna_user_device_view.jsp");
   		
   		return forward;

	 }
}
