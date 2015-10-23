package com.Dishyan.Qiyeah.Modle;

import java.sql.Date;

/**
 * Created by Administrator on 15-10-11.
 */
public class BookComments {
    private String bc_ID;
    private String user_ID;
    private String bk_ID;
    private String bc_Comment;
    private Date bc_Date;

    public BookComments() {
    }

    public BookComments(String bc_ID, String user_ID,
                        String bk_ID, String bc_Comment,
                        Date bc_Date) {
        this.setBc_ID(bc_ID);
        this.setUser_ID(user_ID);
        this.setBc_Comment(bc_Comment);
        this.setBk_ID(bk_ID);
        this.setBc_Date(bc_Date);
    }

    public String getBc_ID() {
        return bc_ID;
    }

    public void setBc_ID(String bc_ID) {
        this.bc_ID = bc_ID;
    }

    public String getUser_ID() {
        return user_ID;
    }

    public void setUser_ID(String user_ID) {
        this.user_ID = user_ID;
    }

    public String getBk_ID() {
        return bk_ID;
    }

    public void setBk_ID(String bk_ID) {
        this.bk_ID = bk_ID;
    }

    public String getBc_Comment() {
        return bc_Comment;
    }

    public void setBc_Comment(String bc_Comment) {
        this.bc_Comment = bc_Comment;
    }

    public Date getBc_Date() {
        return bc_Date;
    }

    public void setBc_Date(Date bc_Date) {
        this.bc_Date = bc_Date;
    }
}
