package com.Dishyan.Qiyeah.Util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 15-10-11.
 */
public class RandID {
    public static final int UserID = 1;
    public static final int BookID = 2;
    public static final int BookInfoID = 3;
    public static final int BorrowID = 4;
    public static final int SendID = 5;
    public static final int SendInfoID = 6;
    public static final int BorrowInfoID = 7;
    public static final int adminID = 8;
    public static final int lostID = 9;
    public static final int BookCommentID = 10;
    public static final int BookAddID = 11;
    public static final int BookDownID = 12;

    public String getID(int type) {//类型不同产生的ID不同
        if (type == 1) {
            return "user" + getInfo();//user2015101115022823515245896235
        } else if (type == 2) {
            return "book" + getInfo();
        } else if (type == 3) {
            return "bkif" + getInfo();
        } else if (type == 4) {
            return "brow" + getInfo();
        } else if (type == 5) {
            return "send" + getInfo();
        } else if (type == 6) {
            return "sdif" + getInfo();
        } else if (type == 7) {
            return "brif" + getInfo();
        } else if (type == 8) {
            return "admi" + getInfo();
        } else if (type == 9) {
            return "lost" + getInfo();
        } else if (type == 10) {
            return "bkcm" + getInfo();
        } else if (type == 11) {
            return "bkad" + getInfo();
        } else if (type == 12) {
            return "bkdn" + getInfo();
        }
        return null;
    }

    public String getInfo() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmssSSS");
        String str = sdf.format(new Date());
        StringBuffer stb = new StringBuffer();
        for (int i = 0; i < 11; i++) {

            stb.append((int) (Math.random() * 10));
        }
        return str + stb.toString();
    }
}
