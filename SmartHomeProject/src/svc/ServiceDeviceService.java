package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import dao.ServiceDAO;


public class ServiceDeviceService {
	public boolean isArticleWriter(String id) throws Exception {
		// TODO Auto-generated method stub
		
		boolean isArticleWriter = false;
		Connection con = getConnection();
		ServiceDAO serviceDAO =  ServiceDAO.getInstance();
		
		serviceDAO.setConnection(con);
		
		isArticleWriter = serviceDAO.isArticleServiceWriter(id);
		close(con);
		return isArticleWriter;
		
	}
	public String isDeviceWriter(String kind) throws Exception {
		// TODO Auto-generated method stub
		
		String model = "";
		Connection con = getConnection();
		ServiceDAO serviceDAO =  ServiceDAO.getInstance();
		
		serviceDAO.setConnection(con);
		
		model = serviceDAO.isDeviceArticle(kind);
		close(con);
		return model;
		
	}
	public boolean deviceListArticle(String model,int state) throws Exception {
		// TODO Auto-generated method stub
		
		boolean isModifySuccess = false;
		Connection con = getConnection();
		ServiceDAO serviceDAO =  ServiceDAO.getInstance();
		serviceDAO.setConnection(con);
		int updateCount = serviceDAO.DeviceListArticle(model,state);
		
		if(updateCount > 0){
			isModifySuccess=true;
		}
		else{
			rollback(con);
		}
		
		close(con);
		return isModifySuccess;
		
	}public boolean devicePoessessionArticle(String model,int state) throws Exception {
		// TODO Auto-generated method stub
		
		boolean isModifySuccess = false;
		Connection con = getConnection();
		ServiceDAO serviceDAO =  ServiceDAO.getInstance();
		serviceDAO.setConnection(con);
		int updateCount = serviceDAO.DevicePossessionArticle(model,state);
		
		if(updateCount > 0){
			isModifySuccess=true;
		}
		else{
			rollback(con);
		}
		
		close(con);
		return isModifySuccess;
		
	}
}
