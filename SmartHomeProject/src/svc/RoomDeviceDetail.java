package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getUserConnection;

import java.sql.Connection;

import dao.DeviceDAO;
import utils.AllUser;
import vo.Device;

public class RoomDeviceDetail {
	public Device getArticle(String model, String code) throws Exception{
		// TODO Auto-generated method stub
		
		Device article = null;
		Connection con = getUserConnection(AllUser.users.get(code));
		DeviceDAO deviceDAO =DeviceDAO.getInstance();
		deviceDAO.setConnection(con);
		
		article = deviceDAO.selectArticleRoom(model);
		close(con);
		return article;
		
	}
}
