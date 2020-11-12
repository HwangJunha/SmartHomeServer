package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;

import dao.LoginDAO;

public class LoginCodeService {
	public boolean getLoginAdmin(String code, String passwd) { //어플리케이션 로그인
		// TODO Auto-generated method stub
		boolean loginSuccess=false;
		LoginDAO loginDAO = LoginDAO.getInstance();
		Connection con = getConnection();
		loginDAO.setConnection(con);
		loginSuccess = loginDAO.selectLoginUser(code,passwd);
		
		close(con);
		return loginSuccess;
	}
}
