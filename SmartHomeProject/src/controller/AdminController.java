package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.DeviceDataChartAction;

import action.UserDeleteProAction;
import action.UserDetailAction;
import action.UserListAction;
import action.UserModifyFormAction;
import action.UserModifyProAction;
import action.UserWriteProAction;

import action.DeviceDeleteProAction;
import action.DeviceDetailAction;
import action.DeviceListAction;
import action.DeviceModifyFormAction;
import action.DeviceModifyProAction;
import action.DeviceWriteProAction;

import action.UserDeviceDeleteProAction;
import action.UserDeviceDetailAction;
import action.UserDeviceListAction;
import action.UserDeviceModifyFormAction;
import action.UserDeviceModifyProAction;
import action.UserDeviceWriteProAction;

import action.ServiceListAction;
import action.ServiceDetailAction;
import action.ServiceIpProAction;
import action.ServiceDeviceInsertAction;

import action.RoomListAction;
import action.ServiceUpAction;
import vo.ActionForward;


@WebServlet("*.am")
public class AdminController extends javax.servlet.http.HttpServlet  {
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String RequestURI=request.getRequestURI();
		String contextPath=request.getContextPath();
		String command=RequestURI.substring(contextPath.length());
		ActionForward forward=null;
		Action action=null;
		
		//사용자 
		if(command.equals("/UserWriteForm.am")){
			forward=new ActionForward();
			forward.setPath("/User/qna_user_write.jsp");
		
		}else if(command.equals("/UserWritePro.am")){
			action  = new UserWriteProAction();
			try {
				forward=action.execute(request, response );
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/UserList.am")){
			action = new UserListAction();
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		else if(command.equals("/UserDetail.am")){
			action = new UserDetailAction();
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		else if(command.equals("/UserModifyForm.am")){
			action = new UserModifyFormAction();
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}else if(command.equals("/UserModifyPro.am")){
			action = new UserModifyProAction();
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		else if(command.equals("/UserDeleteForm.am")){
			String nowPage = request.getParameter("page");
			request.setAttribute("page", nowPage);
			
			String id=request.getParameter("id");
			request.setAttribute("id",id);
			forward=new ActionForward();
			forward.setPath("/User/qna_user_delete.jsp");
		}
		else if(command.equals("/UserDeletePro.am")){
			action = new UserDeleteProAction();
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		//디바이스
		else if(command.equals("/DeviceWriteForm.am")){
			forward=new ActionForward();
			forward.setPath("/Device/qna_device_write.jsp");
			
		}else if(command.equals("/DeviceWritePro.am")){
			action  = new DeviceWriteProAction();
			try {
				forward=action.execute(request, response );
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/DeviceList.am")){
			action = new DeviceListAction();
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		else if(command.equals("/DeviceDetail.am")){
			action = new DeviceDetailAction();
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}

		else if(command.equals("/DeviceModifyForm.am")){
			action = new DeviceModifyFormAction();
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}else if(command.equals("/DeviceModifyPro.am")){
			action = new DeviceModifyProAction();
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		else if(command.equals("/DeviceDeleteForm.am")){
			String nowPage = request.getParameter("page");
			request.setAttribute("page", nowPage);
			
			String model=request.getParameter("model");
			request.setAttribute("model",model);
			forward=new ActionForward();
			forward.setPath("/Device/qna_device_delete.jsp");
		}
		else if(command.equals("/DeviceDeletePro.am")){
			action = new DeviceDeleteProAction();
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}// 사용자 장비
		else if(command.equals("/UserDeviceWriteForm.am")){
			forward=new ActionForward();
			forward.setPath("/UserDevice/qna_user_device_write.jsp");
			
		}else if(command.equals("/UserDeviceWritePro.am")){
			action  = new UserDeviceWriteProAction();
			try {
				forward=action.execute(request, response );
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/UserDeviceList.am")){
			action = new UserDeviceListAction();
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		else if(command.equals("/UserDeviceDetail.am")){
			action = new UserDeviceDetailAction();
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}

		else if(command.equals("/UserDeviceModifyForm.am")){
			action = new UserDeviceModifyFormAction();
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}else if(command.equals("/UserDeviceModifyPro.am")){
			action = new UserDeviceModifyProAction();
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		else if(command.equals("/UserDeviceDeleteForm.am")){
			String nowPage = request.getParameter("page");
			request.setAttribute("page", nowPage);
			
			String model=request.getParameter("model");
			request.setAttribute("model",model);
			forward=new ActionForward();
			forward.setPath("/UserDevice/qna_user_device_delete.jsp");
		}
		else if(command.equals("/UserDeviceDeletePro.am")){
			action = new UserDeviceDeleteProAction();
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		//서비스
		}else if(command.equals("/ServiceList.am")){
			action = new ServiceListAction();
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}else if(command.equals("/ServiceDetail.am")){
			action = new ServiceDetailAction();
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}else if(command.equals("/ServiceIpForm.am")){
			String nowPage = request.getParameter("page");
			request.setAttribute("page", nowPage);
			
			String ip=request.getParameter("ip");
			String id=request.getParameter("id");
			request.setAttribute("ip",ip);
			request.setAttribute("id",id);
			forward=new ActionForward();
			forward.setPath("/ServiceUp/qna_service_ip_insert.jsp");
		}else if(command.equals("/ServiceIpPro.am")){
			action = new ServiceIpProAction();
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}else if(command.equals("/ServiceDeviceInsert.am")){
			action = new ServiceDeviceInsertAction(); //리스트로 돌아감
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		 if(forward != null){

				if(forward.isRedirect()){
					response.sendRedirect(forward.getPath());
				}else{
					RequestDispatcher dispatcher=
							request.getRequestDispatcher(forward.getPath());
					dispatcher.forward(request, response);
				}
				
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doProcess(request,response);
	}  	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doProcess(request,response);
	}   
}
	

