package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.DeviceDetailService;
import vo.ActionForward;
import vo.Device;

public class DeviceDetailAction implements Action {
public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{ 
	   	
		String id=request.getParameter("model");
		String page = request.getParameter("page");
		
		DeviceDetailService userDetailService = new DeviceDetailService();
		
		Device article = userDetailService.getArticle(id);
		
		ActionForward forward = new ActionForward();
		request.setAttribute("page", page);
	   	
		request.setAttribute("article", article);
   		forward.setPath("/Device/qna_device_view.jsp");
   		
   		return forward;

	 }
}
