package zoo.utils;

import java.sql.*;
/**
 * The DBCOnnection is creating a connection to the SQL Database
 * @author Konstantin
 *
 */
public class DBConnection {

    private static Connection myConn;

    public static Connection getConnection() {

        try {
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zoo_db", "root" , "");
            return myConn;
        }
     catch (SQLException ex) {
        throw new RuntimeException("Error connecting to the database", ex);
     }
    }

    public void closeConnection (Connection con) {

        try {
            con.close();
        }  catch (SQLException ex) {
            throw new RuntimeException("Error while closing the database", ex);
        }
    }
}


