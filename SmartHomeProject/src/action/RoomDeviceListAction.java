package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.RoomDeviceService;
import svc.LoginService;

import vo.ActionForward;
import vo.UserDevice;

public class RoomDeviceListAction implements Action{
	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{
		 
		ArrayList<UserDevice> articleList=new ArrayList<>();
		LoginService service= new LoginService();
		RoomDeviceService roomDevicesSrvice= new RoomDeviceService();
		
		ActionForward forward= new ActionForward();
		String code=request.getParameter("code");
		
		request.setAttribute("code", code);  
		
		service.getUserCode(code); //방의 데이터 정보를 받아 오기전에 객체를 등록 해줘야함
		
		articleList = roomDevicesSrvice.getArticleList(code);  //리스트를 받아옴.
		
		request.setAttribute("articleList", articleList);
		request.setAttribute("code", code);
		
		forward.setPath("/room/qna_user_device_list.jsp");
   		return forward;
	 }
}
