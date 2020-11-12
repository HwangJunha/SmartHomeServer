package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;

import dao.UserDeviceDAO;
import vo.UserDevice;

public class UserDeviceDetailService {
	public UserDevice getArticle(String model) throws Exception{
		// TODO Auto-generated method stub
		
		UserDevice article = null;
		Connection con = getConnection();
		UserDeviceDAO userdeviceDAO = UserDeviceDAO.getInstance();
		userdeviceDAO.setConnection(con);
		
		
		article = userdeviceDAO.selectArticle(model);
		close(con);
		return article;
		
	}
}
