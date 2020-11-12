package dao;

import static db.JdbcUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import vo.Admin;



public class SignUpDAO {
	
	DataSource ds;
	Connection con;
	private static SignUpDAO SignUpDAO;
	
	
	private SignUpDAO () {
		// TODO Auto-generated constructor stub
	}

	public static SignUpDAO  getInstance(){
		if(SignUpDAO == null){
			SignUpDAO = new SignUpDAO();
		}
		return SignUpDAO;
	}

	public void setConnection(Connection con){
		this.con = con;
	}
	public boolean selectLoginAdmin(String id) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = con.prepareStatement("SELECT * FROM user WHERE id = ?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()){
				if(id.equals(rs.getString("id"))) { //id가 존재한다.
					return true;
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
		return false;
	}
	
	public int insertArticle(Admin article){

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql="";
		int insertCount=0;
		int tempCount=0;
		int num=0;
		try{
			pstmt=con.prepareStatement("select max(user_re_ref) from user");
			rs = pstmt.executeQuery();

			if(rs.next())
				num =rs.getInt(1)+1;
			else
				num=1;
			
			
			sql="select count(*) as cnt from user where code like ?;"; //
			pstmt =con.prepareStatement(sql);
			pstmt.setString(1, article.getCode()+"%");
			rs = pstmt.executeQuery();
			if(rs.next()){
				tempCount=rs.getInt("cnt")+1;
			}
			
			article.setCode(article.getCode()+Integer.toString(tempCount));//CHCH1 CHCH2로 저장 된다.
			
			sql="insert into user(code, city_id, zip_code,password,name, email,number,address,id,ip, address2,user_re_ref) values(?,?,?,?,?,?,?,?,?,?,?,?)";
			

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
			pstmt.setString(10, article.getIp());
			pstmt.setString(11, article.getAddr2());
			pstmt.setInt(12, num);
			insertCount=pstmt.executeUpdate();

		}catch(Exception ex){
			System.out.println("Sign Up  : "+ex);
		}finally{
			close(rs);
			close(pstmt);
		}

		return insertCount;

	}

	
}
