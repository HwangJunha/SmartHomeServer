package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.DeviceDetailService;
import vo.ActionForward;
import vo.Device;

public class DeviceModifyFormAction implements Action {
	
	 public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{
		 
		 	ActionForward forward = new ActionForward();
			String model=request.getParameter("model");
			String page=request.getParameter("page");
			
			
			
			DeviceDetailService deviceDetailService= new DeviceDetailService();	
		   	
			Device article =deviceDetailService.getArticle(model);
			
		   	request.setAttribute("article", article);
	   		request.setAttribute("nowPage", page);
	   		
		   	forward.setPath("/Device/qna_device_modify.jsp");
	   		return forward;
	   		
	 }
}
