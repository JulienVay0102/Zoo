package zoo.tierart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import zoo.utils.DBConnection;

public class TierartDao {
	
	public static TierartModel getTierartModel (String gattung) {

		try {
			Connection conn = DBConnection.getConnection();
			
			TierartModel tierart = new TierartModel();
			
			String sql = "SELECT * FROM TIERART WHERE GATTUNG = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1,gattung);
			
	        ResultSet rs = ps.executeQuery();
	       
	        while (rs.next()) {	           
	        	tierart.setGattung(rs.getString("gattung"));
	        	tierart.setAnzahl(rs.getInt("anzahl"));
	        	tierart.setLebensraum(rs.getString("lebensraum"));
	        	tierart.setGroesse(rs.getInt("groesse"));
	        	tierart.setNahrung(rs.getString("nahrung"));
	        	     
	        }
            return tierart; 
            
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static void createTierart(String gattung, int anzahl, String lebensraum, int groesse, String nahrung) {
		
		try {
			
			Connection conn = DBConnection.getConnection();
	
			final String sql = "INSERT INTO TIERART (gattung, anzahl, lebensraum, groesse, nahrung) VALUES (?,?,?,?,?)";
			
			PreparedStatement ps = conn.prepareStatement(sql);
		
			ps.setString	(1, gattung);
			ps.setInt		(2, anzahl);
			ps.setString	(3, lebensraum);
			ps.setInt		(4, groesse);
			ps.setString	(5, nahrung);
	        ps.executeUpdate();
			
                      
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void updateTierart(String gattung, int anzahl, String lebensraum, int groesse, String nahrung) {
		
		try { 
		
		Connection conn = DBConnection.getConnection();

		final String sql = "UPDATE TIERART SET gattung = ?, anzahl = ? , lebensraum = ?, groesse = ?, nahrung =?"
				+ " WHERE gattung = ?";
		
		PreparedStatement ps = conn.prepareStatement(sql);
	
		ps.setString	(1, gattung);
		ps.setInt		(2, anzahl);
		ps.setString	(3, lebensraum);
		ps.setInt		(4, groesse);
		ps.setString	(5, nahrung);
		ps.setString	(6, gattung);

        ps.executeUpdate();
		
                  
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void deleteTierart(String gattung) {
		
		try { 
			
			Connection conn = DBConnection.getConnection();

			final String sql = "DELETE FROM TIERART WHERE gattung = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
		
			ps.setString	(1, gattung);

	        ps.executeUpdate();
			
	                  
			} catch (SQLException e) {
				e.printStackTrace();
			}	
		
	}
	
	public static ArrayList<TierartModel> getAllTierart(){
		
		ArrayList<TierartModel> tierartModelList = new ArrayList<TierartModel>();
		
		try { 
			
			Connection conn = DBConnection.getConnection();

			final String sql = "SELECT * FROM TIERART";
			
			PreparedStatement ps = conn.prepareStatement(sql);
	        
	        ResultSet rs = ps.executeQuery();
	        
	        while(rs.next()) {
	        	TierartModel tierartModel = new TierartModel();
	        	tierartModel.setGattung(rs.getString("gattung"));
	        	tierartModel.setAnzahl(rs.getInt("anzahl"));
	        	tierartModel.setLebensraum(rs.getString("lebensraum"));
	        	tierartModel.setGroesse(rs.getInt("groesse"));
	        	tierartModel.setNahrung(rs.getString("nahrung"));
	        	tierartModelList.add(tierartModel);
	        }
	        
	        return tierartModelList;
			
	                  
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}	
		
	}
	
}
