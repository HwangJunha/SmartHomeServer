package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import dao.ServiceDAO;
import vo.ServiceUp;

public class ServiceListService {
	public int getListCount() throws Exception{
		// TODO Auto-generated method stub
		
		int listCount = 0;
		Connection con = getConnection();
		ServiceDAO serviceDAO = ServiceDAO.getInstance();
		serviceDAO.setConnection(con);
		listCount = serviceDAO.selectListCount();
		close(con);
		return listCount;
		
	}

	public ArrayList<ServiceUp> getArticleList(int page, int limit) throws Exception{
		
		ArrayList<ServiceUp> articleList = null;
		Connection con = getConnection();
		ServiceDAO serviceDAO = ServiceDAO.getInstance();
		serviceDAO.setConnection(con);
		articleList = serviceDAO.selectArticleList(page,limit);
		close(con);
		return articleList;
		
	}
}
