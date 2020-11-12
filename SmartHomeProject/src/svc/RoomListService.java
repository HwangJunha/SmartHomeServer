package svc;

import static db.JdbcUtil.*;
import java.sql.Connection;
import java.util.ArrayList;
import dao.RoomDAO;
import utils.AllUser;
import vo.Room;

public class RoomListService {

	public ArrayList<Room> getArticleList(String code) throws Exception{
		ArrayList<Room> articleList = null;
		Connection con = getUserConnection(AllUser.users.get(code));
		RoomDAO roomDAO = RoomDAO.getInstance();
		roomDAO.setConnection(con);
		articleList = roomDAO.selectArticleList();
		close(con);
		return articleList;
	}

}
