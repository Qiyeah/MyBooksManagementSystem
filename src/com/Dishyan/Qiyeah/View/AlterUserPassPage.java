package com.Dishyan.Qiyeah.View;


import com.Dishyan.Qiyeah.Controller.Login;
import com.Dishyan.Qiyeah.DAO.UserDAO;
import com.Dishyan.Qiyeah.Modle.Users;
import com.Dishyan.Qiyeah.Util.GetData;

/**
 * Created by Qiyeah on 2015/10/15.
 */
public class AlterUserPassPage {
    public void alterUserPass(Users user) {
        for (int i = 0; i < 1; ) {
            UserDAO userDAO = new UserDAO();
            GetData gd = new GetData();
            System.out.println("please enter your old password��");
            String oldPass = gd.getData();
            if (oldPass.equals(user.getUser_Pass())) {
                System.out.println("please enter new password��");
                String newPass = gd.getData();
                System.out.println("please enter again��");
                String newPass1 = gd.getData();
                if (newPass.equals(newPass1)) {
                    boolean cg = userDAO.alterPass(user.getUser_Name(), newPass);
                    if (cg) {
                        i++;
                        System.out.println("ҳ����ʾ����֤�ɹ��������µ�½");
                        new Login().login();
                    }
                } else {
                    System.out.println("ҳ����ʾ���������벻һ��");
                }
            } else {
                System.out.println("ҳ����ʾ���������벻��ȷ");
            }
        }
    }
}
