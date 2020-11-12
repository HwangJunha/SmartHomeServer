package svc;

import static db.JdbcUtil.*;
import java.sql.Connection;
import dao.LoginDAO;
import utils.AllUser;
import vo.Admin;
public class LoginService {
	
	public Admin getLoginAdmin(String id, String passwd) { //홈페이지 로그인
		// TODO Auto-generated method stub
		LoginDAO loginDAO = LoginDAO.getInstance();
		Connection con = getConnection();
		loginDAO.setConnection(con);
		Admin loginAdmin = loginDAO.selectLoginAdmin(id,passwd);
		close(con);
		return loginAdmin;
	}
	
	public void getUserCode(String code) {
		if(AllUser.users.containsKey(code)) {	//코드가 이미 저장되어 있을 경우
			
		}else { //Allusers 코드를 등록해준다.
			LoginDAO loginDAO = LoginDAO.getInstance();
			Connection con = getConnection();
			loginDAO.setConnection(con);
			
			loginDAO.selectLoginUser(code);
			close(con);
		}
	}
}








