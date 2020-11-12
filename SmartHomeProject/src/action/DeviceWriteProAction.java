package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.DeviceWriteProService;
import vo.ActionForward;
import vo.Device;

public class DeviceWriteProAction implements Action {
	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{

		ActionForward forward=null;
		Device device = null;
		
		device = new  Device();
		
	
		device.setName(request.getParameter("name"));
		device.setDeviceKind(request.getParameter("kind"));
		device.setModel(request.getParameter("model"));
		
	
		DeviceWriteProService deviceWriteProService= new DeviceWriteProService();
		
		boolean isWriteSuccess =deviceWriteProService.registArticle(device);
		
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
			forward.setPath("UserList.am");
		}

		return forward;
		
	}
}
