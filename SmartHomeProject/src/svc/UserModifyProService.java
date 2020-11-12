package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import dao.UserDAO;
import vo.Admin;

public class UserModifyProService {
	public boolean isArticleWriter(String id) throws Exception {
		// TODO Auto-generated method stub
		
		boolean isArticleWriter = false;
		Connection con = getConnection();
		UserDAO userDAO =  UserDAO.getInstance();
		
		userDAO.setConnection(con);
		
		isArticleWriter = userDAO.isArticleUserWriter(id);
		close(con);
		return isArticleWriter;
		
	}

	public boolean modifyArticle(Admin article, String id) throws Exception {
		// TODO Auto-generated method stub
		
		boolean isModifySuccess = false;
		Connection con = getConnection();
		UserDAO userDAO =  UserDAO.getInstance();
		userDAO.setConnection(con);
		int updateCount = userDAO.updateArticle(article,id);
		
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
