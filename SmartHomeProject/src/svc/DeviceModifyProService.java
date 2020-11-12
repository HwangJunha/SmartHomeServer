package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import dao.DeviceDAO;
import vo.Device;

public class DeviceModifyProService {
	public boolean isArticleWriter(String model) throws Exception {
		// TODO Auto-generated method stub
		
		boolean isArticleWriter = false;
		Connection con = getConnection();
		DeviceDAO deviceDAO =  DeviceDAO.getInstance();
		
		deviceDAO.setConnection(con);
		
		isArticleWriter = deviceDAO.isArticleDeviceWriter(model);
		close(con);
		return isArticleWriter;
		
	}

	public boolean modifyArticle(Device article, String model) throws Exception {
		// TODO Auto-generated method stub
		
		boolean isModifySuccess = false;
		Connection con = getConnection();
		DeviceDAO deviceDAO =  DeviceDAO.getInstance();
		deviceDAO.setConnection(con);
		int updateCount = deviceDAO.updateArticle(article,model);
		
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
