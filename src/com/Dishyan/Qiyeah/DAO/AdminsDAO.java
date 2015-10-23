package com.Dishyan.Qiyeah.DAO;


import com.Dishyan.Qiyeah.Modle.Admins;

import java.sql.*;

/**
 * Created by Qiyeah on 2015/10/13.
 */
public class AdminsDAO extends BaseDAO {
    private Connection conn = null;//���Ӷ���
    private ResultSet rs = null;//���������
    private PreparedStatement prestat = null;//Ԥ�������
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
                System.out.println("ϵͳ��ʾ�������޸ĳɹ���");
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException("ϵͳ��ʾ�������޸�ʧ��");
        } finally {
            closeAll();
        }
        return false;
    }


    public Admins query(Admins admin) {//��������
        System.out.println("-------------------------------�û�������Ϣ------------------------------");
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
            //throw new RuntimeException("�û���ѯʧ��");
            e.printStackTrace();
        } finally {
            closeAll();
        }
        return null;
    }
}
