package com.github.zhang89.messageboardsbjdbc.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.LinkedList;

public class ConnPool {
    private static String url =
            "jdbc:mysql://localhost:3306/message_board";
    private static String username = "root";
    private static String password = "";

    private static LinkedList<Connection> activeConnPool;
    private static HashSet<Connection> usingConnPoo;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            for (int i = 0; i < 300; i++) {
                activeConnPool.add(DriverManager.getConnection(url,username,password));
            }
        } catch (Exception e) {
            e.printStackTrace();
            // throw e;
            // do not allow this throw checked exception

            throw new ExceptionInInitializerError(e);
        }
    }

    private static void extendConnectionPool(int count){
        try {
            for (int i = 0; i < count; i++) {
                activeConnPool.add(DriverManager.getConnection(url,username,password));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        if(activeConnPool.size() > 0){
            Connection conn = activeConnPool.get(0);
            activeConnPool.remove(conn);
            usingConnPoo.add(conn);
            return  conn;
        } else {
            extendConnectionPool(10);
            Connection conn = activeConnPool.get(0);
            activeConnPool.remove(conn);
            usingConnPoo.add(conn);
            return  conn;
        }
    }
    public static void releaseConnection(Connection connection){
        if(usingConnPoo.contains(connection)){
            usingConnPoo.remove(connection);
            activeConnPool.add(connection);
        }
    }
}
