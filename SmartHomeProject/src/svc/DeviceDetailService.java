package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;

import dao.DeviceDAO;
import vo.Device;

public class DeviceDetailService {
	public Device getArticle(String model) throws Exception{
		// TODO Auto-generated method stub
		
		Device article = null;
		Connection con = getConnection();
		DeviceDAO deviceDAO = DeviceDAO.getInstance();
		deviceDAO.setConnection(con);
		
		
		article = deviceDAO.selectArticle(model);
		close(con);
		return article;
		
	}
}
