package zoo.tier;

import java.sql.*;

import zoo.utils.DBConn;

public class TierDAO {
	
	private TierModel tier;
	private DBConn dbconn;
	private Connection conn;
	private Statement statement= null;
	private ResultSet resultSet = null;
	
	
	TierDAO(){
		dbconn = new DBConn();
		conn = dbconn.getConnection();
		tier = new TierModel();
	}
	
	public TierModel getTier(String id) {
		try {
			statement = conn.createStatement();
			//String sql = "select * from tier where id ='" + id +"'";
            //resultSet = statement.executeQuery(sql);
           
            
            return tier;
            
            
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void createTier() {
		try {
			statement = conn.createStatement();
			//String sql = "";
            //statement.executeUpdate(sql);
                      
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateTier() {
		try {
			statement = conn.createStatement();
			//String sql = "";
           // statement.executeUpdate(sql);
                      
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

}
