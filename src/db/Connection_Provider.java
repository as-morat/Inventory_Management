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
    
    // Improved execute method
public static ResultSet execute(String query, Object... params) throws SQLException {
    Connection con = getCon();
    if (con == null) {
        throw new SQLException("Failed to establish connection.");
    }
    
    if (query.toLowerCase().startsWith("select")) {
        PreparedStatement ps = con.prepareStatement(query);
        for (int i = 0; i < params.length; i++) {
            ps.setObject(i+1, params[i]);
        }
        return ps.executeQuery();
    } else {
        try (PreparedStatement ps = con.prepareStatement(query)) {
            for (int i = 0; i < params.length; i++) {
                ps.setObject(i+1, params[i]);
            }
            ps.executeUpdate();
        }
        con.close();
    }
    
    return null;
}
}
