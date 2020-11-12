package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import utils.AllUser;
import vo.Admin;
import static db.JdbcUtil.*;

public class LoginDAO {
	
	private static LoginDAO loginDAO;
	private Connection con;
	
	private LoginDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public static LoginDAO getInstance(){
		if(loginDAO == null){
			loginDAO = new LoginDAO();
		}
		return loginDAO;
	}
	
	public void setConnection(Connection con){
		this.con = con;
	}
	
	public Admin selectLoginAdmin(String id, String passwd) {
		// TODO Auto-generated method stub
		Admin loginAdmin = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = con.prepareStatement("SELECT * FROM user WHERE id = ? AND password = ?");
			pstmt.setString(1, id);
			pstmt.setString(2, passwd);
			rs = pstmt.executeQuery();
			if(rs.next()){
				loginAdmin = new Admin();
				loginAdmin.setCode(rs.getString("code"));
				loginAdmin.setZip_code(rs.getString("zip_code"));
				loginAdmin.setName(rs.getString("name"));
				loginAdmin.setAddr(rs.getString("address"));
				loginAdmin.setCode(rs.getString("code"));
				loginAdmin.setId(rs.getString("id"));
				loginAdmin.setPwd(rs.getString("password"));
				loginAdmin.setEmail(rs.getString("email"));
				loginAdmin.setIp(rs.getString("ip"));
				loginAdmin.setCityId(rs.getString("city_id"));
				loginAdmin.setAddr2(rs.getString("address2"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally{
			try {
				close(rs);
				close(pstmt);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return loginAdmin;
	}
	public boolean selectLoginUser(String code, String passwd) {
		boolean isUser=false;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = con.prepareStatement("SELECT * FROM user WHERE code = ? AND password = ?");
			pstmt.setString(1, code);
			pstmt.setString(2, passwd);
			System.out.println("DB:"+code+"/"+passwd);
			rs = pstmt.executeQuery();
			if(rs.next()){
				isUser=true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally{
			try {
				close(rs);
				close(pstmt);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return isUser;
		
	}
	

	public void selectLoginUser(String code) {
		// TODO Auto-generated method stub
		Admin loginAdmin = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = con.prepareStatement("SELECT * FROM user WHERE code = ?");
			pstmt.setString(1, code);
			rs = pstmt.executeQuery();
			if(rs.next()){
				loginAdmin = new Admin();
				loginAdmin.setCode(rs.getString("code"));
				loginAdmin.setZip_code(rs.getString("zip_code"));
				loginAdmin.setName(rs.getString("name"));
				loginAdmin.setAddr(rs.getString("address"));
				loginAdmin.setCode(rs.getString("code"));
				loginAdmin.setId(rs.getString("id"));
				loginAdmin.setPwd(rs.getString("password"));
				loginAdmin.setEmail(rs.getString("email"));
				loginAdmin.setIp(rs.getString("ip"));
				loginAdmin.setCityId(rs.getString("city_id"));
				loginAdmin.setPhone(rs.getString("number"));
				loginAdmin.setAddr2(rs.getString("Address2"));
				System.out.println("login:"+loginAdmin.toString());
				AllUser.users.put(loginAdmin.getCode(), loginAdmin); //코드 등록
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally{
			try {
				close(rs);
				close(pstmt);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
}




