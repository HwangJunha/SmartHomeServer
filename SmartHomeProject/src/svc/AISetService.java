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

public class AISetService {
	public boolean AIsetWriteService(AISet article, String code) {
		boolean isWriteSuccess=false;
		int insertCount=0;
		Connection con = getUserConnection(AllUser.users.get(code));
		AISetDAO aiSetDAO = AISetDAO.getInstance();
		aiSetDAO.setConnection(con);
		
		insertCount = aiSetDAO.insertArticle(article);
		
		if(insertCount > 0){
			isWriteSuccess = true;
		}
		else{
			rollback(con);
		}
		close(con);
		return isWriteSuccess;
	}
	public String AIcom(String msg, String code) throws Exception, IOException {
		String result="";
		UserAI userAi= new UserAI(code);
		result=userAi.Communication(msg);
		return result;
	}
}
