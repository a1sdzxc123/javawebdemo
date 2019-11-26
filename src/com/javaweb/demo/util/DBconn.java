package com.javaweb.demo.util;

import java.sql.*;

public class DBconn {
    static String url = "jdbc:mysql://localhost:3306/test";
    static String username = "root";
    static String password = "123";
    static Connection conn = null;
    static PreparedStatement ps = null;
    static ResultSet rs = null;

    public static void init() throws SQLException{
        try {
            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection(url,username,password);
        } catch (ClassNotFoundException e) {
            System.out.println("SQL初始化失败");
            e.printStackTrace();
        }

    }
    public static int addUpdDel(String sql){
        int i = 0;
        try {
            ps = conn.prepareStatement(sql);
            i=ps.executeUpdate();
        }catch (SQLException e){
            System.out.println("SQL数据库增删改异常");
            e.printStackTrace();
        }
        return i;
    }

    public static ResultSet selectSql(String sql){
        try {
            ps = conn.prepareStatement(sql);
            rs=ps.executeQuery(sql);
        } catch (SQLException e) {
            System.out.println("SQL数据库查询异常");
            e.printStackTrace();
        }
        return rs;
    }

    public static void closeConn(){
        try {
            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("数据库关闭异常");
            e.printStackTrace();
        }
    }
}
