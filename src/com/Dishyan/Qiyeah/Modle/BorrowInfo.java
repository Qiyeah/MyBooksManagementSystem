package com.Dishyan.Qiyeah.Modle;

/**
 * Created by Administrator on 15-10-11.
 */
public class BorrowInfo {
    private String bri_ID;
    private String br_ID;
    private String bk_ID;
    private int bri_State;

    public BorrowInfo() {
    }

    public BorrowInfo(String bri_ID, String br_ID, String bk_ID, int bri_State) {
        this.setBri_ID(bri_ID);
        this.setBr_ID(br_ID);
        this.setBk_ID(bk_ID);
        this.setBri_State(bri_State);
    }

    public int getBri_State() {
        return bri_State;
    }

    public void setBri_State(int bri_State) {
        this.bri_State = bri_State;
    }

    public String getBri_ID() {
        return bri_ID;
    }

    public void setBri_ID(String bri_ID) {
        this.bri_ID = bri_ID;
    }

    public String getBr_ID() {
        return br_ID;
    }

    public void setBr_ID(String br_ID) {
        this.br_ID = br_ID;
    }

    public String getBk_ID() {
        return bk_ID;
    }

    public void setBk_ID(String bk_ID) {
        this.bk_ID = bk_ID;
    }
}
