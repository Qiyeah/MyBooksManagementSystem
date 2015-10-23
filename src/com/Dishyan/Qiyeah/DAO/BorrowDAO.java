package com.Dishyan.Qiyeah.DAO;

import com.Dishyan.feiyu.Modle.Borrow;
import com.Dishyan.feiyu.Modle.Users;
import com.Dishyan.feiyu.Util.RandID;

import java.sql.*;

/**
 * Created by Qiyeah on 2015/10/15.
 */
public class BorrowDAO extends BookDAO {
    private Connection conn = null;
    private ResultSet rs = null;
    private PreparedStatement prestat = null;
    private String sql = null;//"":占了内存，null:不占内存
    private Statement stat = null;

    public String borrowBook(Users user) {
        conn = getConn();
        sql = "insert into Borrow(br_ID,USER_ID) values(?,?)";
        try {
            prestat = conn.prepareStatement(sql);
            String br_ID = new RandID().getID(RandID.BorrowID);
            prestat.setString(1, br_ID);
            prestat.setString(2, user.getUser_ID());

            //doUpdate(sql, br_ID,user.getUser_ID(),"2015-12-12");
            prestat.execute();
            return br_ID;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean setBorrowInfo(String br_ID, String bk_ID) {
        conn = getConn();
        sql = "insert into BorrowInfo values(?,?,?,?)";
        try {
            prestat = conn.prepareStatement(sql);
            prestat.setString(1, new RandID().getID(RandID.BorrowInfoID));
            prestat.setString(2, br_ID);
            prestat.setString(3, bk_ID);
            prestat.setInt(4, 1);
            int rows = prestat.executeUpdate();
            if (0 != rows) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean borrow(String bk_ID) {
        rs = doQuery("select * from Books where bk_Name = ?", bk_ID);
        try {
            if (rs.next()) {
                if (rs.getInt("bk_State") == 1) {
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public String setBorrow(Users user) {
        String br_ID = new RandID().getID(RandID.BorrowID);
        doUpdate("insert into B1orrow(br_ID,user_ID) values(?,?)", br_ID, user.getUser_ID());
        return br_ID;
    }

    public Borrow getBorrow(String br_ID) {
        rs = doQuery("select * from 1Borrow where br_ID = ?", br_ID);
        try {
            if (rs.next()) {
                return new Borrow(rs.getString("br_ID"), rs.getString("user_ID"), rs.getDate("br_Date"));
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
