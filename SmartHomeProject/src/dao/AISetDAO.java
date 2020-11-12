package dao;

import static db.JdbcUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.sql.DataSource;

import vo.AISet;
import vo.Device;

public class AISetDAO {
	DataSource ds;
	Connection con;
	private static AISetDAO aiSetDAO;
	
	
	private AISetDAO () {
		// TODO Auto-generated constructor stub
	}

	public static AISetDAO  getInstance(){
		if(aiSetDAO == null){
			aiSetDAO = new AISetDAO();
		}
		return aiSetDAO;
	}

	public void setConnection(Connection con){
		this.con = con;
	}
	public ArrayList<AISet> selectArticleList(){

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<AISet> articleList = new ArrayList<>();
	
		String sql="select*from defaultRole";
		try{
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				AISet aiSet = new AISet();
				aiSet.setRoom(rs.getString("room"));
				aiSet.setModel(rs.getString("model"));
				aiSet.setTemperature(String.valueOf(rs.getInt("temperature")));
				aiSet.setTemperatureRule(rs.getString("temperature_rule"));
				aiSet.setDust(String.valueOf(rs.getInt("dust")));
				aiSet.setDustRule(rs.getString("dust_rule"));
				aiSet.setHumidity(String.valueOf(rs.getInt("humidity")));
				aiSet.setHumidityRule(rs.getString("humidity_rule"));
				aiSet.setOnoff(rs.getString("onoff"));
				aiSet.setDay(rs.getString("day"));
				aiSet.setTime(rs.getString("time"));
				aiSet.setInterval(String.valueOf(rs.getInt("aiInterval")));
				aiSet.setExecutionm(String.valueOf(rs.getInt("execution")));
				articleList.add(aiSet);
			}

		}catch(Exception ex){
			System.out.println("getAiList : " + ex);
		}finally{
			close(rs);
			close(pstmt);
		}

		return articleList;

	}
	
	public int insertArticle(AISet article){

		PreparedStatement pstmt = null;
		String sql="";
		int insertCount=0;
		
		try{
			
			//장비상태는 새로 등록하기 때문에 항상 0이다.
			sql="insert into defaultRole(room, model, temperature, temperature_rule, dust, dust_rule, humidity, humidity_rule, onoff, day, time, aiInterval ,execution) ";
			sql+="values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, article.getRoom());
			pstmt.setString(2, article.getModel());
			pstmt.setInt(3, Integer.parseInt(article.getTemperature()));
			pstmt.setString(4, article.getTemperatureRule());
			pstmt.setInt(5, Integer.parseInt(article.getDust()));
			pstmt.setString(6, article.getDustRule());
			pstmt.setInt(7, Integer.parseInt(article.getHumidity()));
			pstmt.setString(8, article.getHumidityRule());
			pstmt.setString(9, article.getOnoff());
			pstmt.setString(10, article.getDay());
			if(article.getTime()==null || article.getTime().equals("")||article.getTime().equals("null")) { //타임이 없을경우
				pstmt.setString(11, "none");
				if(article.getInterval().equals("항상")) {
					pstmt.setInt(12, -1);
				}else {
					pstmt.setInt(12, Integer.parseInt(article.getInterval()));
				}
				
			}else{
				pstmt.setString(11, article.getTime());
				pstmt.setInt(12,0); //특정 시간에만 울리기 때문에 0을 저장
			}
			pstmt.setInt(13, 1);
			insertCount=pstmt.executeUpdate();
			
		}catch(Exception ex){
			System.out.println("AiSet up  : "+ex);
		}finally{
			close(pstmt);
		}

		return insertCount;
	}
	public int deleteArticle(AISet article){

		PreparedStatement pstmt = null;
		String sql="";
		sql="delete from defaultRole where room=? and model=? and temperature=? and temperature_rule=? and dust=? and dust_rule=? and humidity=? and humidity_rule=? and onoff=? and day=? and time=? and aiInterval=?";
		int deleteCount=0;

		try{
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, article.getRoom());
			pstmt.setString(2, article.getModel());
			pstmt.setInt(3, Integer.parseInt(article.getTemperature()));
			pstmt.setString(4, article.getTemperatureRule());
			pstmt.setInt(5, Integer.parseInt(article.getDust()));
			pstmt.setString(6, article.getDustRule());
			pstmt.setInt(7, Integer.parseInt(article.getHumidity()));
			pstmt.setString(8, article.getHumidityRule());
			pstmt.setString(9, article.getOnoff());
			pstmt.setString(10, article.getDay());
			pstmt.setString(11, article.getTime());
			pstmt.setInt(12,0); //특정 시간에만 울리기 때문에 0을 저장
			deleteCount=pstmt.executeUpdate();
		}catch(Exception ex){
			System.out.println("AiDelete  : "+ex);
		}	finally{
			close(pstmt);
		}

		return deleteCount;

	}
	public int updateArticle(AISet article){

		PreparedStatement pstmt = null;
		String sql="";
		sql="update defaultRole set execution=? where room=? and model=? and temperature=? and temperature_rule=? and dust=? and dust_rule=? and humidity=? and humidity_rule=? and onoff=? and day=? and time=? and aiInterval=?";
		int deleteCount=0;

		try{
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, article.getExecution());
			pstmt.setString(2, article.getRoom());
			pstmt.setString(3, article.getModel());
			pstmt.setInt(4, Integer.parseInt(article.getTemperature()));
			pstmt.setString(5, article.getTemperatureRule());
			pstmt.setInt(6, Integer.parseInt(article.getDust()));
			pstmt.setString(7, article.getDustRule());
			pstmt.setInt(8, Integer.parseInt(article.getHumidity()));
			pstmt.setString(9, article.getHumidityRule());
			pstmt.setString(10, article.getOnoff());
			pstmt.setString(11, article.getDay());
			pstmt.setString(12, article.getTime());
			pstmt.setInt(13,0); //특정 시간에만 울리기 때문에 0을 저장
			deleteCount=pstmt.executeUpdate();
		}catch(Exception ex){
			System.out.println("AiDelete  : "+ex);
		}	finally{
			close(pstmt);
		}

		return deleteCount;

	}
}
