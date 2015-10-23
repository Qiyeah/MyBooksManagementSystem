package com.Dishyan.Qiyeah.View;


import com.Dishyan.Qiyeah.Modle.Users;
import com.Dishyan.Qiyeah.Util.GetData;

/**
 * Created by Qiyeah on 2015/10/15.
 */
public class QueryUserInfoPage {
    public void queryUserInfo(Users user) {
        System.out.println("｜--用户ID：" + user.getUser_ID()
                + "\n｜--用户名：" + user.getUser_Name()
                + "\n｜--用户余额：" + user.getUser_Money()
                + "\n｜--电话：" + user.getUser_Phone()
                + "\n｜--邮箱：" + user.getUser_Email());
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("是否返回个人中心：Y [返回]\t\tN [退出]");
        for (int i = 0; i < 1; ) {
            GetData gd = new GetData();
            String cmd2 = gd.getData();
            if (cmd2.matches("[Yy]")) {
                new userPage().userCenter(user);
            } else if (cmd2.matches("[Nn]")) {
                System.out.println("页面提示：用户退出...");
                System.exit(0);
            } else {
                System.out.println("页面提示：访问出错了！请确认命令是否正确");
            }
        }
    }
}
