package com.Dishyan.Qiyeah.Controller;


import com.Dishyan.Qiyeah.DAO.UserDAO;
import com.Dishyan.Qiyeah.Modle.Admins;
import com.Dishyan.Qiyeah.Modle.Users;
import com.Dishyan.Qiyeah.Util.GetData;
import com.Dishyan.Qiyeah.View.AdminPage;
import com.Dishyan.Qiyeah.View.userPage;

/**
 * Created by Qiyeah on 2015/10/4.
 */
public class Login {
    public void login() {
        for (int i = 0; i < 1; ) {
            GetData gd = new GetData();
            System.out.println("-------------------------欢迎使用图书管理系统----------------------------");
            System.out.println("|-1.登陆系统\n|-2.系统注册\n|-3.关闭系统");
            System.out.println("-------------------------------------------------------------------------");
            String cmd1 = gd.getData();
            if ("1".equals(cmd1)) {
                i++;
                UserDAO ud = new UserDAO();
                System.out.println("请选择登陆方式：\n1. 用户\n2. 管理员");
                String cmd2 = gd.getData();
                for (int j = 0; j < 1; ) {
                    boolean lg;
                    if ("1".equals(cmd2)) {
                        System.out.println("please enter your user name：");
                        String userName = gd.getData();
                        System.out.println("please enter your password：");
                        String userPass = gd.getData();
                        lg = ud.checkUserLogin(userName, userPass);
                        if (lg) {
                            System.out.println("页面提示：land successfully ,connect to first page... ...");
                            j++;
                            Users user = ud.getUsers(userName);
                            new userPage().userCenter(user);
                        }
                    } else if ("2".equals(cmd2)) {
                        System.out.println("please enter your user name：");
                        String userName = gd.getData();
                        System.out.println("please enter your password：");
                        String userPass = gd.getData();
                        lg = ud.checkAdminLogin(userName, userPass);
                        if (lg) {
                            System.out.println("页面提示：land successfully ,connect to first page... ...");
                            j++;
                            Admins admin = ud.getAdmin(userName);
                            new AdminPage().managerCenter(admin);
                        }
                    } else {
                        System.out.println("页面提示：输入有误请重新输入");
                    }
                }
            } else if ("2".equals(cmd1)) {
                i++;
                new Register().reg_User();
            } else if ("3".equals(cmd1)) {
                i++;
                System.out.println("页面提示：系统即将退出... ...");
                System.exit(0);
            } else {
                System.out.println("页面提示：输入出错，请根据提示输入");
            }
        }
    }
}
