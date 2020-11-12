package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import vo.Admin;
import static db.JdbcUtil.*;

public class DoorLockDAO {
	
	private static DoorLockDAO doorLockDAO;
	private Connection con;
	
	private DoorLockDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public static DoorLockDAO getInstance(){
		if(doorLockDAO == null){
			doorLockDAO = new DoorLockDAO();
		}
		return doorLockDAO;
	}
	
	public void setConnection(Connection con){
		this.con = con;
	}
	
	public int insertKey(String key) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int insertCount=0;
		try {
			pstmt = con.prepareStatement("insert into doorLockKey(name, kind, model, RfidKey) values('도어락','도어락','DL-01',?);");
			pstmt.setString(1, key);
			
			insertCount = pstmt.executeUpdate();
			
			
			
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
		return insertCount;
		
	}
	
}




