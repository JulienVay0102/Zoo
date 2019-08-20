package zoo.pfleger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import zoo.utils.DBConnection;

public class PflegerDao {

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
