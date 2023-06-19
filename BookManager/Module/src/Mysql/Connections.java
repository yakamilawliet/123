package Mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Connections {

    private static String url = "jdbc:mysql:///book_system?useSSL=false";
    private static String user = "root";
    private static String password = "2333";
    private static Connection con = null;

    //获取连接
    public static Connection getConn() {
        try {
            //获得连接
            con = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }

    //回收资源 DQL有结果集方式
    public static void closeconn(Connection conn, Statement stat, ResultSet rs) {
        if (stat != null) {
            try {
                stat.close();
            }catch(Exception e ) {
                e.printStackTrace();
            }
        }

        if  (rs != null) {
            try {
                rs.close();
            } catch(Exception e) {
                e.printStackTrace();
            }
        }

        if (conn != null) {
            try {
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    //回收资源 ， DML DDL无结果形式
    public static void closeconn(Connection conn , Statement stat){
        if (stat != null) {
            try {
                stat.close();
            }catch(Exception e ) {
                e.printStackTrace();
            }
        }

        if (conn != null) {
            try {
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


}