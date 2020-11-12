package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.LoginService;
import utils.AllUser;
import vo.ActionForward;
import vo.Admin;

public class ServiceUpAction implements Action{
	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{
		ActionForward forward= new ActionForward();
		LoginService loginService = new LoginService();
		String code=request.getParameter("code");
		Admin loginMember=new Admin();
		loginService.getUserCode(code);
		loginMember=AllUser.users.get(code);
		
		request.setAttribute("loginMember", loginMember); //사용자 넘기기
		
		
		forward.setPath("/ServiceUp/ServiceUp.jsp");
		return forward;
	}
}
