package com.Dishyan.Qiyeah.Modle;

/**
 * Created by Administrator on 15-10-11.
 */
public class Users {
    private String user_ID;
    private String user_Name;
    private String user_Pass;
    private double user_Money;
    private String user_Phone;
    private String user_Email;
    private int user_State;

    public Users() {
    }

    public Users(String user_ID, String user_Name,
                 String user_Pass, double user_Money,
                 String user_Phone, String user_Email,
                 int user_State) {
        this.setUser_ID(user_ID);
        this.setUser_Name(user_Name);
        this.setUser_Pass(user_Pass);
        this.setUser_Money(user_Money);
        this.setUser_Phone(user_Phone);
        this.setUser_Email(user_Email);
        this.setUser_State(user_State);
    }

    public String getUser_ID() {
        return user_ID;
    }

    public void setUser_ID(String user_ID) {
        this.user_ID = user_ID;
    }

    public String getUser_Name() {
        return user_Name;
    }

    public void setUser_Name(String user_Name) {
        this.user_Name = user_Name;
    }

    public String getUser_Pass() {
        return user_Pass;
    }

    public void setUser_Pass(String user_Pass) {
        this.user_Pass = user_Pass;
    }

    public double getUser_Money() {
        return user_Money;
    }

    public void setUser_Money(double user_Money) {
        this.user_Money = user_Money;
    }

    public String getUser_Phone() {
        return user_Phone;
    }

    public void setUser_Phone(String user_Phone) {
        this.user_Phone = user_Phone;
    }

    public String getUser_Email() {
        return user_Email;
    }

    public void setUser_Email(String user_Email) {
        this.user_Email = user_Email;
    }

    public int getUser_State() {
        return user_State;
    }

    public void setUser_State(int user_State) {
        this.user_State = user_State;
    }
}
