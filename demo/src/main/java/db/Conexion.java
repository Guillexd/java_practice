package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {
    private static final String 
    JDBC_URL = "jdbc:mysql://localhost:3306/javadb?userSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true", 
    JDBC_USER = "root",
    JDBC_PASSWORD = "Elmejor@89.";

    public static Connection getConnection() throws SQLException
    {
       return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
    }

    public static void close(ResultSet rs) throws SQLException
    {
        rs.close();
    }

    public static void close(Statement statm) throws SQLException
    {
        statm.close();
    }

    public static void close(PreparedStatement statm) throws SQLException
    {
        statm.close();
    }

    public static void close(Connection conn) throws SQLException
    {
        conn.close();
    }
}