package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getUserConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import dao.UserDAO;
import utils.AllUser;
import vo.Admin;

public class RoomUserWriteService {
	public boolean registArticle(Admin user, String code) throws Exception{
		// TODO Auto-generated method stub
		
		boolean isWriteSuccess = false;
		
		
		Connection con = getUserConnection(AllUser.users.get(code));
		UserDAO userDAO = UserDAO.getInstance();
		userDAO.setConnection(con);
		
		//사용자 등록
		int insertCount = userDAO.insertArticleRoom(user);
		
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
