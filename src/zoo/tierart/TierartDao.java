package zoo.tierart;

import java.sql.*;
import java.util.ArrayList;

import zoo.utils.DBConn;

public class TierartDao {
	
	private TierartModel tierart;
	private ArrayList<TierartModel> tierartList;
	private DBConn dbconn;
	private Connection conn;
	private Statement statement = null;
	private ResultSet resultSet = null;

	TierartDao() {
		dbconn = new DBConn();
		conn = dbconn.getConnection();
		tierart = new TierartModel();
		tierartList = new ArrayList<TierartModel>();
	}

	public TierartModel getTierart(String gattung) {
		try {
			statement = conn.createStatement();
			String sql = "select * from tierart where gattung ='" + gattung + "'";
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				tierart.setGattung(resultSet.getString("gattung"));
			}
			return tierart;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public void createTierart(String gattung, int anzahl, String lebensraum, float groesse, String nahrung) {
		try {
			statement = conn.createStatement();
			String sql = "insert into `tierart`(`gattung`, `anzahl`, `lebensraum`, `groesse`, `nahrung`)" + "values ('"
					+ gattung + "','" + anzahl + "','" + lebensraum + "','" + groesse + "','" + nahrung + "')";
			statement.executeUpdate(sql);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateTierart(String gattung, int anzahl, String lebensraum, float groesse, String nahrung) {
		try {
			statement = conn.createStatement();
			String sql = "update `tierart` set `anzahl`=" + anzahl + ",`lebensraum`='" + lebensraum + "',`groesse`="
					+ groesse + ",`nahrung`='" + nahrung + "' WHERE `gattung` = '" + gattung + "'";
			statement.executeUpdate(sql);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteTierart(String gattung) {
		try {
			statement = conn.createStatement();
			String sql = "delete from `tierart` where `gattung`='" + gattung + "'";
			statement.executeUpdate(sql);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<TierartModel> getAllTierart() {
		try {
			statement = conn.createStatement();
			String sql = "select * from tierart";
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				TierartModel tierart = new TierartModel();
				tierart.setGattung(resultSet.getString("gattung"));
				tierart.setAnzahl(resultSet.getInt("anzahl"));
				tierart.setLebensraum(resultSet.getString("lebensraum"));
				tierart.setGroesse(resultSet.getInt("groesse"));
				tierart.setNahrung(resultSet.getString("nahrung"));
				tierartList.add(tierart);
			}
			return tierartList;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
