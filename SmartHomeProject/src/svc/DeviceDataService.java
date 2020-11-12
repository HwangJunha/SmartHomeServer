package svc;
import static db.JdbcUtil.*;
import java.sql.Connection;
import java.util.ArrayList;
import dao.DeviceDataDAO;
import utils.AllUser;
import vo.DeviceData;

public class DeviceDataService {

	public ArrayList<DeviceData> getArticleList(String room, String code) throws Exception{ //방이름에 따 모든 데이터 불러오기 
		ArrayList<DeviceData> articleList = null;
		Connection con = getUserConnection(AllUser.users.get(code));
		DeviceDataDAO deviceDataDAO = DeviceDataDAO.getInstance();
		deviceDataDAO.setConnection(con);
		articleList = deviceDataDAO.selectArticleList(room);
		close(con);
		return articleList;
	}
	public DeviceData getLatestData(String room, String code) throws Exception{
		DeviceData article = null;
		Connection con = getUserConnection(AllUser.users.get(code));
		DeviceDataDAO deviceDataDAO = DeviceDataDAO.getInstance();
		deviceDataDAO.setConnection(con);
		article = deviceDataDAO.LatestData(room);
		close(con);
		return article;
	}
}
