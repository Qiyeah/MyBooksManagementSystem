package com.Dishyan.Qiyeah.Modle;

/**
 * Created by Administrator on 15-10-11.
 */
public class Books {
    private String bk_ID;
    private String bk_Name;
    private String bk_Author;
    private double bk_Price;
    private int bk_Count;
    private String bt_ID;
    private int bk_State;

    public Books() {
    }

    public Books(String bk_ID, String bk_Name,
                 String bk_Author, double bk_Price,
                 int bk_Count, String bt_ID, int bk_State) {
        this.setBk_ID(bk_ID);
        this.setBk_Author(bk_Author);
        this.setBk_Price(bk_Price);
        this.setBk_Count(bk_Count);
        this.setBt_ID(bt_ID);
        this.setBk_State(bk_State);
    }

    public int getBk_State() {
        return bk_State;
    }

    public void setBk_State(int bk_State) {
        this.bk_State = bk_State;
    }

    public String getBk_ID() {
        return bk_ID;
    }

    public void setBk_ID(String bk_ID) {
        this.bk_ID = bk_ID;
    }

    public String getBk_Name() {
        return bk_Name;
    }

    public void setBk_Name(String bk_Name) {
        this.bk_Name = bk_Name;
    }

    public String getBk_Author() {
        return bk_Author;
    }

    public void setBk_Author(String bk_Author) {
        this.bk_Author = bk_Author;
    }

    public double getBk_Price() {
        return bk_Price;
    }

    public void setBk_Price(double bk_Price) {
        this.bk_Price = bk_Price;
    }

    public int getBk_Count() {
        return bk_Count;
    }

    public void setBk_Count(int bk_Count) {
        this.bk_Count = bk_Count;
    }

    public String getBt_ID() {
        return bt_ID;
    }

    public void setBt_ID(String bt_ID) {
        this.bt_ID = bt_ID;
    }
}
