package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.ServiceDetailService;
import vo.ActionForward;
import vo.ServiceUp;

public class ServiceDetailAction implements Action {
public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{ 
	   	
		String model=request.getParameter("model");
		String page = request.getParameter("page");
		
		
		ServiceDetailService serviceDetailService = new ServiceDetailService();
		
		ServiceUp article = serviceDetailService.getArticle(model);
		
		ActionForward forward = new ActionForward();
		request.setAttribute("page", page);
	   	
		request.setAttribute("article", article);
   		forward.setPath("/ServiceUp/qna_service_view.jsp");
   		
   		return forward;

	 }
}
