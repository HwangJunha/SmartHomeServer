package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.ServiceListService;
import svc.ServiceDeviceService;
import vo.ActionForward;
import vo.PageInfo;
import vo.ServiceUp;

public class ServiceDeviceInsertAction implements Action {
	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{
		 
		ArrayList<ServiceUp> articleList=new ArrayList<>();
	  	int page=1;
		int limit=10;
		
		int state=Integer.parseInt(request.getParameter("state")); //현재 상태
		String model= request.getParameter("model");
		
		if(request.getParameter("page")!=null){
			page=Integer.parseInt(request.getParameter("page"));
		}
		ServiceDeviceService serviceDeviceService = new ServiceDeviceService();
		if(state==2){ //재고가 대기중
			boolean isDevice= false;
			String kind= request.getParameter("kind");
			model=serviceDeviceService.isDeviceWriter(kind);
			if(!model.equals("")) { //재고가 입고가 안 되었을시 ""이 반환된다.
				isDevice=serviceDeviceService.deviceListArticle(model, 1); //재고가 있을경우 true 없을경우 false
			}
			
			if(isDevice) { //재고가 있는지 확인
				serviceDeviceService.devicePoessessionArticle(model, 0); //설치 전
			}
		}else if(state==0) { // 설치전
			serviceDeviceService.devicePoessessionArticle(model, 1); //설치후로 변경
		}
		
		ServiceListService serviceListService = new ServiceListService();
		int listCount=serviceListService.getListCount();  //총 리스트 수를 받아옴.
		articleList = serviceListService.getArticleList(page,limit);  //리스트를 받아옴.
		//0.95를 더해서 올림 처리.
   		int maxPage=(int)((double)listCount/limit+0.95); 
   		//현재 페이지에 보여줄 시작 페이지 수(1, 11, 21 등...)
   		int startPage = (((int) ((double)page / 10 + 0.9)) - 1) * 10 + 1;
   		//현재 페이지에 보여줄 마지막 페이지 수.(10, 20, 30 등...)
   	        int endPage = startPage+10-1;

   		if (endPage> maxPage) endPage= maxPage;

   		PageInfo pageInfo = new PageInfo();
   		
   		pageInfo.setEndPage(endPage);
   		pageInfo.setListCount(listCount);
		pageInfo.setMaxPage(maxPage);
		pageInfo.setPage(page);
		pageInfo.setStartPage(startPage);	
		
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("articleList", articleList);
		
		ActionForward forward= new ActionForward();
   		
		forward.setPath("/ServiceUp/qna_service_list.jsp");
   		return forward;
   		
	 }
}
