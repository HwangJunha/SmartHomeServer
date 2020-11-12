package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getUserConnection;

import java.sql.Connection;
import java.util.ArrayList;

import dao.AISetDAO;
import utils.AllUser;
import vo.AISet;

public class AILoadService {
	public ArrayList<AISet> getArticleList(String code) throws Exception{
		// TODO Auto-generated method stub
		ArrayList<AISet> list = new ArrayList<>();
		Connection con = getUserConnection(AllUser.users.get(code));
		AISetDAO aiSetDAO = AISetDAO.getInstance();
		aiSetDAO.setConnection(con);
		
		
		
		list = aiSetDAO.selectArticleList();
		close(con);
		return list;
		
	}
}
