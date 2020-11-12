package dao;

import static db.JdbcUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import utils.AllUser;
import vo.Admin;

public class UtilsDAO {
	private static UtilsDAO UtilsDAO;
	private Connection con;
	
	private UtilsDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public static UtilsDAO getInstance(){
		if(UtilsDAO == null){
			UtilsDAO = new UtilsDAO();
		}
		return UtilsDAO;
	}
	
	public void setConnection(Connection con){
		this.con = con;
	}
	
	public void selectUser(String code) {
		// TODO Auto-generated method stub
		Admin loginAdmin = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = con.prepareStatement("SELECT * FROM user where code=?");
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
				AllUser.users.put(loginAdmin.getCode(), loginAdmin);
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
