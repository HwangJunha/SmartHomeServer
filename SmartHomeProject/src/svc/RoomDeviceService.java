package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getUserConnection;

import java.sql.Connection;
import java.util.ArrayList;

import dao.UserDeviceDAO;
import utils.AllUser;
import vo.UserDevice;

public class RoomDeviceService {
	public ArrayList<UserDevice> getArticleList(String code) throws Exception{
		ArrayList<UserDevice> articleList = null;
		Connection con = getUserConnection(AllUser.users.get(code));
		UserDeviceDAO userDeviceDAO = UserDeviceDAO.getInstance();
		userDeviceDAO.setConnection(con);
		articleList = userDeviceDAO.selectArticleList();
		close(con);
		return articleList;
	}
}
