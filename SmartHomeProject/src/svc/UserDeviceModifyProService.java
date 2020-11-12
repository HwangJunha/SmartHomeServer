package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import dao.UserDeviceDAO;
import vo.UserDevice;

public class UserDeviceModifyProService {
	public boolean isArticleWriter(String model) throws Exception {
		// TODO Auto-generated method stub
		
		boolean isArticleWriter = false;
		Connection con = getConnection();
		UserDeviceDAO userDeviceDAO =  UserDeviceDAO.getInstance();
		
		userDeviceDAO.setConnection(con);
		
		isArticleWriter = userDeviceDAO.isArticleUserDeviceWriter(model);
		close(con);
		return isArticleWriter;
		
	}

	public boolean modifyArticle(UserDevice article, String model) throws Exception {
		// TODO Auto-generated method stub
		
		boolean isModifySuccess = false;
		Connection con = getConnection();
		UserDeviceDAO userDeviceDAO =  UserDeviceDAO.getInstance();
		
		userDeviceDAO.setConnection(con);
		int updateCount = userDeviceDAO.updateArticle(article,model);
		
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
