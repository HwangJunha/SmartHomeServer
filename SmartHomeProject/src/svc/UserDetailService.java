package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;

import dao.UserDAO;
import vo.Admin;

public class UserDetailService {
	public Admin getArticle(String id) throws Exception{
		// TODO Auto-generated method stub
		
		Admin article = null;
		Connection con = getConnection();
		UserDAO userDAO = UserDAO.getInstance();
		userDAO.setConnection(con);
		
		
		article = userDAO.selectArticle(id);
		close(con);
		return article;
		
	}
}
