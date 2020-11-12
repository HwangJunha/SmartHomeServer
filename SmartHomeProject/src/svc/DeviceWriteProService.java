package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import dao.DeviceDAO;
import vo.Device;

public class DeviceWriteProService {
	public boolean registArticle(Device device) throws Exception{
	// TODO Auto-generated method stub
	
	boolean isWriteSuccess = false;
	
	Connection con = getConnection();
	
	DeviceDAO deviceDAO = DeviceDAO.getInstance();
	
	deviceDAO.setConnection(con);
	
	
	int insertCount = deviceDAO.insertArticle(device);
	
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
