package dao;


import static db.JdbcUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import vo.Device;


public class DeviceDAO {

	DataSource ds;
	Connection con;
	private static DeviceDAO DeviceDAO;
	
	
	private DeviceDAO () {
		// TODO Auto-generated constructor stub
	}

	public static DeviceDAO  getInstance(){
		if(DeviceDAO == null){
			DeviceDAO = new DeviceDAO();
		}
		return DeviceDAO;
	}

	public void setConnection(Connection con){
		this.con = con;
	}
	public int selectListCount() {

		int listCount= 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try{
			pstmt=con.prepareStatement("select count(*) from deviceList");
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
	public Device selectArticle(String model){

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Device device = null;
		
		try{
			pstmt = con.prepareStatement("select * from deviceList where model = ?");
			pstmt.setString(1, model);
			rs= pstmt.executeQuery();

			if(rs.next()){
				device = new Device();
				device.setName(rs.getString("name"));
				device.setDeviceKind(rs.getString("kind"));
				device.setModel(rs.getString("model"));
				device.setState(rs.getInt("state"));
				device.setDevice_re_ref(rs.getInt("device_re_ref"));
			}
		}catch(Exception ex){
			System.out.println("getDetail : " + ex);
		}finally{
			close(rs);
			close(pstmt);
		}

		return device;

	}
	public Device selectArticleRoom(String model){

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Device device = null;
		
		try{
			pstmt = con.prepareStatement("select * from deviceList where model = ?");
			pstmt.setString(1, model);
			rs= pstmt.executeQuery();

			if(rs.next()){
				device = new Device();
				device.setName(rs.getString("name"));
				device.setDeviceKind(rs.getString("kind"));
				device.setModel(rs.getString("model"));
				device.setState(rs.getInt("state"));
				device.setRoomName(rs.getString("RoomName"));
			}
		}catch(Exception ex){
			System.out.println("getDetail : " + ex);
		}finally{
			close(rs);
			close(pstmt);
		}

		return device;

	}
	
	public ArrayList<Device> selectArticleList(int page,int limit){

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String device_list_sql="select * from deviceList order by device_re_ref asc limit ?,10";
		ArrayList<Device> articleList = new ArrayList<>();
		Device device = null;
		int startrow=(page-1)*10; 	
		
		try{
			pstmt = con.prepareStatement(device_list_sql);
			pstmt.setInt(1, startrow);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				device = new Device();
				device.setName(rs.getString("name"));
				device.setDeviceKind(rs.getString("kind"));
				device.setModel(rs.getString("model"));
				device.setState(rs.getInt("state"));
				device.setDevice_re_ref(rs.getInt("device_re_ref"));
				articleList.add(device);
			}

		}catch(Exception ex){
			System.out.println("getDeviceList : " + ex);
		}finally{
			close(rs);
			close(pstmt);
		}

		return articleList;

	}
	
	
	public int insertArticle(Device article){

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql="";
		int insertCount=0;
		int tempCount=0;
		int num=0;
		try{
			pstmt=con.prepareStatement("select max(device_re_ref) from deviceList where device_re_ref<10000");
			rs = pstmt.executeQuery();

			if(rs.next())
				num =rs.getInt(1)+1;
			else
				num=1;
			
			//장비상태는 새로 등록하기 때문에 항상 0이다.
			sql="insert into deviceList(name, kind, model, state, device_re_ref) values(?,?,?,0,?)";
			

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, article.getName());
			pstmt.setString(2, article.getDeviceKind());
			pstmt.setString(3, article.getModel());
			pstmt.setInt(4, num);
			insertCount=pstmt.executeUpdate();

		}catch(Exception ex){
			System.out.println("Device up  : "+ex);
		}finally{
			close(rs);
			close(pstmt);
		}

		return insertCount;
	}
	public int insertArticleRoom(Device article){

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql="";
		int insertCount=0;
		String room="";
		int num=0;
		try{
			pstmt=con.prepareStatement("select* from room where name=?"); //room의 room 고유번호를 불러와야함
			pstmt.setString(1, article.getRoomName());
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				room=rs.getString("room");
			}
				
			else {
				return 0;
			}
			//장비상태는 새로 등록하기 때문에 항상 0이다.
			sql="insert into deviceList(name, kind, model, room, state, RoomName) values(?,?,?,?,0,?)";
			

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, article.getName());
			pstmt.setString(2, article.getDeviceKind());
			pstmt.setString(3, article.getModel());
			pstmt.setString(4, room);
			pstmt.setString(5, article.getRoomName());
			
			insertCount=pstmt.executeUpdate();

		}catch(Exception ex){
			System.out.println("Device up  : "+ex);
		}finally{
			close(rs);
			close(pstmt);
		}

		return insertCount;
	}
	
	
	public ArrayList<Device> selectArticleList(){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String room_sql="select * from deviceList";
		ArrayList<Device> articleList = new ArrayList<>();
		Device device = null;

		try{
			pstmt = con.prepareStatement(room_sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				device = new Device();
				device.setRoomName(rs.getString("RoomName"));
				device.setName(rs.getString("name"));
				device.setDeviceKind(rs.getString("kind"));
				device.setRoom(rs.getString("room"));
				device.setModel(rs.getString("model"));
				device.setState(rs.getInt("state"));
				articleList.add(device);
			}

		}catch(Exception ex){
			System.out.println("getDeviceList : " + ex);
		}finally{
			close(rs);
			close(pstmt);
		}
		return articleList;
	}
	
	public int updateArticle(Device article, String model){

		int updateCount = 0;
		PreparedStatement pstmt = null;
		
		try{

			String sql="update deviceList set name=?, kind=?, model=? where model=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, article.getName());
			pstmt.setString(2, article.getDeviceKind());
			pstmt.setString(3, article.getModel());
			pstmt.setString(4, article.getModel());

			updateCount = pstmt.executeUpdate();
			
		}catch(Exception ex){
			System.out.println("DeviceModify  : " + ex);
		}finally{
			close(pstmt);
		}

		return updateCount;

	}
	public int updateArticleRoom(Device article, String model){

		int updateCount = 0;
		PreparedStatement pstmt = null;
		
		try{

			String sql="update deviceList set RoomName=?, name=?, kind=?, model=? where model=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, article.getRoomName());
			pstmt.setString(2, article.getName());
			pstmt.setString(3, article.getDeviceKind());
			pstmt.setString(4, article.getModel());
			pstmt.setString(5, article.getModel());

			updateCount = pstmt.executeUpdate();
			
		}catch(Exception ex){
			System.out.println("DeviceModify  : " + ex);
		}finally{
			close(pstmt);
		}

		return updateCount;

	}

	public int deleteArticle(String model){

		PreparedStatement pstmt = null;
		String board_delete_sql="delete from deviceList where model=?";
		int deleteCount=0;

		try{
			pstmt=con.prepareStatement(board_delete_sql);
			pstmt.setString(1, model);
			deleteCount=pstmt.executeUpdate();
		}catch(Exception ex){
			System.out.println("DeviceDelete  : "+ex);
		}	finally{
			close(pstmt);
		}

		return deleteCount;

	}
	public int deleteArticleRoom(String model){

		PreparedStatement pstmt = null;
		String board_delete_sql="delete from deviceList where model=?";
		int deleteCount=0;

		try{
			pstmt=con.prepareStatement(board_delete_sql);
			pstmt.setString(1, model);
			deleteCount=pstmt.executeUpdate();
		}catch(Exception ex){
			System.out.println("DeviceDelete  : "+ex);
		}	finally{
			close(pstmt);
		}

		return deleteCount;

	}
	
	public boolean isArticleDeviceWriter(String model){

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String device_sql="select * from deviceList where model=?";
		boolean isWriter = false;
		
		try{
			pstmt=con.prepareStatement(device_sql);
			pstmt.setString(1, model);
			rs=pstmt.executeQuery();
			
			rs.next();
			
			if(model.equals(rs.getString("model"))){
				isWriter = true;
			}

			
		}catch(SQLException ex){
			System.out.println("isArticleDeviceWriter  : "+ex);
		}
		finally{
			close(pstmt);
		}

		return isWriter;

	}
}
