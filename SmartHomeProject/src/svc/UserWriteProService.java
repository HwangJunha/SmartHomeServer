package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import dao.UserDAO;
import vo.Admin;

public class UserWriteProService {
	public boolean registArticle(Admin admin) throws Exception{
		// TODO Auto-generated method stub
		
		boolean isWriteSuccess = false;
		
		Connection con = getConnection();
		
		UserDAO userDAO = UserDAO.getInstance();
		
		userDAO.setConnection(con);
		
		
		int insertCount = userDAO.insertArticle(admin);
		
		if(insertCount > 0){
			isWriteSuccess = true;
		}
		else{
			rollback(con);
		}
		
		close(con);
		return isWriteSuccess;
		
	}
}
