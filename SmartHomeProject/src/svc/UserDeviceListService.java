package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import dao.UserDeviceDAO;
import vo.UserDevice;

public class UserDeviceListService {
	public int getListCount() throws Exception{
		// TODO Auto-generated method stub
		
		int listCount = 0;
		Connection con = getConnection();
		UserDeviceDAO userDeviceDAO = UserDeviceDAO.getInstance();
		userDeviceDAO.setConnection(con);
		listCount = userDeviceDAO.selectListCount();
		close(con);
		return listCount;
		
	}

	public ArrayList<UserDevice> getArticleList(int page, int limit) throws Exception{
		
		ArrayList<UserDevice> articleList = null;
		Connection con = getConnection();
		UserDeviceDAO userDeviceDAO = UserDeviceDAO.getInstance();
		userDeviceDAO.setConnection(con);
		articleList = userDeviceDAO.selectArticleList(page,limit);
		close(con);
		return articleList;
		
	}
}
