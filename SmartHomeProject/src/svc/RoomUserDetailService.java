package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getUserConnection;

import java.sql.Connection;


import dao.UserDAO;
import utils.AllUser;
import vo.Admin;


public class RoomUserDetailService {
	public Admin getArticle(String name, String code) throws Exception{
		// TODO Auto-generated method stub
		
		Admin article = null;
		Connection con = getUserConnection(AllUser.users.get(code));
		UserDAO userDAO = UserDAO.getInstance();
		userDAO.setConnection(con);
		
		article = userDAO.selectArticleRoom(name);
		close(con);
		return article;
		
	}
}
