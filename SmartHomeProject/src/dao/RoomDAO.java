package dao;

import static db.JdbcUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import vo.Admin;
import vo.Room;

public class RoomDAO {

	DataSource ds;
	Connection con;
	private static RoomDAO RoomDAO;
	
	
	private RoomDAO () {
		// TODO Auto-generated constructor stub
	}

	public static RoomDAO  getInstance(){
		if(RoomDAO == null){
			RoomDAO = new RoomDAO();
		}
		return RoomDAO;
	}

	public void setConnection(Connection con){
		this.con = con;
	}
	
	public ArrayList<Room> selectArticleList(){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String room_sql="select * from room";
		ArrayList<Room> articleList = new ArrayList<Room>();
		Room room = null;

		try{
			pstmt = con.prepareStatement(room_sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				room = new Room();
				room.setKind(rs.getString("kind"));
				room.setRoom(rs.getString("room"));
				room.setRoomName(rs.getString("name"));
				room.setSize(rs.getInt("size"));
				articleList.add(room);
			}

		}catch(Exception ex){
			System.out.println("getRoomList : " + ex);
		}finally{
			close(rs);
			close(pstmt);
		}
		return articleList;
	}
	public Room selectArticle(String name){

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Room room = null;
		
		try{
			pstmt = con.prepareStatement("select * from room where name = ?");
			pstmt.setString(1, name);
			rs= pstmt.executeQuery();

			if(rs.next()){
				room = new Room();
				room.setKind(rs.getString("kind"));
				room.setRoom(rs.getString("room"));
				room.setRoomName(rs.getString("name"));
				room.setSize(rs.getInt("size"));
			}
		}catch(Exception ex){
			System.out.println("getDetail : " + ex);
		}finally{
			close(rs);
			close(pstmt);
		}

		return room;

	}
	public int insertArticle(Room article){

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql="";
		String zipCode=null;
		String address=null;
		
		int insertCount=0;
		
		int num=0;
		try{
			pstmt=con.prepareStatement("select count(*) as num from room");
			rs = pstmt.executeQuery();

			if(rs.next())
				num =rs.getInt(1)+1;
			else
				num=1;
			
			pstmt=con.prepareStatement("select*from room");
			rs = pstmt.executeQuery();
				
			
			sql="insert into room(room, size, kind, name) values(?,?,?,?)";
			

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "room"+num);
			pstmt.setInt(2, article.getSize());
			pstmt.setString(3, article.getKind());
			pstmt.setString(4, article.getRoomName());
			insertCount=pstmt.executeUpdate();

		}catch(Exception ex){
			System.out.println("Room Write  : "+ex);
		}finally{
			close(rs);
			close(pstmt);
		}

		return insertCount;
	}
	
	public int updateArticle(Room article, String name){

		int updateCount = 0;
		PreparedStatement pstmt = null;
		
		try{

			String sql="update room set size=?, kind=?, name=? where name=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, article.getSize());
			pstmt.setString(2, article.getKind());
			pstmt.setString(3, article.getRoomName());
			pstmt.setString(4, name);
			
			
			
			updateCount = pstmt.executeUpdate();
			
		}catch(Exception ex){
			System.out.println("RoomModify  : " + ex);
		}finally{
			close(pstmt);
		}

		return updateCount;

	}
	public int deleteArticleRoom(String name){

		PreparedStatement pstmt = null;
		String board_delete_sql="delete from room where name=?";
		int deleteCount=0;

		try{
			pstmt=con.prepareStatement(board_delete_sql);
			pstmt.setString(1, name);
			deleteCount=pstmt.executeUpdate();
		}catch(Exception ex){
			System.out.println("RoomDelete  : "+ex);
		}	finally{
			close(pstmt);
		}

		return deleteCount;

	}
	
	public boolean isArticleRoomWriter(String name){

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String room_sql="select * from room where name=?";
		boolean isWriter = false;
		
		try{
			pstmt=con.prepareStatement(room_sql);
			pstmt.setString(1, name);
			rs=pstmt.executeQuery();
			
			rs.next();
			
			if(name.equals(rs.getString("name"))){
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
}
