package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getUserConnection;

import java.sql.Connection;
import java.util.ArrayList;

import dao.UserDAO;
import utils.AllUser;
import vo.Admin;

public class RoomUserListService {
	public ArrayList<Admin> getArticleList(String code) throws Exception{
		ArrayList<Admin> articleList = null;
		Connection con = getUserConnection(AllUser.users.get(code));
		UserDAO userDAO = UserDAO.getInstance();
		userDAO.setConnection(con);
		articleList = userDAO.selectArticleListRoom();
		close(con);
		return articleList;
	}
}
