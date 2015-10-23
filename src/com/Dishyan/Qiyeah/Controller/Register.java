package com.Dishyan.Qiyeah.Controller;


import com.Dishyan.Qiyeah.DAO.UserDAO;
import com.Dishyan.Qiyeah.Util.GetData;

/**
 * Created by Qiyeah on 2015/10/4.
 */
public class Register {
    public void reg_User() {
        GetData gd = new GetData();
        UserDAO ud = new UserDAO();
        System.out.println("please enter user name:");
        String userName = gd.getData();
        System.out.println("please enter password:");
        String userPass = gd.getData();
        if (ud.register(userName, userPass)) {
            System.out.println("register successful! please logina later");
            new Login().login();
        }
    }

    public void reg_Admin() {
        GetData gd = new GetData();
        UserDAO ud = new UserDAO();
        System.out.println("please enter user name:");
        String userName = gd.getData();
        System.out.println("please enter password:");
        String userPass = gd.getData();
        if (ud.register(userName, userPass)) {
            System.out.println("register successful! please loginaa later");
            new Login().login();
        }
    }
}



