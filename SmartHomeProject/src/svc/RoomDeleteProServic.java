package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getUserConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import dao.RoomDAO;
import utils.AllUser;

public class RoomDeleteProServic {
	public boolean isArticleWriter(String name, String code) throws Exception {
		// TODO Auto-generated method stub
		
		boolean isArticleWriter = false;
		
		Connection con = getUserConnection(AllUser.users.get(code));
		RoomDAO roomDAO = RoomDAO.getInstance();
		roomDAO.setConnection(con);
		
		isArticleWriter = roomDAO.isArticleRoomWriter(name);
		close(con);
		return isArticleWriter;
		
	}
	public boolean removeArticle(String name, String code) throws Exception {
		// TODO Auto-generated method stub
		
		boolean isDeleteSuccess = false;
		Connection con = getUserConnection(AllUser.users.get(code));
		RoomDAO roomDAO = RoomDAO.getInstance();
		roomDAO.setConnection(con);
		
		int updateCount = roomDAO.deleteArticleRoom(name);
		
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
