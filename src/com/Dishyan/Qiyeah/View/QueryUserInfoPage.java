package com.Dishyan.Qiyeah.View;


import com.Dishyan.Qiyeah.Modle.Users;
import com.Dishyan.Qiyeah.Util.GetData;

/**
 * Created by Qiyeah on 2015/10/15.
 */
public class QueryUserInfoPage {
    public void queryUserInfo(Users user) {
        System.out.println("��--�û�ID��" + user.getUser_ID()
                + "\n��--�û�����" + user.getUser_Name()
                + "\n��--�û���" + user.getUser_Money()
                + "\n��--�绰��" + user.getUser_Phone()
                + "\n��--���䣺" + user.getUser_Email());
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("�Ƿ񷵻ظ������ģ�Y [����]\t\tN [�˳�]");
        for (int i = 0; i < 1; ) {
            GetData gd = new GetData();
            String cmd2 = gd.getData();
            if (cmd2.matches("[Yy]")) {
                new userPage().userCenter(user);
            } else if (cmd2.matches("[Nn]")) {
                System.out.println("ҳ����ʾ���û��˳�...");
                System.exit(0);
            } else {
                System.out.println("ҳ����ʾ�����ʳ����ˣ���ȷ�������Ƿ���ȷ");
            }
        }
    }
}
