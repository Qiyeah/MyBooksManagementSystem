package com.Dishyan.Qiyeah.Test;


import com.Dishyan.Qiyeah.DAO.BaseDAO;
import com.Dishyan.Qiyeah.Modle.Users;

import java.sql.*;

/**
 * Created by Qiyeah on 2015/10/12.
 */
public class Login extends BaseDAO {
    public Users login(String userName) {
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement prestat = null;
        Users user = new Users();
        String sql = "select *from Users where user_Name = ?";
        conn = getConn();
        try {
            prestat = conn.prepareStatement(sql);
            prestat.setString(1, userName);
            rs = prestat.executeQuery();
            if (rs.next()) {
                System.out.println(rs.getString(1));
                System.out.println(rs.getString(2));
                System.out.println(rs.getString(3));
                /*user.setUser_ID(rs.getString("user_ID"));
                user.setUser_Name(rs.getString("user_Name"));
                user.setUser_Money(rs.getDouble("user_Money"));
                user.setUser_Phone(rs.getString("user_Phone"));
                user.setUser_Email(rs.getString("user_Email"));
                user.setUser_State(rs.getInt("user_State"));*/
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
}
