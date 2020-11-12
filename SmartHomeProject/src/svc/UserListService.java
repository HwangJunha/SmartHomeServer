package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import dao.UserDAO;
import vo.Admin;

public class UserListService {
	public int getListCount() throws Exception{
		// TODO Auto-generated method stub
		
		int listCount = 0;
		Connection con = getConnection();
		UserDAO userDAO = UserDAO.getInstance();
		userDAO.setConnection(con);
		listCount = userDAO.selectListCount();
		close(con);
		return listCount;
		
	}

	public ArrayList<Admin> getArticleList(int page, int limit) throws Exception{
		
		ArrayList<Admin> articleList = null;
		Connection con = getConnection();
		UserDAO userDAO = UserDAO.getInstance();
		userDAO.setConnection(con);
		articleList = userDAO.selectArticleList(page,limit);
		close(con);
		return articleList;
		
	}
}
