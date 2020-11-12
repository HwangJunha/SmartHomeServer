package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import dao.DeviceDAO;

public class DeviceDeleteProServic {
	public boolean isArticleWriter(String model) throws Exception {
		// TODO Auto-generated method stub
		
		boolean isArticleWriter = false;
		Connection con = getConnection();
		DeviceDAO deviceDAO =DeviceDAO.getInstance();
		deviceDAO.setConnection(con);
		isArticleWriter = deviceDAO.isArticleDeviceWriter(model);
		
		close(con);
		return isArticleWriter;
		
	}

	public boolean removeArticle(String model) throws Exception{
		// TODO Auto-generated method stub
		
		boolean isRemoveSuccess = false;
		
		Connection con = getConnection();
		DeviceDAO deviceDAO = DeviceDAO.getInstance();
		
		deviceDAO.setConnection(con);
		int deleteCount = deviceDAO.deleteArticle(model);
		
		if(deleteCount > 0){
			isRemoveSuccess=true;
		}
		else{
			rollback(con);
		}
		
		close(con);
		return isRemoveSuccess;
	}
}
