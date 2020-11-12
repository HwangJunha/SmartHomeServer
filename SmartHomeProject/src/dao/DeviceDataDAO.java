package dao;

import static db.JdbcUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.sql.DataSource;

import vo.DeviceData;

public class DeviceDataDAO {
	DataSource ds;
	Connection con;
	private static DeviceDataDAO DeviceDataDAO;
	
	
	private DeviceDataDAO () {
		// TODO Auto-generated constructor stub
	}

	public static DeviceDataDAO  getInstance(){
		if(DeviceDataDAO == null){
			DeviceDataDAO = new DeviceDataDAO();
		}
		return DeviceDataDAO;
	}

	public void setConnection(Connection con){
		this.con = con;
	}
	
	public ArrayList<DeviceData> selectArticleList(String room){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String room_sql="select * from deviceData where room=?";
		ArrayList<DeviceData> articleList = new ArrayList<>();
		DeviceData deviceData = null;

		try{
			
			pstmt = con.prepareStatement(room_sql);
			pstmt.setString(1, room);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				deviceData = new DeviceData();
				deviceData.setRoom(rs.getString("room"));
				deviceData.setTimeHMS(Integer.toString(rs.getInt("time_hms")));
				deviceData.setTimeYMD(Integer.toString(rs.getInt("time_ymd")));
				deviceData.setDust(rs.getInt("dust"));
				deviceData.setTemperature(rs.getInt("temperature"));
				deviceData.setHumidity(rs.getInt("humidity"));
				articleList.add(deviceData);
			}

		}catch(Exception ex){
			System.out.println("getDeviceDataList : " + ex);
		}finally{
			close(rs);
			close(pstmt);
		}
		return articleList;
	}

	public DeviceData LatestData(String room) { //최신의 데이터 
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String room_sql="select*from deviceData where number=(select MAX(number) from deviceData where room=? group by room);";
		
		DeviceData deviceData = null;
		
		try{
			pstmt = con.prepareStatement(room_sql);
			pstmt.setString(1, room);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				deviceData = new DeviceData();
				deviceData.setRoom(rs.getString("room"));
				deviceData.setNumber(Integer.parseInt(rs.getString("number")));
				deviceData.setTimeHMS(rs.getString("time_hms"));
				deviceData.setTimeYMD(rs.getString("time_ymd"));
				deviceData.setRegday(rs.getString("regday"));
				deviceData.setDust(rs.getInt("dust"));
				deviceData.setTemperature(rs.getInt("temperature"));
				deviceData.setHumidity(rs.getInt("humidity"));
				
			}

		}catch(Exception ex){
			System.out.println("getDeviceDataList : " + ex);
		}finally{
			close(rs);
			close(pstmt);
		}
		
		return deviceData;
	}
}
