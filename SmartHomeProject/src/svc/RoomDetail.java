package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getUserConnection;

import java.sql.Connection;

import dao.RoomDAO;
import utils.AllUser;
import vo.Room;

public class RoomDetail {
	public Room getArticle(String name, String code) throws Exception{
		// TODO Auto-generated method stub
		
		Room article = null;
		Connection con = getUserConnection(AllUser.users.get(code));
		RoomDAO roomDAO = RoomDAO.getInstance();
		roomDAO.setConnection(con);
		
		article = roomDAO.selectArticle(name);
		close(con);
		return article;
		
	}
}
