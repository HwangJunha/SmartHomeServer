package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import dao.UserDeviceDAO;
import vo.UserDevice;

public class UserDeviceWriteProService {
	public boolean registArticle(UserDevice userDevice) throws Exception{
		// TODO Auto-generated method stub
		
		boolean isWriteSuccess = false;
		
		Connection con = getConnection();
		
		UserDeviceDAO userDeviceDAO = UserDeviceDAO.getInstance();
		
		userDeviceDAO.setConnection(con);
		
		
		int insertCount = userDeviceDAO.insertArticle(userDevice);
		
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
