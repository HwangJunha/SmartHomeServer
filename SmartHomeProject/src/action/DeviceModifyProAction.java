package action;

import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.DeviceModifyProService;
import vo.ActionForward;
import vo.Device;

public class DeviceModifyProAction implements Action {

	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) 
			throws Exception{

		ActionForward forward = null;
		boolean isModifySuccess = false;
		
		String model=request.getParameter("model");
		String nowPage = request.getParameter("nowPage");
		
		
		Device article=new Device();
		
		DeviceModifyProService deviceModifyProService = new DeviceModifyProService();
		
		boolean isRightUser=deviceModifyProService.isArticleWriter(model);
		
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
			article.setName(request.getParameter("name"));
			article.setDeviceKind(request.getParameter("kind"));
			

			isModifySuccess = deviceModifyProService.modifyArticle(article, model);

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
				forward.setPath("DeviceDetail.am?model="+URLEncoder.encode(article.getModel(),"UTF-8")+"&page="+nowPage); 
			}

		}

		return forward;
	}
}
