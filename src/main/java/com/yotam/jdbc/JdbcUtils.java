package com.yotam.jdbc;

import java.sql.*;

public class JdbcUtils {

    private static final String url = "jdbc:mysql://localhost:3306/demo";
    private static final String user = "root";
    private static final String password = "Adviksai55#";

    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;

    private static void loadJdbcDriver() throws ClassNotFoundException {
        // 5.X -> com.mysql.jdbc.Driver
        // 8.X -> com.mysql.cj.jdbc.Driver
        Class.forName("com.mysql.cj.jdbc.Driver");
    }

    /**
     * Create a Connection Instance
     *
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(url, user, password);
        return connection;
    }
}
