package com.Dishyan.Qiyeah.Modle;

import java.sql.Date;

/**
 * Created by Administrator on 15-10-11.
 */
public class LostBooks {
    private String lb_ID;
    private String bk_ID;
    private String user_ID;
    private Date lb_Date;

    public LostBooks() {
    }

    public LostBooks(String lb_ID, String bk_ID, String user_ID, Date lb_Date) {
        this.setLb_ID(lb_ID);
        this.setBk_ID(bk_ID);
        this.setUser_ID(user_ID);
        this.setLb_Date(lb_Date);
    }

    public String getLb_ID() {
        return lb_ID;
    }

    public void setLb_ID(String lb_ID) {
        this.lb_ID = lb_ID;
    }

    public String getBk_ID() {
        return bk_ID;
    }

    public void setBk_ID(String bk_ID) {
        this.bk_ID = bk_ID;
    }

    public String getUser_ID() {
        return user_ID;
    }

    public void setUser_ID(String user_ID) {
        this.user_ID = user_ID;
    }

    public Date getLb_Date() {
        return lb_Date;
    }

    public void setLb_Date(Date lb_Date) {
        this.lb_Date = lb_Date;
    }
}
