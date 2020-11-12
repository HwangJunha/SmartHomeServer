package dao;

import static db.JdbcUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import vo.Admin;

public class PersonalDAO {
	DataSource ds;
	Connection con;
	private static PersonalDAO PersonalDAO;
	
	
	private PersonalDAO () {
		// TODO Auto-generated constructor stub
	}

	public static PersonalDAO  getInstance(){
		if(PersonalDAO == null){
			PersonalDAO = new PersonalDAO();
		}
		return PersonalDAO;
	}

	public void setConnection(Connection con){
		this.con = con;
	}
	public boolean selectCheckZipCode(String id, String zipCode) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = con.prepareStatement("SELECT * FROM user WHERE id = ?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()){
				if(zipCode.equals(rs.getString("zip_code"))) { //zipCode가 똑같다면 code을 갱신할 필요는 없다.
					return false;
				}
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
		return true;
	}
	public String newZipCode(Admin article){

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String newZipCode=null;
		String sql="";
		int tempCount=0;
		try{
			
			sql="select count(*) as cnt from user where code like ?;"; //
			
			pstmt =con.prepareStatement(sql);
			pstmt.setString(1, article.getCode()+"%");
			rs = pstmt.executeQuery();
			if(rs.next()){
				tempCount=rs.getInt("cnt")+1;
			}
			
			newZipCode=article.getCode()+Integer.toString(tempCount);//CHCH1 CHCH2로 저장 된다.
			
			
		}catch(Exception ex){
			System.out.println("Personal  : "+ex);
		}finally{
			close(rs);
			close(pstmt);
		}

		return newZipCode;

	}
	
	public Admin selectLoginAdmin(String id) {
		// TODO Auto-generated method stub
		Admin loginAdmin = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = con.prepareStatement("SELECT * FROM user WHERE id = ?");
			pstmt.setString(1, id);
			
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
				loginAdmin.setPhone(rs.getString("number"));
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
	
	public int updateArticle(Admin article){

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql="";
		int insertCount=0;
		System.out.println("updateMember:"+article.toString());
		
		try{
			if(article.getPwd().equals("")) { //패스워드가 비워졌을시
				sql="update user set code=?, city_id=?, zip_code=? ,name=?, email=?, number=?,address=?,id=?, address2=? where code=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, article.getCode());
				pstmt.setString(2, article.getCityId());
				pstmt.setString(3, article.getZip_code());
				pstmt.setString(4, article.getName());
				pstmt.setString(5, article.getEmail());
				pstmt.setString(6, article.getPhone());
				pstmt.setString(7, article.getAddr());
				pstmt.setString(8, article.getId());
				pstmt.setString(9, article.getAddr2());
				pstmt.setString(10, article.getCode());
			}else { //패스워드가 갱신했을시
				sql="update user set code=?, city_id=?, zip_code=? ,password=?,name=?, email=?, number=?,address=?,id=?, address2=? where code=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, article.getCode());
				pstmt.setString(2, article.getCityId());
				pstmt.setString(3, article.getZip_code());
				pstmt.setString(4, article.getPwd());
				pstmt.setString(5, article.getName());
				pstmt.setString(6, article.getEmail());
				pstmt.setString(7, article.getPhone());
				pstmt.setString(8, article.getAddr());
				pstmt.setString(9, article.getId());
				pstmt.setString(10, article.getAddr2());
				pstmt.setString(11, article.getCode());
			}

			
			insertCount=pstmt.executeUpdate();

		}catch(Exception ex){
			System.out.println("Personal  : "+ex);
		}finally{
			close(pstmt);
		}

		return insertCount;

	}
	
}
