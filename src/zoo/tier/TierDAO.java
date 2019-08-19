package zoo.tier;

import java.sql.*;

import zoo.map.PflegerModel;
import zoo.tierart.TierartModel;
import zoo.utils.DBConnection;

public class TierDAO {
	
	public static TierModel getTier(int tierID) {
		try {
			Connection conn = DBConnection.getConnection();
			TierModel tier = new TierModel();
			String sql = "select * from tier where tierID ='" + tierID +"'";
			PreparedStatement ps = conn.prepareStatement(sql);
	        ResultSet rs = ps.executeQuery();
	       
	        while (rs.next()) {	           
	        	tier.setTierID(tierID);
	        	tier.setName(rs.getString	("name"));
	        	tier.setHeight(rs.getInt	("height"));
	        	tier.setAlter(rs.getInt		("tieralter"));
	        	tier.setGender(rs.getString	("gender"));
	        	tier.setDate(rs.getString	("date"));
	        	tier.setTierart(null);
	        	//r.setTierart(TierartDao.getTierart(rs.getString("gattung")));
	        	//TODO: Pfleger fehlt
	        	tier.setPfleger(null);     
	        }
            return tier;       
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static void createTier(String name, int height, int alter, String gender, String date, TierartModel tierart, PflegerModel pfleger ) {
		try {
			Connection conn = DBConnection.getConnection();
	
				final String sql2 = "INSERT INTO tier (name, height, tieralter, gender, date, gattung, pflegerID) VALUES (?,?,?,?,?,?,?)";
			
			PreparedStatement ps = conn.prepareStatement(sql2);
		
			ps.setString	(1, name);
			ps.setInt		(2, height);
			ps.setInt		(3, alter);
			ps.setString	(4, gender);
			ps.setString	(5, date);
			ps.setString	(6, "tierart.getGattung()");
			//TODO: Pfleger fehlt noch!
			ps.setInt		(7, 1);
	        ps.executeUpdate();
			
			//String sql = "";
            //statement.executeUpdate(sql);
                      
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void updateTier(int anzahl, String lebensraum, int groesse, String nahrung, TierartModel tierart) {
		try {
			Connection conn = DBConnection.getConnection();
			//TODO: für dienstag: update sql
			final String sql2 =	"";
		
			PreparedStatement ps = conn.prepareStatement(sql2);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

}
