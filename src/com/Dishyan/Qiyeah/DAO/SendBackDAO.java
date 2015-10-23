package com.Dishyan.Qiyeah.DAO;


import com.Dishyan.Qiyeah.Modle.Users;

import java.sql.*;

/**
 * Created by Qiyeah on 2015/10/15.
 */
public class SendBackDAO extends BaseDAO {
    private Connection conn = null;
    private ResultSet rs = null;
    private PreparedStatement prestat = null;
    private String sql = null;//"":占了内存，null:不占内存
    private Statement stat = null;

    public boolean getBorrowList(Users user) {
        rs = doQuery("select *from BORROWINFO where BR_ID = (select br_ID from 1Borrow where user_ID =?)", user.getUser_ID());
        try {
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void sendBack(Users user) {
        doUpdate("update BorrowBookInfo set br_State = 0 where bri_ID = ");
    }
}
