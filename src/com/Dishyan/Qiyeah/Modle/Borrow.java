package com.Dishyan.Qiyeah.Modle;

import java.sql.Date;

/**
 * Created by Administrator on 15-10-11.
 */
public class Borrow {
    private String br_ID;
    private String user_ID;
    private Date br_Date;

    public Borrow() {
    }

    public Borrow(String br_ID, String user_ID, Date br_Date) {
        this.setBr_ID(br_ID);
        this.setBr_Date(br_Date);
        this.setUser_ID(user_ID);
    }

    public String getBr_ID() {
        return br_ID;
    }

    public void setBr_ID(String br_ID) {
        this.br_ID = br_ID;
    }

    public String getUser_ID() {
        return user_ID;
    }

    public void setUser_ID(String user_ID) {
        this.user_ID = user_ID;
    }

    public Date getBr_Date() {
        return br_Date;
    }

    public void setBr_Date(Date br_Date) {
        this.br_Date = br_Date;
    }
}
