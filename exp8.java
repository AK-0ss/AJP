package exp;

import java.sql.*;

public class exp8 {
static final String DB_URL = "jdbc:mysql://localhost/class";
static final String USER = "root";
static final String PASS = "A@123";
public static void main(String[] args) {
// Open a connection
try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
Statement stmt = conn.createStatement();
) {
String sql = "CREATE DATABASE STUDENTS";
stmt.executeUpdate(sql);
System.out.println("Database created successfully...");
} catch (SQLException e) {
e.printStackTrace();
}
}
}
