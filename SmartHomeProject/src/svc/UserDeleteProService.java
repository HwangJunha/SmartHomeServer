package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import dao.UserDAO;

public class UserDeleteProService {
	public boolean isArticleWriter(String id) throws Exception {
		// TODO Auto-generated method stub
		
		boolean isArticleWriter = false;
		Connection con = getConnection();
		UserDAO userDAO =UserDAO.getInstance();
		userDAO.setConnection(con);
		isArticleWriter = userDAO.isArticleUserWriter(id);
		
		close(con);
		return isArticleWriter;
		
	}

	public boolean removeArticle(String id) throws Exception{
		// TODO Auto-generated method stub
		
		boolean isRemoveSuccess = false;
		
		Connection con = getConnection();
		UserDAO userDAO = UserDAO.getInstance();
		
		userDAO.setConnection(con);
		int deleteCount = userDAO.deleteArticle(id);
		
		if(deleteCount > 0){
			isRemoveSuccess=true;
		}
		else{
			rollback(con);
		}
		
		close(con);
		return isRemoveSuccess;
	}
}
