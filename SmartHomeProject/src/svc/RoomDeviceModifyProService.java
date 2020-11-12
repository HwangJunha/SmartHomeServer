package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getUserConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import dao.DeviceDAO;
import utils.AllUser;
import vo.Device;

public class RoomDeviceModifyProService {
	public boolean isArticleWriter(String model, String code) throws Exception {
		// TODO Auto-generated method stub
		
		boolean isArticleWriter = false;
		
		Connection con = getUserConnection(AllUser.users.get(code));
		DeviceDAO deviceDAO = DeviceDAO.getInstance();
		deviceDAO.setConnection(con);
		
		isArticleWriter = deviceDAO.isArticleDeviceWriter(model);
		close(con);
		return isArticleWriter;
		
	}

	public boolean modifyArticle(Device article, String model, String code) throws Exception {
		// TODO Auto-generated method stub
		
		boolean isModifySuccess = false;
		Connection con = getUserConnection(AllUser.users.get(code));
		DeviceDAO deviceDAO = DeviceDAO.getInstance();
		deviceDAO.setConnection(con);
		
		int updateCount = deviceDAO.updateArticleRoom(article,model);
		
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
