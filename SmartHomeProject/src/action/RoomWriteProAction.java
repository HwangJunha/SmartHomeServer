package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.RoomWriteService;
import vo.ActionForward;
import vo.Room;

public class RoomWriteProAction implements Action {
	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{

		ActionForward forward=null;
		Room room = null;
		
		room = new  Room();
		
		String code = request.getParameter("code");
		int size = Integer.parseInt(request.getParameter("size"));
		String kind = request.getParameter("kind");
		String name = request.getParameter("name");
		
		room.setRoomName(name);
		room.setSize(size);
		room.setKind(kind);
		
		RoomWriteService roomWriteProService= new RoomWriteService();
		
		boolean isWriteSuccess =roomWriteProService.registArticle(room,code);
		
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
			forward.setPath("UserViewList.bo?code="+code);
		}

		return forward;
		
	}
}
