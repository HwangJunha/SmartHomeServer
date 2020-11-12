package action;

import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.UserModifyProService;

import vo.ActionForward;
import vo.Admin;

public class UserModifyProAction implements Action {

	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) 
			throws Exception{

		ActionForward forward = null;
		boolean isModifySuccess = false;
		
		String id=request.getParameter("id");
		String nowPage = request.getParameter("nowPage");
		
		
		Admin article=new Admin();
		
		UserModifyProService userModifyProService = new UserModifyProService();
		
		boolean isRightUser=userModifyProService.isArticleWriter(id);
		
		if(!isRightUser){
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out=response.getWriter();
			out.println("<script>");
			out.println("alert('수정할 권한이 없습니다.');");
			out.println("history.back();");
			out.println("</script>");
		}
		else{
			
			article.setId(id);
			article.setCode(request.getParameter("code"));
			
			article.setId(request.getParameter("id"));
			
			article.setPwd(request.getParameter("password"));
			
			article.setName(request.getParameter("name"));
			
			article.setEmail(request.getParameter("email"));
			
			article.setPhone(request.getParameter("number"));
			
			article.setCityId(request.getParameter("cityId"));
			
			article.setZip_code(request.getParameter("zipCode"));
			
			article.setAddr(request.getParameter("address"));
			
			article.setAddr2(request.getParameter("address2"));
			
			article.setIp(request.getParameter("ip"));
			

			isModifySuccess = userModifyProService.modifyArticle(article, id);

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
				forward.setPath("UserDetail.am?id="+URLEncoder.encode(article.getId(),"UTF-8")+"&page="+nowPage); 
			}

		}

		return forward;
	}
}
