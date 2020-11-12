package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.getUserConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import dao.RoomDAO;
import utils.AllUser;
import vo.Room;

public class RoomModifyProService {
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

	public boolean modifyArticle(Room article, String name, String code) throws Exception {
		// TODO Auto-generated method stub
		
		boolean isModifySuccess = false;
		Connection con = getUserConnection(AllUser.users.get(code));
		RoomDAO roomDAO = RoomDAO.getInstance();
		roomDAO.setConnection(con);
		
		int updateCount = roomDAO.updateArticle(article,name);
		
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
