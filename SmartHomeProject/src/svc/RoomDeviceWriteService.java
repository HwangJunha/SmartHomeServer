package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getUserConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import dao.DeviceDAO;
import utils.AllUser;
import vo.Device;

public class RoomDeviceWriteService {
	public boolean registArticle(Device device, String code) throws Exception{
		// TODO Auto-generated method stub
		
		boolean isWriteSuccess = false;
		
		
		Connection con = getUserConnection(AllUser.users.get(code));
		DeviceDAO deviceDAO = DeviceDAO.getInstance();
		deviceDAO.setConnection(con);
		
		
		int insertCount = deviceDAO.insertArticleRoom(device);
		
		if(insertCount > 0){
			isWriteSuccess = true;
		}
		else{
			rollback(con);
		}
		
		close(con);
		return isWriteSuccess;
		
	}
}
