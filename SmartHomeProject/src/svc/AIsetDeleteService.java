package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getUserConnection;
import static db.JdbcUtil.rollback;

import java.io.IOException;
import java.sql.Connection;

import Pi.UserAI;
import dao.AISetDAO;
import utils.AllUser;
import vo.AISet;

public class AIsetDeleteService {
	public boolean AIsetDeleteService(AISet article, String code) {
		boolean isDeleteSuccess=false;
		int deleteCount=0;
		Connection con = getUserConnection(AllUser.users.get(code));
		AISetDAO aiSetDAO = AISetDAO.getInstance();
		aiSetDAO.setConnection(con);
		
		deleteCount = aiSetDAO.deleteArticle(article);
		
		if(deleteCount > 0){
			isDeleteSuccess = true;
		}
		else{
			rollback(con);
		}
		close(con);
		return isDeleteSuccess;
	}
	public String AIcom(String msg, String code) throws Exception, IOException {
		String result="";
		UserAI userAi= new UserAI(code);
		result=userAi.Communication(msg);
		return result;
	}
}
