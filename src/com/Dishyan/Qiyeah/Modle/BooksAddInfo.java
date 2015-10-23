package com.Dishyan.Qiyeah.Modle;

import java.sql.Date;

/**
 * Created by Administrator on 15-10-11.
 */
public class BooksAddInfo {
    private String bka_ID;
    private String ad_ID;
    private String bk_ID;
    private Date bka_Date;

    public BooksAddInfo() {
    }

    public BooksAddInfo(String bka_ID, String ad_ID, String bk_ID, Date bka_Date) {
        this.setBka_ID(bka_ID);
        this.setAd_ID(ad_ID);
        this.setBk_ID(bk_ID);
        this.setBka_Date(bka_Date);
    }

    public String getBka_ID() {
        return bka_ID;
    }

    public void setBka_ID(String bka_ID) {
        this.bka_ID = bka_ID;
    }

    public String getAd_ID() {
        return ad_ID;
    }

    public void setAd_ID(String ad_ID) {
        this.ad_ID = ad_ID;
    }

    public String getBk_ID() {
        return bk_ID;
    }

    public void setBk_ID(String bk_ID) {
        this.bk_ID = bk_ID;
    }

    public Date getBka_Date() {
        return bka_Date;
    }

    public void setBka_Date(Date bka_Date) {
        this.bka_Date = bka_Date;
    }
}
