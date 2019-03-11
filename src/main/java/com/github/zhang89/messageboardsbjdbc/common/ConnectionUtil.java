package com.github.zhang89.messageboardsbjdbc.common;

import java.sql.*;

public final class ConnectionUtil {
    private ConnectionUtil(){}

    private static String url =
            "jdbc:mysql://localhost:3306/message_board";
    private static String username = "root";
    private static String password = "";

    private static Connection conn;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("can not find mysql driver");
            e.printStackTrace();
        } finally {
            conn = getConnection();
        }
    }

    public static Statement getStatement(){
        try{
            return conn.createStatement();
        } catch (SQLException e){
            return null;
        }
    }
    public static PreparedStatement getPreparedStatement(String sql){
        try{
            return conn.prepareStatement(sql);
        } catch (SQLException e){
            return null;
        }
    }

    public static void releasePreparedStatement(PreparedStatement psm){
        try {
            psm.close();
        }catch (SQLException e){
            System.out.println("failed to release prepared statement");
        }
    }

    public static void releaseStatement(Statement sm){
        try {
            sm.close();
        }catch (SQLException e){
            System.out.println("failed to release statement");
        }
    }

    private static Connection getConnection(){
        try {
            return DriverManager.getConnection(url,username,password);
        } catch (SQLException e) {
            System.out.println("fail to create db connection");
            return null;
        }
    }

    public static void release(ResultSet rs, Statement sm,
            Connection conn){
        try {
            if(rs != null){
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(sm != null){
                    sm.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if(conn != null){
                        conn.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println("????");
                }
            }
        }
    }
}
