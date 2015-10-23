package com.Dishyan.Qiyeah.DAO;


import com.Dishyan.Qiyeah.Modle.Admins;

import java.sql.*;

/**
 * Created by Qiyeah on 2015/10/13.
 */
public class AdminsDAO extends BaseDAO {
    private Connection conn = null;//连接对象
    private ResultSet rs = null;//结果集对象
    private PreparedStatement prestat = null;//预处理对象
    private Statement stat = null;
    private String sql = null;

    public boolean alterPass(String userName, String newPass) {
        sql = "update Admins set ad_Pass = ? where ad_Name = ? ";
        conn = getConn();
        try {
            prestat = conn.prepareStatement(sql);
            prestat.setString(1, newPass);
            prestat.setString(2, userName);
            int rows = prestat.executeUpdate();
            if (0 != rows) {
                System.out.println("系统提示：密码修改成功！");
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException("系统提示：密码修改失败");
        } finally {
            closeAll();
        }
        return false;
    }


    public Admins query(Admins admin) {//查找数据
        System.out.println("-------------------------------用户个人信息------------------------------");
        sql = "select *from Users where user_ID = ? ";
        conn = getConn();
        try {
            prestat = conn.prepareStatement(sql);
            prestat.setString(1, admin.getAd_ID());
            rs = prestat.executeQuery();
            if (rs.next()) {

                return admin;
            }
        } catch (SQLException e) {
            //throw new RuntimeException("用户查询失败");
            e.printStackTrace();
        } finally {
            closeAll();
        }
        return null;
    }
}
