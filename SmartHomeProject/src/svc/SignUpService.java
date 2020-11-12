package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;
import java.util.StringTokenizer;

import dao.SignUpDAO;
import vo.Admin;

public class SignUpService {
	public boolean registArticle(Admin admin) throws Exception{
		// TODO Auto-generated method stub
		
		boolean isWriteSuccess = false;
		
		Connection con = getConnection();
		
		SignUpDAO signUpDAO = SignUpDAO.getInstance();
		
		signUpDAO.setConnection(con);
		
		StringTokenizer tokens = new StringTokenizer(admin.getAddr());
		String cityName= tokens.nextToken(" "); //도 
		String townName= tokens.nextToken(" "); //시
		//지역번호 구하기
		String cityId=utils.EConsonantsReturn.getCityNumber(cityName);
		admin.setCityId(cityId); //지역 번호 저장
		
		String cityEnglish = utils.EConsonantsReturn.getInitEngilsh(cityName); //도 코드 구하기
		String townEnglish = utils.EConsonantsReturn.getInitEngilsh(townName); //시 코드 구하기
		
		admin.setCode(cityEnglish+townEnglish); //코드 저장
		int insertCount = signUpDAO.insertArticle(admin);
		
		if(insertCount > 0){
			isWriteSuccess = true;
		}
		else{
			rollback(con);
		}
		
		close(con);
		return isWriteSuccess;
		
	}

	public boolean selectId(String id) {
		SignUpDAO signUpDAO = SignUpDAO.getInstance();
		Connection con = getConnection();
		signUpDAO.setConnection(con);
		boolean isSelect = signUpDAO.selectLoginAdmin(id);
		
		close(con);
		return isSelect;
	}
}
