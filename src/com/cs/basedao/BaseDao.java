package com.cs.basedao;

import java.sql.*;

public class BaseDao {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    //创建数据库连接对象的方法
    public Connection getConn() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //2.创建数据库连接对象 Connection
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/user?useUnicode=true&characterEncoding=utf-8"
                    , "root", "1318579525");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return conn;
        }

    }

    //专门用来查询的方法
    //String sql=select * from student where studentno=? and studentname=?
    //Object [] obj={10001,"jack"};
    public ResultSet exeuQuery(String sql, Object... objects) {
        getConn();
        try {
            ps = conn.prepareStatement(sql);
            if (objects != null) {
                for (int i = 0; i < objects.length; i++) {
                    ps.setObject(i + 1, objects[i]);
                }
            }
            rs = ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return rs;
        }
    }

    //专门用来增，删，改的方法
    public int exeuUpdate(String sql, Object... objects) {
        getConn();
        int index = -1;
        try {
            ps = conn.prepareStatement(sql);
            if (objects != null) {
                for (int i = 0; i < objects.length; i++) {
                    ps.setObject(i + 1, objects[i]);
                }
            }
            index = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return index;
        }
    }

    //关闭资源方法
    public void getClose() {
        try {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
