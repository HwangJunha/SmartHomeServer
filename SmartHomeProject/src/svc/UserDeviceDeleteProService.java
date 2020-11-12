package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import dao.UserDeviceDAO;

public class UserDeviceDeleteProService {
	public boolean isArticleWriter(String model) throws Exception {
		// TODO Auto-generated method stub
		
		boolean isArticleWriter = false;
		Connection con = getConnection();
		UserDeviceDAO userDeviceDAO =UserDeviceDAO.getInstance();
		userDeviceDAO.setConnection(con);
		isArticleWriter = userDeviceDAO.isArticleUserDeviceWriter(model);
		
		close(con);
		return isArticleWriter;
		
	}

	public boolean removeArticle(String model) throws Exception{
		// TODO Auto-generated method stub
		
		boolean isRemoveSuccess = false;
		
		Connection con = getConnection();
		UserDeviceDAO userDeviceDAO =UserDeviceDAO.getInstance();
		userDeviceDAO.setConnection(con);
		int deleteCount = userDeviceDAO.deleteArticle(model);
		
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
