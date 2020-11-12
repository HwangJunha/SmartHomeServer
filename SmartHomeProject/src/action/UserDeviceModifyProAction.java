package action;

import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.UserDeviceModifyProService;
import vo.ActionForward;
import vo.UserDevice;

public class UserDeviceModifyProAction implements Action {

	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) 
			throws Exception{

		ActionForward forward = null;
		boolean isModifySuccess = false;
		
		String model=request.getParameter("model");
		String nowPage = request.getParameter("nowPage");
		
		
		UserDevice article=new UserDevice();
		
		UserDeviceModifyProService userDeviceModifyProService = new UserDeviceModifyProService();
		
		boolean isRightUser=userDeviceModifyProService.isArticleWriter(model);
		
		if(!isRightUser){
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out=response.getWriter();
			out.println("<script>");
			out.println("alert('수정할 권한이 없습니다.');");
			out.println("history.back();");
			out.println("</script>");
		}
		else{
			
			article.setModel(model);
			article.setId(request.getParameter("id"));
			
			article.setKind(request.getParameter("kind"));
			
			article.setName(request.getParameter("name"));
			
			article.setPcDate(request.getParameter("pcDate"));
			
			article.setState(Integer.parseInt(request.getParameter("state")));
			

			isModifySuccess = userDeviceModifyProService.modifyArticle(article, model);

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
				forward.setPath("UserDeviceDetail.am?model="+URLEncoder.encode(article.getModel(),"UTF-8")+"&page="+nowPage); 
			}

		}

		return forward;
	}
}
