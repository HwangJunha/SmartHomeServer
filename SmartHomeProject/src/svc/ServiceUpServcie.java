package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import dao.ServiceUpDAO;

public class ServiceUpServcie {
	public boolean registArticle(String code, String product) throws Exception{
		// TODO Auto-generated method stub
		String model=null;
		int state=0; //설치전
		
		boolean isWriteSuccess = false;
		
		
		
		ServiceUpDAO serviceUpDAO = ServiceUpDAO.getInstance();
		
		Connection con = getConnection();
		
		serviceUpDAO.setConnection(con);
		model=serviceUpDAO.selectProduct(product);
		
		if(model.equals("")) {
			model="temp"; //재고가 없을경우
			state=2; //재고 대기중
		}
		int insertCount = serviceUpDAO.insertArticle(model,product,code,state);
		
		
		if(insertCount > 0){
			isWriteSuccess = true;
		}
		else{
			rollback(con);
		}
		
		close(con);
		return isWriteSuccess;
		
	}
}
