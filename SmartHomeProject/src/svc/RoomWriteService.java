package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.getUserConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import dao.RoomDAO;
import utils.AllUser;
import vo.Room;

public class RoomWriteService {
	public boolean registArticle(Room room, String code) throws Exception{
		// TODO Auto-generated method stub
		
		boolean isWriteSuccess = false;
		
		
		Connection con = getUserConnection(AllUser.users.get(code));
		RoomDAO roomDAO = RoomDAO.getInstance();
		roomDAO.setConnection(con);
		
		
		int insertCount = roomDAO.insertArticle(room);
		
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
