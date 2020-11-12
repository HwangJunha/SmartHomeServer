package action;


import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.LoginService;
import svc.RoomListService;
import utils.AllUser;
import vo.ActionForward;
import vo.Room;


public class RoomListAction implements Action{
	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{
		 
		ArrayList<Room> articleList=new ArrayList<>();
		LoginService service= new LoginService();
		ActionForward forward= new ActionForward();
		String code=request.getParameter("code");
		
		request.setAttribute("code", code);  
		
		service.getUserCode(code); //방의 데이터 정보를 받아 오기전에 객체를 등록 해줘야함
		RoomListService roomListService = new RoomListService();
		
		articleList = roomListService.getArticleList(code);  //리스트를 받아옴.
		
		request.setAttribute("articleList", articleList);
		request.setAttribute("code", code);
		
		forward.setPath("/room/qna_room_list.jsp");
   		return forward;
	 }
}