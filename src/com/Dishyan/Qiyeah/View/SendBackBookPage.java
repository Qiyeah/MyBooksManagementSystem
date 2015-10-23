package com.Dishyan.Qiyeah.View;


import com.Dishyan.Qiyeah.DAO.SendBackDAO;
import com.Dishyan.Qiyeah.Modle.Users;

/**
 * Created by Qiyeah on 2015/10/15.
 */
public class SendBackBookPage {
    public void sendBackbook(Users user) {
        SendBackDAO sdb = new SendBackDAO();
        if (sdb.getBorrowList(user)) {

        }

    }
}
