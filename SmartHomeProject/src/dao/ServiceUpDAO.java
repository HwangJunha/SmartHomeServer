package dao;

import static db.JdbcUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import utils.AllUser;

public class ServiceUpDAO {
	DataSource ds;
	Connection con;
	private static ServiceUpDAO ServiceUpDAO;
	
	
	private ServiceUpDAO () {
		// TODO Auto-generated constructor stub
	}

	public static ServiceUpDAO  getInstance(){
		if(ServiceUpDAO == null){
			ServiceUpDAO = new ServiceUpDAO();
		}
		return ServiceUpDAO;
	}

	public void setConnection(Connection con){
		this.con = con;
	}
	public String selectProduct(String kind) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String model="";
		try {
			pstmt = con.prepareStatement("SELECT * FROM deviceList where state=0 and kind=?"); //재고가 있으면서 해당 물품 찾는 함수
			pstmt.setString(1, kind);
			rs = pstmt.executeQuery();
			while(rs.next()){
				model=rs.getString("model");
			}
			if(!model.equals("")) { //모델이 null이 아닐 경우
				String sql="update deviceList set state=1 where model=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, model);
				pstmt.executeUpdate();
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
		return model;
	}

	public int insertArticle(String model, String kind,String code, int state){

		PreparedStatement pstmt = null;
		ResultSet rs=null;
		String sql="";
		int insertCount=0;
		int tempCount=0;
		int num;
		
		try{	
			pstmt=con.prepareStatement("select max(devicePossession_re_ref) from devicePossession");
			rs = pstmt.executeQuery();

			if(rs.next())
				num =rs.getInt(1)+1;
			else
				num=1;
			
			sql="insert into devicePossession(id, name, kind, model, pcDate, state, devicePossession_re_ref) values(?,?,?,?,NOW(),?,?)";
		
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, AllUser.users.get(code).getId());
			pstmt.setString(2, kind);
			pstmt.setString(3, kind);
			pstmt.setString(4, model);
			pstmt.setInt(5, state);
			pstmt.setInt(6, num);

			insertCount=pstmt.executeUpdate();
		}catch(Exception ex){
			System.out.println("Service Up  : "+ex);
		}finally{
			close(pstmt);
		}

		return insertCount;

	}
}