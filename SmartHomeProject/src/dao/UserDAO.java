package dao;

import static db.JdbcUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import vo.Admin;



public class UserDAO {
	DataSource ds;
	Connection con;
	private static UserDAO userDAO;
	
	
	private UserDAO () {
		// TODO Auto-generated constructor stub
	}

	public static UserDAO  getInstance(){
		if(userDAO == null){
			userDAO = new UserDAO();
		}
		return userDAO;
	}

	public void setConnection(Connection con){
		this.con = con;
	}
	public int selectListCount() {

		int listCount= 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try{
			pstmt=con.prepareStatement("select count(*) from user");
			rs = pstmt.executeQuery();

			if(rs.next()){
				listCount=rs.getInt(1);
			}
		}catch(Exception ex){
			System.out.println("getListCount : " + ex);			
		}finally{
			close(rs);
			close(pstmt);
		}

		return listCount;

	}
	public ArrayList<Admin> selectArticleList(int page,int limit){

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String user_list_sql="select * from user order by user_re_ref asc limit ?,10";
		ArrayList<Admin> articleList = new ArrayList<>();
		Admin user = null;
		int startrow=(page-1)*10; 	
		
		try{
			pstmt = con.prepareStatement(user_list_sql);
			pstmt.setInt(1, startrow);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				user = new Admin();
				user.setCode(rs.getString("code"));
				user.setCityId(rs.getString("city_id"));
				user.setId(rs.getString("id"));
				user.setPwd(rs.getString("password"));
				user.setZip_code(rs.getString("zip_code"));
				user.setEmail(rs.getString("email"));
				user.setName(rs.getString("name"));
				user.setPhone(rs.getString("number"));
				user.setAddr(rs.getString("address"));
				user.setAddr2(rs.getString("address2"));
				user.setIp(rs.getString("ip"));
				user.setUser_re_ref(rs.getInt("user_re_ref"));
				articleList.add(user);
			}

		}catch(Exception ex){
			System.out.println("getUserList : " + ex);
		}finally{
			close(rs);
			close(pstmt);
		}

		return articleList;

	}
	public ArrayList<Admin> selectArticleListRoom(){ //사용자의 DB

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String user_list_sql="select * from user";
		ArrayList<Admin> articleList = new ArrayList<>();
		Admin user = null;
		
		
		try{
			pstmt = con.prepareStatement(user_list_sql);
			
			rs = pstmt.executeQuery();
			while(rs.next()){
				user = new Admin();
				user.setCode(rs.getString("code"));
				user.setCityId(rs.getString("city_id"));
				user.setId(rs.getString("id"));
				user.setPwd(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				user.setName(rs.getString("name"));
				user.setPhone(rs.getString("number"));
				user.setAddr(rs.getString("address"));
				user.setAddr2(rs.getString("address2"));
				articleList.add(user);
			}

		}catch(Exception ex){
			System.out.println("getUserList : " + ex);
		}finally{
			close(rs);
			close(pstmt);
		}

		return articleList;

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
	public int insertArticleRoom(Admin article){

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql="";
		int insertCount=0;
		
		try{
			pstmt=con.prepareStatement("select*from user");
			rs = pstmt.executeQuery();

			if(rs.next()) {
				article.setCode(rs.getString("code"));
				article.setId(rs.getString("id"));
				article.setPwd(rs.getString("password"));
				article.setAddr(rs.getString("address"));
				article.setAddr2(rs.getString("address2"));
				article.setCityId(rs.getString("city_id"));
			}
			
			
			sql="insert into user(code, id, password, name, email, number, address, address2, city_id) values(?,?,?,?,?,?,?,?,?)";
			

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, article.getCode());
			pstmt.setString(2, article.getId());
			pstmt.setString(3, article.getPwd());
			pstmt.setString(4, article.getName());
			pstmt.setString(5, article.getEmail());
			pstmt.setString(6, article.getPhone());
			pstmt.setString(7, article.getAddr());
			pstmt.setString(8, article.getAddr2());
			pstmt.setString(9, article.getCityId());
			insertCount=pstmt.executeUpdate();

		}catch(Exception ex){
			System.out.println("User Up  : "+ex);
		}finally{
			close(rs);
			close(pstmt);
		}

		return insertCount;
	}

	public Admin selectArticle(String id){

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Admin user = null;
		
		try{
			pstmt = con.prepareStatement("select * from user where id = ?");
			pstmt.setString(1, id);
			rs= pstmt.executeQuery();

			if(rs.next()){
				user = new Admin();
				user.setCode(rs.getString("code"));
				user.setCityId(rs.getString("city_id"));
				user.setId(rs.getString("id"));
				user.setPwd(rs.getString("password"));
				user.setZip_code(rs.getString("zip_code"));
				user.setEmail(rs.getString("email"));
				user.setName(rs.getString("name"));
				user.setPhone(rs.getString("number"));
				user.setAddr(rs.getString("address"));
				user.setAddr2(rs.getString("address2"));
				user.setIp(rs.getString("ip"));
				user.setUser_re_ref(rs.getInt("user_re_ref"));
			}
		}catch(Exception ex){
			System.out.println("getDetail : " + ex);
		}finally{
			close(rs);
			close(pstmt);
		}

		return user;

	}
	public Admin selectArticleRoom(String name){

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Admin user = null;
		
		try{
			pstmt = con.prepareStatement("select * from user where name = ?");
			pstmt.setString(1, name);
			rs= pstmt.executeQuery();

			if(rs.next()){
				user = new Admin();
				user.setCode(rs.getString("code"));
				user.setCityId(rs.getString("city_id"));
				user.setId(rs.getString("id"));
				user.setPwd(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				user.setName(rs.getString("name"));
				user.setPhone(rs.getString("number"));
				user.setAddr(rs.getString("address"));
				user.setAddr2(rs.getString("address2"));
			}
		}catch(Exception ex){
			System.out.println("getDetail : " + ex);
		}finally{
			close(rs);
			close(pstmt);
		}

		return user;

	}
	public int updateArticle(Admin article, String id){

		int updateCount = 0;
		PreparedStatement pstmt = null;
		
		try{

			String sql="update user set code=?, city_id=?, zip_code=?, id=?, password=?, name=?, email=?, number=?, address=?, address2=?, ip=? where id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, article.getCode());
			pstmt.setString(2, article.getCityId());
			pstmt.setString(3, article.getZip_code());
			pstmt.setString(4, article.getId());
			pstmt.setString(5, article.getPwd());
			pstmt.setString(6, article.getName());
			pstmt.setString(7, article.getEmail());
			pstmt.setString(8, article.getPhone());
			pstmt.setString(9, article.getAddr());
			pstmt.setString(10, article.getAddr2());
			pstmt.setString(11, article.getIp());
			pstmt.setString(12, id);
			
			
			
			updateCount = pstmt.executeUpdate();
			
		}catch(Exception ex){
			System.out.println("UserModify  : " + ex);
		}finally{
			close(pstmt);
		}

		return updateCount;

	}
	public int updateArticleRoom(Admin article, String name){

		int updateCount = 0;
		PreparedStatement pstmt = null;
		
		try{

			String sql="update user set name=?, email=?, number=? where name=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, article.getName());
			pstmt.setString(2, article.getEmail());
			pstmt.setString(3, article.getPhone());
			pstmt.setString(4, name);
			
			updateCount = pstmt.executeUpdate();
			
		}catch(Exception ex){
			System.out.println("UserModify  : " + ex);
		}finally{
			close(pstmt);
		}

		return updateCount;

	}
	
	public int deleteArticle(String id){

		PreparedStatement pstmt = null;
		String board_delete_sql="delete from user where id=?";
		int deleteCount=0;

		try{
			pstmt=con.prepareStatement(board_delete_sql);
			pstmt.setString(1, id);
			deleteCount=pstmt.executeUpdate();
		}catch(Exception ex){
			System.out.println("UserDelete  : "+ex);
		}	finally{
			close(pstmt);
		}

		return deleteCount;

	}
	public int deleteArticleRoom(String name){

		PreparedStatement pstmt = null;
		String board_delete_sql="delete from user where name=?";
		int deleteCount=0;

		try{
			pstmt=con.prepareStatement(board_delete_sql);
			pstmt.setString(1, name);
			deleteCount=pstmt.executeUpdate();
		}catch(Exception ex){
			System.out.println("UserDelete  : "+ex);
		}	finally{
			close(pstmt);
		}

		return deleteCount;

	}
	public boolean isArticleUserWriter(String id){

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String user_sql="select * from user where id=?";
		boolean isWriter = false;
		
		try{
			pstmt=con.prepareStatement(user_sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			
			rs.next();
			
			if(id.equals(rs.getString("id"))){
				isWriter = true;
			}

			
		}catch(SQLException ex){
			System.out.println("isArticleUserWriter  : "+ex);
		}
		finally{
			close(pstmt);
		}

		return isWriter;

	}
	public boolean isArticleUserWriterRoom(String name){

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String user_sql="select * from user where name=?";
		boolean isWriter = false;
		
		try{
			pstmt=con.prepareStatement(user_sql);
			pstmt.setString(1, name);
			rs=pstmt.executeQuery();
			
			rs.next();
			
			if(name.equals(rs.getString("name"))){
				isWriter = true;
			}

			
		}catch(SQLException ex){
			System.out.println("isArticleUserWriterRoom  : "+ex);
		}
		finally{
			close(pstmt);
		}

		return isWriter;

	}
}
