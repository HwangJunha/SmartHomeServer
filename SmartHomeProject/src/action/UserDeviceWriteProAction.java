package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.UserDeviceWriteProService;
import vo.ActionForward;
import vo.UserDevice;

public class UserDeviceWriteProAction implements Action {
	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{

		ActionForward forward=null;
		UserDevice userDevice = null;
		
		userDevice = new  UserDevice();
		
		userDevice.setId(request.getParameter("id"));
		userDevice.setKind(request.getParameter("kind"));
		userDevice.setName(request.getParameter("name"));
		userDevice.setModel(request.getParameter("model"));
		userDevice.setPcDate(request.getParameter("pcDate"));
		
		
	
		UserDeviceWriteProService userDeviceWriteProService= new UserDeviceWriteProService();
		
		boolean isWriteSuccess =userDeviceWriteProService.registArticle(userDevice);
		
		if(!isWriteSuccess){
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('등록 실패')");
			out.println("history.back();");
			out.println("</script>");
		}
		else{
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("UserDeviceList.am");
		}

		return forward;
		
	}  	
}