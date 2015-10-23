package com.Dishyan.Qiyeah.Modle;

import java.sql.Date;

/**
 * Created by Administrator on 15-10-11.
 */
public class Sendback {
    private String sdb_ID;
    private String user_ID;
    private Date sdb_Date;

    public Sendback() {
    }

    public Sendback(String sdb_ID, String user_ID, Date sdb_Date) {
        this.setSdb_ID(sdb_ID);
        this.setUser_ID(user_ID);
        this.setSdb_Date(sdb_Date);
    }

    public String getSdb_ID() {
        return sdb_ID;
    }

    public void setSdb_ID(String sdb_ID) {
        this.sdb_ID = sdb_ID;
    }

    public String getUser_ID() {
        return user_ID;
    }

    public void setUser_ID(String user_ID) {
        this.user_ID = user_ID;
    }

    public Date getSdb_Date() {
        return sdb_Date;
    }

    public void setSdb_Date(Date sdb_Date) {
        this.sdb_Date = sdb_Date;
    }
}
