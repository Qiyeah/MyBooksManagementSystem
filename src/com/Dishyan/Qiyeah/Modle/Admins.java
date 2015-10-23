package com.Dishyan.Qiyeah.Modle;

/**
 * Created by Administrator on 15-10-11.
 */
public class Admins {
    private String ad_ID;
    private String ad_Name;
    private String ad_Pass;
    private int ad_State;

    public Admins() {
    }

    public Admins(String ad_ID, String ad_Name, String ad_Pass, int ad_State) {
        this.setAd_ID(ad_ID);
        this.setAd_Name(ad_Name);
        this.setAd_Pass(ad_Pass);
        this.setAd_State(ad_State);
    }

    public String getAd_ID() {
        return ad_ID;
    }

    public void setAd_ID(String ad_ID) {
        this.ad_ID = ad_ID;
    }

    public String getAd_Name() {
        return ad_Name;
    }

    public void setAd_Name(String ad_Name) {
        this.ad_Name = ad_Name;
    }

    public String getAd_Pass() {
        return ad_Pass;
    }

    public void setAd_Pass(String ad_Pass) {
        this.ad_Pass = ad_Pass;
    }

    public int getAd_State() {
        return ad_State;
    }

    public void setAd_State(int ad_State) {
        this.ad_State = ad_State;
    }
}
