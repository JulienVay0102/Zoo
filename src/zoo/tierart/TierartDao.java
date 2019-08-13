package zoo.tierart;

import java.sql.*;

import zoo.utils.DBConn;

public class TierartDao {
	
	private TierartModel tierart;
	private DBConn dbconn;
	private Connection conn;
	private Statement statement= null;
	private ResultSet resultSet = null;
	
	
	TierartDao(){
		dbconn = new DBConn();
		conn = dbconn.getConnection();
		tierart = new TierartModel();
	}
	
	public TierartModel getTierart(String gattung) {
		try {
			statement = conn.createStatement();
			String sql = "select * from tierart where gattung ='" + gattung +"'";
            resultSet = statement.executeQuery(sql);
            while(resultSet.next()) {
            tierart.setGattung(resultSet.getString("gattung"));
            }
            return tierart;
            
            
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void setTierart(String gattung, int anzahl, String lebensraum, float groesse, String nahrung) {
		try {
			statement = conn.createStatement();
			String sql = "insert into `tierart`(`gattung`, `anzahl`, `lebensraum`, `groesse`, `nahrung`) "
					+ "values ('" + gattung +"','"+ anzahl + "','"+ lebensraum +"','" + groesse + "','"+ nahrung +"')"; 
            statement.executeUpdate(sql);
                      
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateTierart(String gattung, int anzahl, String lebensraum, float groesse, String nahrung) {
		try {
			statement = conn.createStatement();
			String sql = "update `tierart` set `anzahl`='" + anzahl + "',`lebensraum`='" + lebensraum + "',`groesse`='"
					+ groesse + "',`nahrung`='" + nahrung + "' WHERE 'gattung' = '" + gattung + "'";
            statement.executeUpdate(sql);
                      
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

}
