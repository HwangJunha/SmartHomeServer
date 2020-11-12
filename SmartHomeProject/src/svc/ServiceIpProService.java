package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import dao.ServiceDAO;

public class ServiceIpProService {
	public boolean isArticleWriter(String id) throws Exception {
		// TODO Auto-generated method stub
		
		boolean isArticleWriter = false;
		Connection con = getConnection();
		ServiceDAO serviceDAO =ServiceDAO.getInstance();
		serviceDAO.setConnection(con);
		isArticleWriter = serviceDAO.isArticleServiceWriter(id);
		
		close(con);
		return isArticleWriter;
		
	}

	public boolean insertArticle(String id,String ip) throws Exception{
		// TODO Auto-generated method stub
		
		boolean isRemoveSuccess = false;
		
		Connection con = getConnection();
		ServiceDAO serviceDAO = ServiceDAO.getInstance();
		
		serviceDAO.setConnection(con);
		int ipCount = serviceDAO.insertArticle(id,ip);
		
		if(ipCount > 0){
			isRemoveSuccess=true;
		}
		else{
			rollback(con);
		}
		
		close(con);
		return isRemoveSuccess;
	}
}
