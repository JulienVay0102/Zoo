package zoo.pfleger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import zoo.utils.DBConnection;

/**
 * This is the data access object for "Pfleger"
 * 
 * @author mstuebing, Julien
 *
 */

public class PflegerDao {

	/**
	 * This method will create a connection to the database. It will read the
	 * database and creates an object depending on the read data. The primary key
	 * for this is "pflegerID".
	 * 
	 * @param pflegerID
	 * @return pflegerModel
	 */
	public static PflegerModel getPflegerModel(int pflegerID) {

		try {
			Connection conn = DBConnection.getConnection();
			PflegerModel pflegerModel = new PflegerModel();
			String sql = "SELECT * FROM PFLEGER WHERE pflegerID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, pflegerID);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				pflegerModel.setPflegerID(rs.getInt("pflegerID"));
				pflegerModel.setVname(rs.getString("vname"));
				pflegerModel.setNname(rs.getString("nname"));
			}
			return pflegerModel;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * This method let you create a new "PflegerIn" and insert him/her into the
	 * database.
	 * 
	 * @param vname
	 * @param nname
	 */

	public static void createPfleger(String vname, String nname) {

		try {

			Connection conn = DBConnection.getConnection();

			final String sql = "INSERT INTO Pfleger (vname, nname) VALUES (?,?)";

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, vname);
			ps.setString(2, nname);
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method let you update a currently existing "PflegerIn". After updating
	 * the method will save the changes on the database.
	 * 
	 * @param pflegerID
	 * @param vname
	 * @param nname
	 */

	public static void updatePfleger(int pflegerID, String vname, String nname) {

		try {

			Connection conn = DBConnection.getConnection();
			final String sql = "UPDATE PFLEGER SET vname = ?, nname = ?  WHERE pflegerID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, vname);
			ps.setString(2, nname);
			ps.setInt(3, pflegerID);
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method lets you delete an existing "PflegerIn" from the database.
	 * 
	 * @param pflegerID
	 */

	public static void deletePfleger(int pflegerID) {

		try {

			Connection conn = DBConnection.getConnection();
			final String sql = "DELETE FROM PFLEGER WHERE pflegerID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, pflegerID);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * This method creates an arraylist of "PflegerModel" with all existing
	 * "PflegerIn" from the database.
	 * 
	 * @return pflegerModelList
	 */

	public static ArrayList<PflegerModel> getAllPfleger() {

		ArrayList<PflegerModel> pflegerModelList = new ArrayList<PflegerModel>();

		try {

			Connection conn = DBConnection.getConnection();
			final String sql = "SELECT * FROM Pfleger";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				PflegerModel pflegerModel = new PflegerModel();
				pflegerModel.setPflegerID(rs.getInt("pflegerID"));
				pflegerModel.setVname(rs.getString("vname"));
				pflegerModel.setNname(rs.getString("nname"));
				pflegerModelList.add(pflegerModel);
			}

			return pflegerModelList;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}

}
