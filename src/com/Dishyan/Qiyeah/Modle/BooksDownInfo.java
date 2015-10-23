package com.Dishyan.Qiyeah.Modle;

import java.sql.Date;

/**
 * Created by Administrator on 15-10-11.
 */
public class BooksDownInfo {
    private String bkd_ID;
    private String ad_ID;
    private String bk_ID;
    private Date bkd_Date;

    public BooksDownInfo() {
    }

    public BooksDownInfo(String bkd_ID, String ad_ID, String bk_ID, Date bkd_Date) {
        this.setBkd_Date(bkd_Date);
        this.setBkd_ID(bkd_ID);
        this.setBk_ID(bk_ID);
        this.setAd_ID(ad_ID);
    }

    public String getBkd_ID() {
        return bkd_ID;
    }

    public void setBkd_ID(String bkd_ID) {
        this.bkd_ID = bkd_ID;
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

    public Date getBkd_Date() {
        return bkd_Date;
    }

    public void setBkd_Date(Date bkd_Date) {
        this.bkd_Date = bkd_Date;
    }
}
