package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;

import dao.ServiceDAO;
import vo.ServiceUp;

public class ServiceDetailService {
	public ServiceUp getArticle(String model) throws Exception{
		// TODO Auto-generated method stub
		
		ServiceUp article = null;
		Connection con = getConnection();
		ServiceDAO serviceDAO = ServiceDAO.getInstance();
		serviceDAO.setConnection(con);
		
		
		article = serviceDAO.selectArticle(model);
		close(con);
		return article;
		
	}
}
