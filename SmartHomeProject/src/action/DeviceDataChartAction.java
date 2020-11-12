package action;

import java.util.ArrayList;
import java.util.Collections;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.DayChartService;
import svc.DeviceDataService;
import svc.LoginService;
import svc.MonthChartService;
import svc.YearChartService;
import vo.ActionForward;
import vo.DeviceData;
public class DeviceDataChartAction implements Action{
	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{
		 
		String room=request.getParameter("room");
		String date=request.getParameter("date");
		String code=request.getParameter("code");
		
		
		
		ArrayList<DeviceData> articleList = new ArrayList<>();
		ArrayList<DeviceData> chartList= new ArrayList<>();
		
		
		DeviceDataService deviceDataService = new DeviceDataService();
		LoginService codeService = new LoginService();
		
		codeService.getUserCode(code); //코드 등록
		articleList=deviceDataService.getArticleList(room,code);
		Collections.sort(articleList);//날짜순으로 정렬
		
		if(date.equals("day")) {
			DayChartService dayChartService = new DayChartService();
			chartList=dayChartService.ChartService(articleList);
		}
		else if(date.equals("month")){
			MonthChartService monthChartService = new MonthChartService();
			chartList=monthChartService.ChartService(articleList);
			System.out.println("size="+chartList.size());
			
		}else if(date.equals("year")) {
			YearChartService yearChartService = new YearChartService();
			chartList=yearChartService.ChartService(articleList);
		}
		
		request.setAttribute("articleList", chartList);
		request.setAttribute("date",date);
		request.setAttribute("room",room);
		request.setAttribute("code",code);
		
		ActionForward forward= new ActionForward();
   		
		if(date.equals("day")) {
			forward.setPath("/chart/DayChart.jsp");
		}
		else if(date.equals("month")){
			forward.setPath("/chart/MonthChart.jsp");
		}else if(date.equals("year")) {
			forward.setPath("/chart/YearChart.jsp");
		}
		
		return forward;
	 }

}