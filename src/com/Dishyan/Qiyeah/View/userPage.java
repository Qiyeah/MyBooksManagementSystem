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
        System.out.println("-------------------��ӭ �� " + user.getUser_Name() + " ��ʹ��ͼ�����ϵͳ-------------------");
        System.out.println("|-1.������Ϣ\n|-2.�޸�����\n|-3.ͼ�����\n|-4.ͼ��黹" + "\n|-5.�ʻ���ֵ\n|-6.�˳���½");
        System.out.println("-------------------------------------------------------------------------");

        boolean flag = true;
        while (flag) {
            String cmd1 = gd.getData();
            if ("1".equals(cmd1)) {//������Ϣ
                flag = false;
                new QueryUserInfoPage().queryUserInfo(user);
            } else if ("2".equals(cmd1)) {//�޸�����
                flag = false;
                new AlterUserPassPage().alterUserPass(user);
            } else if ("3".equals(cmd1)) {//ͼ�����
                flag = false;
                new BorrowBookPage().borrowBook(user);
            } else if ("4".equals(cmd1)) {//ͼ��黹
                flag = false;

            } else if ("5".equals(cmd1)) {//�ʻ���ֵ
                flag = false;
                new AddUserMoneyPage().addUserMoney(user);
            } else if ("6".equals(cmd1)) {//�˳���½
                flag = false;
                System.out.println("ҳ����ʾ��ϵͳ�����˳�... ...");
                System.exit(0);
            } else {
                System.out.println("ҳ����ʾ��please enter again");
            }
        }
    }
}
