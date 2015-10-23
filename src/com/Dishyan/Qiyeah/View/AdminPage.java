package com.Dishyan.Qiyeah.View;


import com.Dishyan.Qiyeah.Controller.Login;
import com.Dishyan.Qiyeah.DAO.AdminsDAO;
import com.Dishyan.Qiyeah.DAO.BookDAO;
import com.Dishyan.Qiyeah.Modle.Admins;
import com.Dishyan.Qiyeah.Modle.Books;
import com.Dishyan.Qiyeah.Util.GetData;

/**
 * Created by Qiyeah on 2015/10/13.
 */
public class AdminPage {
    public void managerCenter(Admins admin) {
        BookDAO bd = new BookDAO();
        AdminsDAO ad = new AdminsDAO();

        GetData gd = new GetData();
        System.out.println("-------------------��ӭ �� " + admin.getAd_Name() + " ��ʹ��ͼ�����ϵͳ-------------------");
        System.out.println("|-1.�޸�����\n|-2.ͼ���ϼ�\n|-3.ͼ���¼�" +
                "\n|-4.�����ѯ\n|-5.�����ѯ\n|-6.�˳���½");
        System.out.println("-------------------------------------------------------------------------");
        for (int i = 0; i < 1; ) {
            String cmd1 = gd.getData();
            if ("1".equals(cmd1)) {//�޸Ĺ���Ա����
                i = alterCode(admin, ad, gd, i);
            } else if ("2".equals(cmd1)) {//ͼ���ϼ�
                i = pushBooks(admin, gd, i);
            } else if ("3".equals(cmd1)) {//ͼ���¼�
                System.out.println("������Ҫ�¼ܵ�ͼ������");
                String bk_Name = gd.getData();
            } else if ("4".equals(cmd1)) {//�����ѯ

            } else if ("5".equals(cmd1)) {//�����ѯ

            } else if ("6".equals(cmd1)) {//�˳���½
                System.out.println("ҳ����ʾ��ϵͳ�˳�... ");
                System.exit(0);
            } else {
                System.out.println("ҳ����ʾ���������");
            }
        }
    }

    private int pushBooks(Admins admin, GetData gd, int i) {
        Books book = new Books();
        System.out.println("������������");
        book.setBk_Name(gd.getData());
        System.out.println("��������������");
        book.setBk_Author(gd.getData());
        System.out.println("������ͼ��۸�");
        book.setBk_Price(Double.parseDouble(gd.getData()));
        System.out.println("������ͼ��������");
        book.setBk_Count(Integer.parseInt(gd.getData()));
        System.out.println("������ͼ�����ͣ�");
        book.setBt_ID(gd.getData());
        if (new BookDAO().addBook(book)) {
            i++;
            System.out.println("ͼ���ϼܳɹ�");
            for (int j = 0; j < 1; j++) {
                System.out.println("�����ϼ�:��Y��\t��N��");
                String cmd = gd.getData();
                if (cmd.matches("[Yy]")) {
                    pushBook(gd, i);
                } else if (cmd.matches("[Nn]")) {
                    managerCenter(admin);
                }
            }
        }
        return i;
    }

    private int pushBook(GetData gd, int i) {
        Books book = new Books();
        System.out.println("������������");
        book.setBk_Name(gd.getData());
        System.out.println("��������������");
        book.setBk_Author(gd.getData());
        System.out.println("������ͼ��۸�");
        book.setBk_Price(Double.parseDouble(gd.getData()));
        System.out.println("������ͼ��������");
        book.setBk_Count(Integer.parseInt(gd.getData()));
        System.out.println("������ͼ�����ͣ�");
        book.setBt_ID(gd.getData());
        if (new BookDAO().addBook(book)) {
            i++;
            System.out.println("ͼ���ϼܳɹ�");
            for (int j = 0; j < 1; j++) {
                System.out.println("�����ϼ�:��Y��\t��N��");
                String cmd = gd.getData();
                if (cmd.matches("[Yy]")) {
                    pushBook(gd, i);
                } else if (cmd.matches("[Nn]")) {

                }
            }
        }
        return i;
    }

    private int alterCode(Admins admin, AdminsDAO ad, GetData gd, int i) {
        for (int j = 0; j < 1; ) {
            System.out.println("please enter your old password��");
            String oldPass = gd.getData();
            if (oldPass.equals(admin.getAd_Pass())) {
                System.out.println("please enter new password��");
                String newPass = gd.getData();
                System.out.println("please enter again��");
                String newPass1 = gd.getData();
                if (newPass.equals(newPass1)) {
                    boolean cg = ad.alterPass(admin.getAd_Name(), newPass);
                    if (cg) {
                        j++;
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
        return i;
    }
}
