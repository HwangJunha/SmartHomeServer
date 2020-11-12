package dao;

import static db.JdbcUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import vo.ServiceUp;


public class ServiceDAO {
	DataSource ds;
	Connection con;
	private static ServiceDAO serviceDAO;
	
	
	private ServiceDAO () {
		// TODO Auto-generated constructor stub
	}

	public static ServiceDAO  getInstance(){
		if(serviceDAO == null){
			serviceDAO = new ServiceDAO();
		}
		return serviceDAO;
	}

	public void setConnection(Connection con){
		this.con = con;
	}
	public int selectListCount() {

		int listCount= 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try{
			pstmt=con.prepareStatement("select count(*) from devicePossession as dp join user on user.id=dp.id");
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
	public ArrayList<ServiceUp> selectArticleList(int page,int limit){

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String service_list_sql="select *from devicePossession as dp join user on user.id=dp.id order by dp.devicePossession_re_ref asc limit ?,10";
		ArrayList<ServiceUp> articleList = new ArrayList<>();
		ServiceUp service = null;
		int startrow=(page-1)*10; 	
		
		try{
			pstmt = con.prepareStatement(service_list_sql);
			pstmt.setInt(1, startrow);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				service = new ServiceUp();
				service.setCode(rs.getString("user.code"));
				service.setIp(rs.getString("user.ip"));
				service.setName(rs.getString("dp.name"));
				service.setId(rs.getString("dp.id"));
				service.setKind(rs.getString("dp.kind"));
				service.setModel(rs.getString("dp.model"));
				service.setPcDate(rs.getString("dp.pcDate"));
				service.setState(rs.getInt("dp.state"));
				service.setDevicePossession_re_ref(rs.getInt("dp.devicePossession_re_ref"));
				articleList.add(service);
			}

		}catch(Exception ex){
			System.out.println("getServiceList : " + ex);
		}finally{
			close(rs);
			close(pstmt);
		}

		return articleList;

	}
	public ServiceUp selectArticle(String model){

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ServiceUp service = null;
		
		try{
			pstmt = con.prepareStatement("select *from devicePossession as dp join user on user.id=dp.id where model=?");
			pstmt.setString(1, model);
			rs= pstmt.executeQuery();

			if(rs.next()){
				service = new ServiceUp();
				service.setCode(rs.getString("user.code"));
				service.setIp(rs.getString("user.ip"));
				service.setName(rs.getString("dp.name"));
				service.setId(rs.getString("dp.id"));
				service.setKind(rs.getString("dp.kind"));
				service.setModel(rs.getString("dp.model"));
				service.setPcDate(rs.getString("dp.pcDate"));
				service.setState(rs.getInt("dp.state"));
				service.setDevicePossession_re_ref(rs.getInt("dp.devicePossession_re_ref"));
			}
		}catch(Exception ex){
			System.out.println("getDetail : " + ex);
		}finally{
			close(rs);
			close(pstmt);
		}

		return service;

	}
	public int insertArticle(String id,String ip){

		PreparedStatement pstmt = null;
		String board_delete_sql="update user set ip=? where id=?";
		int deleteCount=0;

		try{
			pstmt=con.prepareStatement(board_delete_sql);
			pstmt.setString(1, ip);
			pstmt.setString(1, id);
			deleteCount=pstmt.executeUpdate();
		}catch(Exception ex){
			System.out.println("ipInsert  : "+ex);
		}	finally{
			close(pstmt);
		}

		return deleteCount;

	}
	
	public boolean isArticleServiceWriter(String id){

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String service_sql="select *from devicePossession as dp join user on user.id=dp.id where dp.id=?";
		boolean isWriter = false;
		
		try{
			pstmt=con.prepareStatement(service_sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			
			rs.next();
			
			if(id.equals(rs.getString("id"))){
				isWriter = true;
			}

			
		}catch(SQLException ex){
			System.out.println("isArticleServiceWriter  : "+ex);
		}
		finally{
			close(pstmt);
		}

		return isWriter;

	}
	public String isDeviceArticle(String kind) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String model="";
		try{
			pstmt = con.prepareStatement("select *from deviceList where kind=? and state=0"); //재고있는 물품 검색
			pstmt.setString(1, kind);
			rs= pstmt.executeQuery();
			
			
			if(rs.next()){
				model=rs.getString("model");
			}
			
			
		}catch(Exception ex){
			System.out.println("getDetail : " + ex);
		}finally{
			close(rs);
			close(pstmt);
		}

		return model;
	}
	
	public int DeviceListArticle(String model, int state) {
		PreparedStatement pstmt = null;
		String board_delete_sql="update deviceList set state=? where model=?";
		int DeviceCount=0;

		try{
			pstmt=con.prepareStatement(board_delete_sql);
			pstmt.setInt(1, state);
			pstmt.setString(2, model);
			DeviceCount=pstmt.executeUpdate();
		}catch(Exception ex){
			System.out.println("DeviceInsert  : "+ex);
		}	finally{
			close(pstmt);
		}

		return DeviceCount;
	}
	public int DevicePossessionArticle(String model, int state) {
		PreparedStatement pstmt = null;
		String board_delete_sql="update devicePossession set state=? where model=?";
		int DeviceCount=0;

		try{
			pstmt=con.prepareStatement(board_delete_sql);
			pstmt.setInt(1, state);
			pstmt.setString(2, model);
			DeviceCount=pstmt.executeUpdate();
		}catch(Exception ex){
			System.out.println("UserDeviceInsert  : "+ex);
		}	finally{
			close(pstmt);
		}

		return DeviceCount;
	}
}
