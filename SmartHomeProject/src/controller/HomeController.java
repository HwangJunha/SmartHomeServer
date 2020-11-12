package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.DeviceDataChartAction;
import action.RoomListAction;
import action.RoomListInsertAction;
import action.ServiceUpAction;

import action.RoomDeviceListAction;
import action.RoomDetailAction;
import action.RoomModifyFormAction;
import action.RoomModifyProAction;
import action.RoomWriteFormAction;
import action.RoomWriteProAction;


import action.DeviceViewListAction;
import action.RoomDeviceDetailAction;
import action.RoomDeviceModifyFormAction;
import action.RoomDeviceModifyProAction;
import action.RoomDeviceDeleteProAction;
import action.RoomDeviceWriteFormAction;
import action.RoomDeviceWriteProAction;
import action.RoomDeleteProAction;
import action.RoomImageListAction;
import action.RoomUserListAction;
import action.RoomUserDetailAction;
import action.RoomUserWriteFormAction;
import action.RoomUserWriteProAction;
import action.RoomUserModifyFormAction;
import action.RoomUserModifyProAction;
import action.RoomUserDeleteProAction;
import action.ImageListAction;
import action.RoomImageDeleteAction;

import vo.ActionForward;


@WebServlet("*.bo")
public class HomeController extends javax.servlet.http.HttpServlet  {
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String RequestURI=request.getRequestURI();
		String contextPath=request.getContextPath();
		String command=RequestURI.substring(contextPath.length());
		ActionForward forward=null;
		Action action=null;
		
		 if(command.equals("/roomList.bo")){
				action = new RoomListAction();
				try{
					forward=action.execute(request, response);
				}catch(Exception e){
					e.printStackTrace();
				}
		}else if(command.equals("/roomViewList.bo")){
			action = new RoomListInsertAction();
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}else if(command.equals("/RoomDetail.vo")){
			action = new RoomDetailAction();
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		 else if(command.equals("/roomDevice.bo")){
			action = new RoomDeviceListAction();
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		 else if(command.equals("/DeviceDataChart.bo")) {
			action = new DeviceDataChartAction();
			try{
					forward=action.execute(request, response);
				}catch(Exception e){
					e.printStackTrace();
				}
		 }else if(command.equals("/ServiceUp.bo")) {
			 action = new ServiceUpAction();
				try{
						forward=action.execute(request, response);
					}catch(Exception e){
						e.printStackTrace();
				}
		 }else if(command.equals("/RoomDetail.bo")){
				action = new RoomDetailAction();
				try{
					forward=action.execute(request, response);
				}catch(Exception e){
					e.printStackTrace();
				}
		}else if(command.equals("/RoomWriteForm.bo")){
			action = new RoomWriteFormAction();
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
				
			}
		}else if(command.equals("/RoomWritePro.bo")){
			action = new RoomWriteProAction();
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
				
			}
		}else if(command.equals("/RoomModifyForm.bo")){
				action = new RoomModifyFormAction();
				try{
					forward=action.execute(request, response);
				}catch(Exception e){
					e.printStackTrace();
					
				}
		}else if(command.equals("/RoomModifyPro.bo")){
				action = new RoomModifyProAction();
				try{
					forward=action.execute(request, response);
				}catch(Exception e){
					e.printStackTrace();
					
				}
		
		}else if(command.equals("/RoomDeletePro.bo")){
			action = new RoomDeleteProAction();
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
				
			}
	
		}else if(command.equals("/deviceViewList.bo")){
				action = new DeviceViewListAction();
				try{
					forward=action.execute(request, response);
				}catch(Exception e){
					e.printStackTrace();
					
				}
		}else if(command.equals("/DeviceDetail.bo")){
				action = new RoomDeviceDetailAction();
				try{
					forward=action.execute(request, response);
				}catch(Exception e){
					e.printStackTrace();
					
				}
		}else if(command.equals("/DeviceModifyForm.bo")){
				action = new RoomDeviceModifyFormAction();
				try{
					forward=action.execute(request, response);
				}catch(Exception e){
					e.printStackTrace();
					
				}
			}else if(command.equals("/DeviceModifyPro.bo")){
				action = new RoomDeviceModifyProAction();
				try{
					forward=action.execute(request, response);
				}catch(Exception e){
					e.printStackTrace();
					
				}
			}else if(command.equals("/DevicDeletePro.bo")){
				action = new RoomDeviceDeleteProAction();
				try{
					forward=action.execute(request, response);
				}catch(Exception e){
					e.printStackTrace();
						
				}
			}else if(command.equals("/RoomDeviceWriteForm.bo")){
				action = new RoomDeviceWriteFormAction();
				try{
					forward=action.execute(request, response);
				}catch(Exception e){
					e.printStackTrace();
						
				}
			}else if(command.equals("/RoomDeviceWritePro.bo")){
				action = new RoomDeviceWriteProAction();
				try{
					forward=action.execute(request, response);
				}catch(Exception e){
					e.printStackTrace();
				}
			}else if(command.equals("/roomImage.bo")){
				action = new RoomImageListAction();
				try{
					forward=action.execute(request, response);
				}catch(Exception e){
					e.printStackTrace();
					
			}
		}else if(command.equals("/UserViewList.bo")){
			action = new RoomUserListAction();
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
				
			}
		}else if(command.equals("/UserDetail.bo")){
			action = new RoomUserDetailAction();
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
				
			}
		}else if(command.equals("/UserWriteForm.bo")){
			action = new RoomUserWriteFormAction();
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
			
		}else if(command.equals("/UserWritePro.bo")){
			action = new RoomUserWriteProAction();
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
			
			
		}else if(command.equals("/UserModifyForm.bo")){
			action = new RoomUserModifyFormAction();
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
			
		}else if(command.equals("/UserModifyPro.bo")){
			action = new RoomUserModifyProAction();
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}else if(command.equals("/UserDeletePro.bo")){
			action = new RoomUserDeleteProAction();
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
				
			}
		}else if(command.equals("/ImageList.bo")){
			action = new ImageListAction();
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
				
			}
		}else if(command.equals("/roomImageDelete.bo")){
			action = new RoomImageDeleteAction();
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
	

