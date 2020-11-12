package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.getUserConnection;

import java.sql.Connection;
import java.util.ArrayList;

import dao.DeviceDAO;

import utils.AllUser;

import vo.Device;

public class DeviceListService {
	
	public int getListCount() throws Exception{
		// TODO Auto-generated method stub
		
		int listCount = 0;
		Connection con = getConnection();
		DeviceDAO deviceDAO = DeviceDAO.getInstance();
		deviceDAO.setConnection(con);
		listCount = deviceDAO.selectListCount();
		close(con);
		return listCount;
		
	}
	//웹 관리자
	public ArrayList<Device> getArticleList(int page, int limit) throws Exception{
		
		ArrayList<Device> articleList = null;
		Connection con = getConnection();
		DeviceDAO deviceDAO = DeviceDAO.getInstance();
		deviceDAO.setConnection(con);
		articleList = deviceDAO.selectArticleList(page,limit);
		close(con);
		return articleList;
		
	}
	
	//웹 사용자
	public ArrayList<Device> getArticleList(String code) throws Exception{
		
		ArrayList<Device> articleList = null;
		Connection con = getUserConnection(AllUser.users.get(code));
		DeviceDAO deviceDAO = DeviceDAO.getInstance();
		deviceDAO.setConnection(con);
		articleList = deviceDAO.selectArticleList();
		close(con);
		return articleList;
	}
	
}
