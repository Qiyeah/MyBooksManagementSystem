package com.Dishyan.Qiyeah.DAO;


import com.Dishyan.Qiyeah.Modle.Admins;
import com.Dishyan.Qiyeah.Modle.Users;
import com.Dishyan.Qiyeah.Util.RandID;

import java.sql.*;

/**
 * Created by Administrator on 15-9-30.
 */
public class UserDAO extends BaseDAO {
    private Connection conn = null;//连接对象
    private ResultSet rs = null;//结果集对象
    private PreparedStatement prestat = null;//预处理对象
    private Statement stat = null;
    private String sql = null;

    public boolean register(String userName, String userPass) {
        conn = getConn();
        sql = "insert into Users(user_ID,user_Name,user_Pass) values(?,?,?)";
        try {
            prestat = conn.prepareStatement(sql);
            prestat.setString(1, new RandID().getID(RandID.UserID));
            prestat.setString(2, userName);
            prestat.setString(3, userPass);
            int rows = prestat.executeUpdate();
            if (rows != 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll();
        }
        return false;
    }

    public int judgeUserType(String userName) {
        int userType = 0;
        String str = userName.substring(0, 4);
        if ("user".equals(str)) {
            userType = 1;
        } else if ("admi".equals(str)) {
            userType = 2;
        }
        return userType;
    }

    public boolean deductMoney(Users user, double money) {//扣费
        return doUpdate("update Users set user_Money = user_Money -? where user_ID = ? ", money, user.getUser_ID());
    }

    public Users getUsers(String userName) {//从数据库获取普通用户信息
        Users user = new Users();
        sql = "select *from Users where user_Name = ?";
        conn = getConn();
        try {
            prestat = conn.prepareStatement(sql);
            prestat.setString(1, userName);
            rs = prestat.executeQuery();
            if (rs.next()) {
                user.setUser_ID(rs.getString("user_ID"));
                user.setUser_Name(rs.getString("user_Name"));
                user.setUser_Pass(rs.getString("user_Pass"));
                user.setUser_Money(rs.getDouble("user_Money"));
                user.setUser_Phone(rs.getString("user_Phone"));
                user.setUser_Email(rs.getString("user_Email"));
                user.setUser_State(rs.getInt("user_State"));
                return user;
            }
        } catch (SQLException e) {
            //throw new RuntimeException("用户信息获取失败");
            e.printStackTrace();
        } finally {
            closeAll();
        }
        return null;
    }

    public Admins getAdmin(String userName) {//从数据库获取管理员信息
        Admins user = new Admins();
        sql = "select *from Admins where ad_Name = ?";
        conn = getConn();
        try {
            prestat = conn.prepareStatement(sql);
            prestat.setString(1, userName);
            rs = prestat.executeQuery();
            if (rs.next()) {
                user.setAd_ID(rs.getString("ad_ID"));
                user.setAd_Name(rs.getString("ad_Name"));
                user.setAd_Pass(rs.getString("ad_Pass"));
                user.setAd_State(rs.getInt("ad_State"));
                return user;
            }
        } catch (SQLException e) {
            //throw new RuntimeException("用户信息获取失败");
            e.printStackTrace();
        } finally {
            closeAll();
        }
        return null;
    }

    public boolean checkUserLogin(String user, String pass) {
        conn = getConn();
        sql = "select * from Users where user_Name = ? and user_Pass = ?";
        rs = doQuery(sql, user, pass);
        try {
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean checkAdminLogin(String user, String pass) {
        conn = getConn();
        sql = "select * from Admins where ad_Name = ? and ad_Pass = ?";
        rs = doQuery(sql, user, pass);
        try {
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public double queryMoney(Users user) {
        rs = doQuery("select user_Money from Users where user_ID = ?", user.getUser_ID());
        try {
            if (rs.next()) {
                return rs.getDouble("user_Money");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0.00;
    }

    public boolean addMoney(Users user, double money) {
        return doUpdate("update Users set user_Money = user_Money+? where user_ID = ?", money, user.getUser_ID());
    }


    public void add(Users user) {//添加数据
        sql = "inset into Users(user_Phone,user_Email) values(?,?)";
        conn = getConn();
        try {
            prestat = conn.prepareStatement(sql);
            prestat.setObject(1, user.getUser_Phone());
            prestat.setObject(2, user.getUser_Email());
            int rows = prestat.executeUpdate();
            if (0 != rows) {
                System.out.println("用户信息修改成功");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll();
        }
    }

    public void delete(Users user) {//删除数据
        sql = "delete from Users where user_Name = ?";
        conn = getConn();
        try {
            prestat = conn.prepareStatement(sql);
            prestat.setObject(1, user.getUser_Name());
            prestat.execute();
        } catch (SQLException e) {
            throw new RuntimeException("用户删除失败");
        } finally {
            closeAll();
        }
    }

    public void update(Users user) {//修改数据
        sql = "update Users set user_Name = '"
                + user.getUser_Name() + "' where user_ID ='"
                + (user.getUser_ID()) + "'";
        conn = getConn();
        try {
            stat = conn.createStatement();
            stat.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException("用户修改失败");
        } finally {
            closeAll();
        }
    }


    public boolean isExist(Users user) {
        conn = getConn();
        sql = "select * from Users where user_Name = ?";
        rs = doQuery(sql, user.getUser_Name());
        try {
            while (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean alterPass(String userName, String newPass) {
        sql = "update Users set user_Pass = ? where user_Name = ? ";
        conn = getConn();
        try {
            prestat = conn.prepareStatement(sql);
            prestat.setString(1, newPass);
            prestat.setString(2, userName);
            int rows = prestat.executeUpdate();
            if (0 != rows) {
                System.out.println("密码修改成功！");
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException("密码修改失败");
        } finally {
            closeAll();
        }
        return false;
    }
}
