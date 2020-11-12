package action;

import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.RoomModifyProService;
import vo.ActionForward;
import vo.Room;

public class RoomModifyProAction implements Action {

	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) 
			throws Exception{

		ActionForward forward = null;
		boolean isModifySuccess = false;
		
		String code=request.getParameter("code");
		String name = request.getParameter("name");
		
		
		System.out.println("name:"+name+"code:"+code);
		Room article=new Room();
		
		RoomModifyProService roomModifyProService = new RoomModifyProService();
		
		boolean isRightRoom=roomModifyProService.isArticleWriter(name, code);
		
		if(!isRightRoom){
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out=response.getWriter();
			out.println("<script>");
			out.println("alert('수정할 권한이 없습니다.');");
			out.println("history.back();");
			out.println("</script>");
		}
		else{
			article.setKind(request.getParameter("kind"));
			article.setRoomName(request.getParameter("mName"));
			article.setSize(Integer.parseInt(request.getParameter("size")));
			
			

			isModifySuccess = roomModifyProService.modifyArticle(article, name, code);

			if(!isModifySuccess){
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out=response.getWriter();
				out.println("<script>");
				out.println("alert('수정실패');");
				out.println("history.back()");
				out.println("</script>");
			}
			else{
				forward = new ActionForward();
				forward.setRedirect(true);
				forward.setPath("RoomDetail.bo?name="+URLEncoder.encode(article.getRoomName(),"UTF-8")+"&code="+code); 
				
			}

		}

		return forward;
	}
}
