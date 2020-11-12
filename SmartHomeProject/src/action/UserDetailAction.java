package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.UserDetailService;
import vo.ActionForward;
import vo.Admin;

public class UserDetailAction implements Action {
public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{ 
	   	
		String id=request.getParameter("id");
		String page = request.getParameter("page");
		
		
		UserDetailService userDetailService = new UserDetailService();
		
		Admin article = userDetailService.getArticle(id);
		
		ActionForward forward = new ActionForward();
		request.setAttribute("page", page);
	   	
		request.setAttribute("article", article);
   		forward.setPath("/User/qna_user_view.jsp");
   		
   		return forward;

	 }
}
