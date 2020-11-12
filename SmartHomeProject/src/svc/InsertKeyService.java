package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.getUserConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;
import dao.DoorLockDAO;
import utils.AllUser;

public class InsertKeyService {
	public boolean registArticle(String key, String code) throws Exception{
		// TODO Auto-generated method stub
		
		boolean isWriteSuccess = false;
		
		Connection con = getUserConnection(AllUser.users.get(code));
		
		DoorLockDAO DLDAO = DoorLockDAO.getInstance();
		
		
		DLDAO.setConnection(con);
		
		
		int insertCount = DLDAO.insertKey(key);
		
		if(insertCount > 0){
			commit(con);
			isWriteSuccess = true;
		}
		else{
			rollback(con);
		}
		
		close(con);
		return isWriteSuccess;
		
	}
}
