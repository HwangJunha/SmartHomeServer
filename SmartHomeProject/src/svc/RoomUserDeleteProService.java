package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getUserConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import dao.UserDAO;
import utils.AllUser;

public class RoomUserDeleteProService {
	public boolean isArticleWriter(String name, String code) throws Exception {
		// TODO Auto-generated method stub
		
		boolean isArticleWriter = false;
		
		Connection con = getUserConnection(AllUser.users.get(code));
		UserDAO userDAO = UserDAO.getInstance();
		userDAO.setConnection(con);
		
		isArticleWriter = userDAO.isArticleUserWriterRoom(name);
		close(con);
		return isArticleWriter;
		
	}
	public boolean removeArticle(String name, String code) throws Exception {
		// TODO Auto-generated method stub
		
		boolean isDeleteSuccess = false;
		Connection con = getUserConnection(AllUser.users.get(code));
		UserDAO userDAO = UserDAO.getInstance();
		userDAO.setConnection(con);
		
		int updateCount = userDAO.deleteArticleRoom(name);
		
		if(updateCount > 0){
			isDeleteSuccess=true;
		}
		else{
			rollback(con);
		}
		
		
		close(con);
		return isDeleteSuccess;
		
	}
}
