package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getUserConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import dao.UserDAO;
import utils.AllUser;
import vo.Admin;

public class RoomUserModifyProService {
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

	public boolean modifyArticle(Admin article, String name, String code) throws Exception {
		// TODO Auto-generated method stub
		
		boolean isModifySuccess = false;

		Connection con = getUserConnection(AllUser.users.get(code));
		UserDAO userDAO = UserDAO.getInstance();
		userDAO.setConnection(con);
		
		int updateCount = userDAO.updateArticleRoom(article,name);
		
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
