package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;
import java.util.StringTokenizer;

import dao.LoginDAO;
import dao.PersonalDAO;
import vo.Admin;

public class PersonalService {
	public boolean registArticle(Admin admin) throws Exception{
		// TODO Auto-generated method stub
		
		boolean isWriteSuccess = false;
		boolean zipCodeCheck=false;
		
		Connection con = getConnection();
		
		PersonalDAO personalDAO = PersonalDAO.getInstance();
		
		
		personalDAO.setConnection(con);
		
		StringTokenizer tokens = new StringTokenizer(admin.getAddr());
		String cityName= tokens.nextToken(" "); //도 
		String townName= tokens.nextToken(" "); //시
		//지역번호 구하기
		String cityId=utils.EConsonantsReturn.getCityNumber(cityName);
		admin.setCityId(cityId); //지역 번호 저장
		
		zipCodeCheck=personalDAO.selectCheckZipCode(admin.getId(), admin.getZip_code()); // 우편번호가 바뀌었을시 code도 바뀌어야 한다.
		if(zipCodeCheck) {
		
			String cityEnglish = utils.EConsonantsReturn.getInitEngilsh(cityName); //도 코드 구하기
			String townEnglish = utils.EConsonantsReturn.getInitEngilsh(townName); //시 코드 구하기
			
			admin.setCode(cityEnglish+townEnglish); // 새로운 code
			admin.setCode(personalDAO.newZipCode(admin)); //우편번호 갱신
		}
		
		
		int insertCount = personalDAO.updateArticle(admin);
		
		if(insertCount > 0){
			isWriteSuccess = true;
		}
		else{
			rollback(con);
		}
		
		close(con);
		return isWriteSuccess;
		
	}
	public Admin getLoginPersonal(String id) { //개인정보 수정
		// TODO Auto-generated method stub
		PersonalDAO personalDAO = PersonalDAO.getInstance();
		Connection con = getConnection();
		personalDAO.setConnection(con);
		Admin loginAdmin = personalDAO.selectLoginAdmin(id);
		close(con);
		return loginAdmin;
	}
}
