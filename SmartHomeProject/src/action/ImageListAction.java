package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.LoginService;
import svc.FileRegisterService;
import vo.ActionForward;


public class ImageListAction implements Action{
	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{
		 
		
		LoginService service= new LoginService();
		ActionForward forward= new ActionForward();
		String path=null;
		String code=request.getParameter("code");
		String name= request.getParameter("name");
		
		service.getUserCode(code); //방의 데이터 정보를 받아 오기전에 객체를 등록 해줘야함
		FileRegisterService fileRegisterService = new FileRegisterService();
		fileRegisterService.MakeDir2(name, code); //파일 생성
		fileRegisterService.MakeDir(name, code); //파일 생성
		
		
	   	request.setAttribute("code", code);
	   	request.setAttribute("name", name);
		
	   	
		forward.setPath("/image/ImagePreView.jsp");
   		return forward;
	 }
}