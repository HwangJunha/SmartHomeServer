package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.LoginService;
import svc.RoomImageListService;
import vo.ActionForward;
import vo.Admin;

public class RoomImageListAction implements Action{
	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{
		 
		ArrayList<Admin> articleList=new ArrayList<>();
		LoginService service= new LoginService();
		ActionForward forward= new ActionForward();
		String code=request.getParameter("code");
		
		request.setAttribute("code", code);  
		
		service.getUserCode(code); //방의 데이터 정보를 받아 오기전에 객체를 등록 해줘야함
		RoomImageListService roomImageListService = new RoomImageListService();
		
		articleList = roomImageListService.getArticleList(code);  //리스트를 받아옴.
		
		request.setAttribute("articleList", articleList);
		request.setAttribute("code", code);
		
		forward.setPath("/room/qna_room_image.jsp");
   		return forward;
	 }
}