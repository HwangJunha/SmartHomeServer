package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.RoomDeviceWriteService;
import vo.ActionForward;
import vo.Device;

public class RoomDeviceWriteProAction implements Action {
	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{

		ActionForward forward=null;
		Device device = null;
		
		device = new  Device();
		
		String code = request.getParameter("code");
		String room = request.getParameter("RoomName");
		String kind = request.getParameter("kind");
		String name = request.getParameter("name");
		String model = request.getParameter("model");
		
		device.setRoomName(room);
		device.setName(name);
		device.setDeviceKind(kind);
		device.setModel(model);
		
		RoomDeviceWriteService roomDeviceWriteProService= new RoomDeviceWriteService();
		
		boolean isWriteSuccess =roomDeviceWriteProService.registArticle(device, code);
		
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
			forward.setPath("deviceViewList.bo?code="+code);
		}

		return forward;
		
	}
}
