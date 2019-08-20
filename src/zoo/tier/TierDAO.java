package zoo.tier;

import java.sql.*;
import java.util.ArrayList;

import zoo.map.PflegerModel;
import zoo.tierart.TierartModel;
import zoo.utils.DBConnection;

public class TierDAO {
	
	public static TierModel getTier(int tierID) {
		try {
			Connection conn = DBConnection.getConnection();
			TierModel tier = new TierModel();
			String sql = "select * from tier where tierID =?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, tierID);
			
	        ResultSet rs = ps.executeQuery();
	       
	        while (rs.next()) {	           
	        	tier.setTierID(tierID);
	        	tier.setName(rs.getString	("name"));
	        	tier.setHeight(rs.getInt	("height"));
	        	tier.setTierAlter(rs.getInt		("tieralter"));
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
	
				final String sql = "INSERT INTO tier (name, height, tieralter, gender, date, gattung, pflegerID) VALUES (?,?,?,?,?,?,?)";
			
			PreparedStatement ps = conn.prepareStatement(sql);
		
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
	
	public static void updateTier(int tierID, String name, int height, int tieralter, String gender, String date, TierartModel tierart, PflegerModel pfleger) {
		try {
			Connection conn = DBConnection.getConnection();
			
			final String sql2 =	"UPDATE tier SET name=?, height=?, tieralter=?, gender=?, date=?, gattung=?, pflegerID=? WHERE tierID=?";
			
			PreparedStatement ps = conn.prepareStatement(sql2);
		
			ps.setString		(1, name);
			ps.setInt			(2, height);
			ps.setInt			(3, tieralter);
			ps.setString		(4, gender);
			ps.setString		(5, date);
			ps.setString		(6, "TestTestErrorUff");
			ps.setInt			(7, 1);
			
			ps.setInt			(8, tierID);
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void deleteTier(int tierID) {
		try {
			Connection conn = DBConnection.getConnection();
			
			final String sql3 =	"DELETE FROM tier WHERE tierID=?";
			
			PreparedStatement ps = conn.prepareStatement(sql3);
			
			ps.setInt			(1, tierID);
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static ArrayList<TierModel> getAllTier() {
		try {
			Connection conn = DBConnection.getConnection();
			
			final String sql4 =	"SELECT * FROM tier";
			
			PreparedStatement ps = conn.prepareStatement(sql4);
				
			ResultSet rs = ps.executeQuery();
			
			ArrayList<TierModel> tierListe = new ArrayList<>();
			 while (rs.next()) {
				 	TierModel tier = new TierModel();
				 	tier.setTierID		(rs.getInt("tierID"));
		        	tier.setName		(rs.getString	("name"));
		        	tier.setHeight		(rs.getInt	("height"));
		        	tier.setTierAlter	(rs.getInt		("tieralter"));
		        	tier.setGender		(rs.getString	("gender"));
		        	tier.setDate		(rs.getString	("date"));
		        	tier.setTierart		(null);
		        	//r.setTierart(TierartDao.getTierart(rs.getString("gattung")));
		        	//TODO: Pfleger fehlt
		        	tier.setPfleger		(null);  
		        	tierListe.add(tier);
			 }
			 return tierListe;
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		return null;
	}

}
