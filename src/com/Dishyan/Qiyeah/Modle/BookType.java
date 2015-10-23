package com.Dishyan.Qiyeah.Modle;

/**
 * Created by Administrator on 15-10-11.
 */
public class BookType {
    private String bt_ID;
    private String bt_Name;
    private String bt_RID;
    private int bt_Time;

    public BookType() {
    }

    public BookType(String bt_ID, String bt_Name, String bt_RID, int bt_Time) {
        this.setBt_ID(bt_ID);
        this.setBt_Name(bt_Name);
        this.setBt_RID(bt_RID);
        this.setBt_Time(bt_Time);
    }

    public int getBt_Time() {
        return bt_Time;
    }

    public void setBt_Time(int bt_Time) {
        this.bt_Time = bt_Time;
    }

    public String getBt_ID() {
        return bt_ID;
    }

    public void setBt_ID(String bt_ID) {
        this.bt_ID = bt_ID;
    }

    public String getBt_Name() {
        return bt_Name;
    }

    public void setBt_Name(String bt_Name) {
        this.bt_Name = bt_Name;
    }

    public String getBt_RID() {
        return bt_RID;
    }

    public void setBt_RID(String bt_RID) {
        this.bt_RID = bt_RID;
    }
}
