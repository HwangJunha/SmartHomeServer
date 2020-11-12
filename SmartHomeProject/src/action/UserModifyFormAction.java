package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.UserDetailService;
import vo.ActionForward;
import vo.Admin;

public class UserModifyFormAction implements Action {
	
	 public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{
		 
		 	ActionForward forward = new ActionForward();
			String id=request.getParameter("id");
			String page=request.getParameter("page");
			
			
			
			UserDetailService userDetailService= new UserDetailService();	
		   	
			Admin article =userDetailService.getArticle(id);
			
		   	request.setAttribute("article", article);
	   		request.setAttribute("nowPage", page);
	   		
		   	forward.setPath("/User/qna_user_modify.jsp");
	   		return forward;
	   		
	 }
}
