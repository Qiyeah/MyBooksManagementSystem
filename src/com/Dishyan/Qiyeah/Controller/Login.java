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
            System.out.println("-------------------------��ӭʹ��ͼ�����ϵͳ----------------------------");
            System.out.println("|-1.��½ϵͳ\n|-2.ϵͳע��\n|-3.�ر�ϵͳ");
            System.out.println("-------------------------------------------------------------------------");
            String cmd1 = gd.getData();
            if ("1".equals(cmd1)) {
                i++;
                UserDAO ud = new UserDAO();
                System.out.println("��ѡ���½��ʽ��\n1. �û�\n2. ����Ա");
                String cmd2 = gd.getData();
                for (int j = 0; j < 1; ) {
                    boolean lg;
                    if ("1".equals(cmd2)) {
                        System.out.println("please enter your user name��");
                        String userName = gd.getData();
                        System.out.println("please enter your password��");
                        String userPass = gd.getData();
                        lg = ud.checkUserLogin(userName, userPass);
                        if (lg) {
                            System.out.println("ҳ����ʾ��land successfully ,connect to first page... ...");
                            j++;
                            Users user = ud.getUsers(userName);
                            new userPage().userCenter(user);
                        }
                    } else if ("2".equals(cmd2)) {
                        System.out.println("please enter your user name��");
                        String userName = gd.getData();
                        System.out.println("please enter your password��");
                        String userPass = gd.getData();
                        lg = ud.checkAdminLogin(userName, userPass);
                        if (lg) {
                            System.out.println("ҳ����ʾ��land successfully ,connect to first page... ...");
                            j++;
                            Admins admin = ud.getAdmin(userName);
                            new AdminPage().managerCenter(admin);
                        }
                    } else {
                        System.out.println("ҳ����ʾ��������������������");
                    }
                }
            } else if ("2".equals(cmd1)) {
                i++;
                new Register().reg_User();
            } else if ("3".equals(cmd1)) {
                i++;
                System.out.println("ҳ����ʾ��ϵͳ�����˳�... ...");
                System.exit(0);
            } else {
                System.out.println("ҳ����ʾ����������������ʾ����");
            }
        }
    }
}
