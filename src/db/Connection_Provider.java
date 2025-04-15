package db;

import java.sql.*;

public class Connection_Provider {
    public static Connection getCon() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/inventory?useSSL=false", 
                "root", 
                "A!s#H46@9r7A2f0A$t"
            );
            return con;
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver not found: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Connection failed: " + e.getMessage());
        }
        return null;
    }
    
    public static ResultSet execute(String query) throws SQLException {
        Connection con = getCon();
        if (con == null) {
            throw new SQLException("Failed to establish connection.");
        }
        
        Statement st = con.createStatement();
        
        if (query.toLowerCase().startsWith("select")) {
            return st.executeQuery(query); // Corrected the variable and method usage
        } else {
            st.executeUpdate(query); // Execute for other queries like INSERT, UPDATE, DELETE
        }
        
        return null;
    }
}
