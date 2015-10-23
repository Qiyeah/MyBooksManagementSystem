package com.Dishyan.Qiyeah.View;


import com.Dishyan.Qiyeah.DAO.UserDAO;
import com.Dishyan.Qiyeah.Modle.Users;
import com.Dishyan.Qiyeah.Util.GetData;

/**
 * Created by Qiyeah on 2015/10/4.
 */
public class userPage {
    public void userCenter(Users user) {
        UserDAO userDAO = new UserDAO();
        GetData gd = new GetData();
        System.out.println("-------------------欢迎 【 " + user.getUser_Name() + " 】使用图书管理系统-------------------");
        System.out.println("|-1.个人信息\n|-2.修改密码\n|-3.图书借阅\n|-4.图书归还" + "\n|-5.帐户充值\n|-6.退出登陆");
        System.out.println("-------------------------------------------------------------------------");

        boolean flag = true;
        while (flag) {
            String cmd1 = gd.getData();
            if ("1".equals(cmd1)) {//个人信息
                flag = false;
                new QueryUserInfoPage().queryUserInfo(user);
            } else if ("2".equals(cmd1)) {//修改密码
                flag = false;
                new AlterUserPassPage().alterUserPass(user);
            } else if ("3".equals(cmd1)) {//图书借阅
                flag = false;
                new BorrowBookPage().borrowBook(user);
            } else if ("4".equals(cmd1)) {//图书归还
                flag = false;

            } else if ("5".equals(cmd1)) {//帐户充值
                flag = false;
                new AddUserMoneyPage().addUserMoney(user);
            } else if ("6".equals(cmd1)) {//退出登陆
                flag = false;
                System.out.println("页面提示：系统即将退出... ...");
                System.exit(0);
            } else {
                System.out.println("页面提示：please enter again");
            }
        }
    }
}
