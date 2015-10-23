package com.Dishyan.Qiyeah.Modle;

/**
 * Created by Administrator on 15-10-11.
 */
public class SendbackInfo {
    private String sdbi_ID;
    private String sdb_ID;
    private String bk_ID;

    public SendbackInfo() {
    }

    public SendbackInfo(String sdbi_ID, String sdb_ID, String bk_ID) {
        this.setSdbi_ID(sdbi_ID);
        this.setSdb_ID(sdb_ID);
        this.setBk_ID(bk_ID);
    }

    public String getSdbi_ID() {
        return sdbi_ID;
    }

    public void setSdbi_ID(String sdbi_ID) {
        this.sdbi_ID = sdbi_ID;
    }

    public String getSdb_ID() {
        return sdb_ID;
    }

    public void setSdb_ID(String sdb_ID) {
        this.sdb_ID = sdb_ID;
    }

    public String getBk_ID() {
        return bk_ID;
    }

    public void setBk_ID(String bk_ID) {
        this.bk_ID = bk_ID;
    }
}
