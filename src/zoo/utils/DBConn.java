package zoo.utils;

import java.sql.*;

public class DBConn {

		private Connection myConn = null;
		public Connection getConnection() { 
		
			try {
				myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zoo_db", "root" , "");
				return myConn;
			}
			catch (Exception exc) {
				exc.printStackTrace();
				return null;
			}
		}
		
		public void closeConnection (Connection con) {
		
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
	
}
