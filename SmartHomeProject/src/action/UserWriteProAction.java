package action;

import java.io.PrintWriter;
import java.util.StringTokenizer;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.UserWriteProService;
import vo.ActionForward;
import vo.Admin;

public class UserWriteProAction implements Action {
	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{

		ActionForward forward=null;
		Admin user = null;
		
		
//		String realFolder="";
//		String saveFolder="/UserUpload";
//		
//	
//		
//		ServletContext context = request.getServletContext();
//		realFolder=context.getRealPath(saveFolder);   		
//		
		
		user = new  Admin();
		
		
		
		user.setCode(request.getParameter("code"));
		user.setId(request.getParameter("id"));
		user.setPwd(request.getParameter("password"));
		user.setName(request.getParameter("name"));
		user.setEmail(request.getParameter("email"));
		user.setPhone(request.getParameter("number"));
		user.setZip_code(request.getParameter("zipCode"));
		user.setAddr(request.getParameter("address"));
		user.setAddr2(request.getParameter("address2"));
		user.setIp(request.getParameter("ip"));
		
		StringTokenizer tokens = new StringTokenizer(user.getAddr());
		String cityName= tokens.nextToken(" "); //도 
		String townName= tokens.nextToken(" "); //시
		//지역번호 구하기
		String cityId=utils.EConsonantsReturn.getCityNumber(cityName);
		user.setCityId(cityId); //지역 번호 저장
		
		String cityEnglish = utils.EConsonantsReturn.getInitEngilsh(cityName); //도 코드 구하기
		String townEnglish = utils.EConsonantsReturn.getInitEngilsh(townName); //시 코드 구하기
		
		user.setCode(cityEnglish+townEnglish); //코드 저장
		
		UserWriteProService userWriteProService= new UserWriteProService();
		
		boolean isWriteSuccess =userWriteProService.registArticle(user);
		
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
