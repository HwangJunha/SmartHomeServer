package dao;

import static db.JdbcUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import vo.Admin;
import vo.UserDevice;

public class UserDeviceDAO {
	DataSource ds;
	Connection con;
	private static UserDeviceDAO userDeviceDAO;
	
	
	private UserDeviceDAO () {
		// TODO Auto-generated constructor stub
	}

	public static UserDeviceDAO  getInstance(){
		if(userDeviceDAO == null){
			userDeviceDAO = new UserDeviceDAO();
		}
		return userDeviceDAO;
	}

	public void setConnection(Connection con){
		this.con = con;
	}
	public int selectListCount() {

		int listCount= 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try{
			pstmt=con.prepareStatement("select count(*) from devicePossession");
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
	
	public ArrayList<UserDevice> selectArticleList(int page,int limit){

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String user_list_sql="select * from devicePossession order by devicePossession_re_ref asc limit ?,10";
		ArrayList<UserDevice> articleList = new ArrayList<>();
		UserDevice userDevice = null;
		int startrow=(page-1)*10; 	
		
		try{
			pstmt = con.prepareStatement(user_list_sql);
			pstmt.setInt(1, startrow);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				userDevice = new UserDevice();
				userDevice.setId(rs.getString("id"));
				userDevice.setName(rs.getString("name"));
				userDevice.setKind(rs.getString("kind"));
				userDevice.setModel(rs.getString("model"));
				userDevice.setPcDate(rs.getString("pcDate"));
				userDevice.setState(rs.getInt("state"));
				userDevice.setDevicePossession_re_ref(rs.getInt("devicePossession_re_ref"));
				articleList.add(userDevice);
			}

		}catch(Exception ex){
			System.out.println("getUserDeviceList : " + ex);
		}finally{
			close(rs);
			close(pstmt);
		}

		return articleList;

	}
	public ArrayList<UserDevice> selectArticleList(){

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String user_list_sql="select * from deviceList";
		ArrayList<UserDevice> articleList = new ArrayList<>();
		UserDevice userDevice = null;

		
		try{
			pstmt = con.prepareStatement(user_list_sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				userDevice = new UserDevice();
				userDevice.setName(rs.getString("name"));
				userDevice.setKind(rs.getString("kind"));
				userDevice.setModel(rs.getString("model"));
				userDevice.setRoom(rs.getString("room"));
				userDevice.setState(rs.getInt("state"));
				
				articleList.add(userDevice);
			}

		}catch(Exception ex){
			System.out.println("getUserDeviceList : " + ex);
		}finally{
			close(rs);
			close(pstmt);
		}

		return articleList;

	}
	public UserDevice selectArticle(String model){

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		UserDevice userDevice = null;
		
		try{
			pstmt = con.prepareStatement("select * from devicePossession where model = ?");
			pstmt.setString(1, model);
			rs= pstmt.executeQuery();

			if(rs.next()){
				userDevice = new UserDevice();
				userDevice.setId(rs.getString("id"));
				userDevice.setName(rs.getString("name"));
				userDevice.setKind(rs.getString("kind"));
				userDevice.setModel(rs.getString("model"));
				userDevice.setPcDate(rs.getString("pcDate"));
				userDevice.setState(rs.getInt("state"));
				userDevice.setDevicePossession_re_ref(rs.getInt("devicePossession_re_ref"));
			}
		}catch(Exception ex){
			System.out.println("getDetail : " + ex);
		}finally{
			close(rs);
			close(pstmt);
		}

		return userDevice;

	}
	public int updateArticle(UserDevice article, String model){

		int updateCount = 0;
		PreparedStatement pstmt = null;
		
		try{

			String sql="update devicePossession set id=?, name=?, kind=?, model=?, pcDate=? state=? where model=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, article.getId());
			pstmt.setString(2, article.getName());
			pstmt.setString(3, article.getKind());
			pstmt.setString(4, article.getModel());
			pstmt.setString(5, article.getPcDate());
			pstmt.setInt(6, article.getState());
			pstmt.setString(7, model);
			
			updateCount = pstmt.executeUpdate();
			
		}catch(Exception ex){
			System.out.println("UserDeviceModify  : " + ex);
		}finally{
			close(pstmt);
		}

		return updateCount;

	}
	public int deleteArticle(String model){

		PreparedStatement pstmt = null;
		String board_delete_sql="delete from devicePossession where model=?";
		int deleteCount=0;

		try{
			pstmt=con.prepareStatement(board_delete_sql);
			pstmt.setString(1, model);
			deleteCount=pstmt.executeUpdate();
		}catch(Exception ex){
			System.out.println("UserDeviceDelete  : "+ex);
		}	finally{
			close(pstmt);
		}

		return deleteCount;

	}
	public int insertArticle(UserDevice article){

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql="";
		int insertCount=0;
		int updateCount=0;
		int tempCount=0;
		int num=0;
		try{
			pstmt=con.prepareStatement("select max(devicePossession_re_ref) from devicePossession");
			rs = pstmt.executeQuery();

			if(rs.next())
				num =rs.getInt(1)+1;
			else
				num=1;
			
			if(article.getModel().equals("temp")) {
				article.setState(2); //대기중
			}else {
				article.setState(1); //설치완료
			}
			
			sql="insert into devicePossession(id,name,kind,model,pcDate,state,devicePossession_re_ref) values(?,?,?,?,?,?,?)";
			

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, article.getId());
			pstmt.setString(2, article.getName());
			pstmt.setString(3, article.getKind());
			pstmt.setString(4, article.getModel());
			pstmt.setString(5, article.getPcDate());
			pstmt.setInt(6, article.getState());
			pstmt.setInt(7, num);
			insertCount=pstmt.executeUpdate();
			
			sql="update deviceList set state=1  where model=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, article.getModel());
			updateCount=pstmt.executeUpdate();
			
		}catch(Exception ex){
			System.out.println("UserDevice Up  : "+ex);
		}finally{
			close(rs);
			close(pstmt);
		}

		return insertCount;
	}
	
	public boolean isArticleUserDeviceWriter(String model){

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String user_sql="select * from devicePossession where model=?";
		boolean isWriter = false;
		
		try{
			pstmt=con.prepareStatement(user_sql);
			pstmt.setString(1, model);
			rs=pstmt.executeQuery();
			
			rs.next();
			
			if(model.equals(rs.getString("model"))){
				isWriter = true;
			}

			
		}catch(SQLException ex){
			System.out.println("isArticleUserDeviceWriter  : "+ex);
		}
		finally{
			close(pstmt);
		}

		return isWriter;

	}
}
