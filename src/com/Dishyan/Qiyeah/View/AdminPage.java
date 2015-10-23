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
        System.out.println("-------------------欢迎 【 " + admin.getAd_Name() + " 】使用图书管理系统-------------------");
        System.out.println("|-1.修改密码\n|-2.图书上架\n|-3.图书下架" +
                "\n|-4.借书查询\n|-5.还书查询\n|-6.退出登陆");
        System.out.println("-------------------------------------------------------------------------");
        for (int i = 0; i < 1; ) {
            String cmd1 = gd.getData();
            if ("1".equals(cmd1)) {//修改管理员密码
                i = alterCode(admin, ad, gd, i);
            } else if ("2".equals(cmd1)) {//图书上架
                i = pushBooks(admin, gd, i);
            } else if ("3".equals(cmd1)) {//图书下架
                System.out.println("请输入要下架的图书名：");
                String bk_Name = gd.getData();
            } else if ("4".equals(cmd1)) {//借书查询

            } else if ("5".equals(cmd1)) {//还书查询

            } else if ("6".equals(cmd1)) {//退出登陆
                System.out.println("页面提示：系统退出... ");
                System.exit(0);
            } else {
                System.out.println("页面提示：输入出错");
            }
        }
    }

    private int pushBooks(Admins admin, GetData gd, int i) {
        Books book = new Books();
        System.out.println("请输入书名：");
        book.setBk_Name(gd.getData());
        System.out.println("请输入作者名：");
        book.setBk_Author(gd.getData());
        System.out.println("请输入图书价格：");
        book.setBk_Price(Double.parseDouble(gd.getData()));
        System.out.println("请输入图书数量：");
        book.setBk_Count(Integer.parseInt(gd.getData()));
        System.out.println("请输入图书类型：");
        book.setBt_ID(gd.getData());
        if (new BookDAO().addBook(book)) {
            i++;
            System.out.println("图书上架成功");
            for (int j = 0; j < 1; j++) {
                System.out.println("继续上架:【Y】\t【N】");
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
        System.out.println("请输入书名：");
        book.setBk_Name(gd.getData());
        System.out.println("请输入作者名：");
        book.setBk_Author(gd.getData());
        System.out.println("请输入图书价格：");
        book.setBk_Price(Double.parseDouble(gd.getData()));
        System.out.println("请输入图书数量：");
        book.setBk_Count(Integer.parseInt(gd.getData()));
        System.out.println("请输入图书类型：");
        book.setBt_ID(gd.getData());
        if (new BookDAO().addBook(book)) {
            i++;
            System.out.println("图书上架成功");
            for (int j = 0; j < 1; j++) {
                System.out.println("继续上架:【Y】\t【N】");
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
            System.out.println("please enter your old password：");
            String oldPass = gd.getData();
            if (oldPass.equals(admin.getAd_Pass())) {
                System.out.println("please enter new password：");
                String newPass = gd.getData();
                System.out.println("please enter again：");
                String newPass1 = gd.getData();
                if (newPass.equals(newPass1)) {
                    boolean cg = ad.alterPass(admin.getAd_Name(), newPass);
                    if (cg) {
                        j++;
                        i++;
                        System.out.println("页面提示：验证成功，请重新登陆");
                        new Login().login();
                    }
                } else {
                    System.out.println("页面提示：两次输入不一致");
                }
            } else {
                System.out.println("页面提示：密码输入不正确");
            }
        }
        return i;
    }
}
