package com.Dishyan.Qiyeah.DAO;

import com.Dishyan.feiyu.Modle.Books;
import com.Dishyan.feiyu.Modle.Borrow;
import com.Dishyan.feiyu.Modle.BorrowInfo;
import com.Dishyan.feiyu.Util.RandID;

import java.sql.*;

/**
 * Created by Qiyeah on 2015/10/15.
 */
public class BorrowInfoDAO extends BaseDAO {
    private Connection conn = null;
    private ResultSet rs = null;
    private PreparedStatement prestat = null;
    private String sql = null;//"":占了内存，null:不占内存
    private Statement stat = null;

    public String setBorrowInfo(Borrow borrow, Books book) {
        String bri_ID = new RandID().getID(RandID.BorrowInfoID);
        doUpdate("insert into BorrowInfo(bri_ID,br_ID,bk_ID) values(?,?,?)", bri_ID, borrow.getBr_ID(), book.getBk_ID());
        return bri_ID;
    }

    public BorrowInfo getBorrowInfo(String bri_ID) {
        rs = doQuery("select * from BorrowInfo where br_ID = ?", bri_ID);
        try {
            if (rs.next()) {
                return new BorrowInfo(rs.getString("bri_ID"), rs.getString("br_ID"), rs.getString("bk_ID"), rs.getInt("bri_State"));
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
