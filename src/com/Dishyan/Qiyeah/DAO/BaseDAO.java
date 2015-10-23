package com.Dishyan.Qiyeah.DAO;

import java.sql.*;

/**
 * Created by Qiyeah on 2015/10/4.
 */
public class BaseDAO {
    private final String Driver = "oracle.jdbc.driver.OracleDriver";
    private final String URL = "jdbc:oracle:thin://@192.168.1.105/orcl";
    private final String User = "Dishyan";
    private final String Pass = "dh123";

    private Connection conn = null;
    private ResultSet rs = null;
    private PreparedStatement prestat = null;
    private Statement stat = null;

    public void closeAll() {
        if (null != prestat) {
            try {
                prestat.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (null != rs) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (null != conn) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (null != stat) {
            try {
                stat.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public Connection getConn() {
        try {
            Class.forName(Driver);
            conn = DriverManager.getConnection(URL, User, Pass);
            return conn;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //建立基本查询方法
    /*
    1.基本查询方法必须确定是否有结果，所以返回值是boolean;
    2.查询必须有SQL查询语句和数据源，所以必须传入两类参数
     */
    public ResultSet doQuery(String sql, Object... para) {
        //查询需要先建立与数据库的连接
        conn = getConn();
        try {
            prestat = conn.prepareStatement(sql);
            for (int i = 0; i < para.length; i++) {
                prestat.setObject((i + 1), para[i]);
            }
            return prestat.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //如果没有查询结果，就返回false;
        return null;
    }

    public boolean doUpdate(String sql, Object... para) {
        conn = getConn();
        try {
            prestat = conn.prepareStatement(sql);
            for (int i = 0; i < para.length; i++) {
                prestat.setObject((i + 1), para[i]);
            }
            int rows = prestat.executeUpdate();
            if (1 <= rows) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll();
        }
        //如果没有更新成功，就返回false;
        return false;
    }
}
