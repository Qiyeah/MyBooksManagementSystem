package com.Dishyan.Qiyeah.View;


import com.Dishyan.Qiyeah.DAO.BookDAO;
import com.Dishyan.Qiyeah.Modle.BookType;
import com.Dishyan.Qiyeah.Modle.Books;
import com.Dishyan.Qiyeah.Modle.Users;
import com.Dishyan.Qiyeah.Util.GetData;

import java.util.ArrayList;

/**
 * Created by Qiyeah on 2015/10/15.
 */
public class BorrowBookPage {
    BookDAO bkDAO = new BookDAO();
    GetData gd = new GetData();

    public void borrowBook(Users user) {
        /*String br_ID = new RandID().getID(RandID.BorrowID);
        String bri_ID = new RandID().getID(RandID.BookInfoID);*/
        ArrayList<BookType> typeList = bkDAO.getBookType("0");
        printTypeList(typeList);

        int tpIndex = Integer.parseInt(gd.getData()) - 1;
        ArrayList<BookType> subTypeList = bkDAO.getBookType(typeList.get(tpIndex).getBt_ID());
        printTypeList(subTypeList);


        int bkIndex = Integer.parseInt(gd.getData()) - 1;

        //System.out.println("Type:"+subTypeList.get(bkIndex).getBt_Name());
        // System.out.println("bt_ID:"+subTypeList.get(bkIndex).getBt_ID());

        String bt_ID = subTypeList.get(bkIndex).getBt_ID();
        int pages = bkDAO.countBooks(bt_ID);

        System.out.println("pages:" + pages);
        ArrayList<Books> bkList = getBookList(bt_ID, pages);
        printBookList(bkList);
        int index = Integer.parseInt(gd.getData()) - 1;
        Books bk = bkList.get(index);

        //printBookList(bkList);


    }

    public ArrayList<Books> getBookList(String bt_ID, int pages) {
        if (pages != 0) {
            for (int i = 1; i < pages + 1; i++) {
                System.out.println("bt_ID:" + bt_ID);
                String cmd = gd.getData();
                ArrayList<Books> list = bkDAO.findBooks(bt_ID, i);
                System.out.println("1111");
                printBookList(list);
                /*System.out.println("请输入：Y / N /[1-5]");
                if (cmd.matches("[Nn]")&&i<pages+1){
                    i++;
                    //printBookList(list);
                }else if (cmd.matches("[Pp]")&&i>0){
                    i--;
                    //printBookList(list);
                }else if (cmd.matches("[1-5]")){
                    i = Integer.parseInt(cmd)-1;
                    return bkDAO.findBooks(bt_ID,i);
                }else{
                    i = 1;
                    //printBookList(list);
                }*/
            }
        }
        return null;
    }

    public void printTypeList(ArrayList<BookType> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + "." + list.get(i).getBt_Name());
        }
    }

    public void printBookList(ArrayList<Books> bkList) {
        for (int i = 0; i < bkList.size(); i++) {
            System.out.println((i + 1) + "." + bkList.get(i).getBk_Name());
        }
    }


}


//1.查找库中已有的图书类型
        /*UserDAO userDAO = new UserDAO();
        GetData gd = new GetData();
        if (userDAO.queryMoney(user)>0) {
            BookDAO bookDAO = new BookDAO();
            //图书顶级类
            ArrayList<String> bookType = bookDAO.getBookType();
            System.out.println("-------------------------------bookType------------------------------------");
            for (int i = 0; i < bookType.size(); i++) {
                System.out.println((i + 1) + "." + bookType.get(i));
            }
            int index = Integer.parseInt(gd.getData()) - 1;
            String type = bookType.get(index);

            //图书小类
            ArrayList<String> listType = bookDAO.listBookType(type);
            System.out.println("-------------------------------listType------------------------------------");
            for (int i = 0; i < listType.size(); i++) {
                System.out.println((i + 1) + "." + listType.get(i));
            }
            int index1 = Integer.parseInt(gd.getData()) - 1;
            String bt_Name = listType.get(index1);


            Books book = bookDAO.getBook(bt_Name);
            if (book!=null) {
                BorrowDAO borrowDAO = new BorrowDAO();
                if (!borrowDAO.borrow(book.getBk_ID())) {
                    String br_ID = borrowDAO.borrowBook(user);
                    boolean brcg = borrowDAO.setBorrowInfo(br_ID, book.getBk_ID());
                    if (brcg) {
                        System.out.println("借书成功！");
                        System.out.println("继续借书：Y / N");
                        String cmd = gd.getData();
                        if (cmd.matches("[Yy]")) {
                            borrowBook(user);
                        } else {
                            new userPage().userCenter(user);
                        }
                    }
                } else {
                    System.out.println(book.getBk_Name() + "处于不可借阅状态");
                }
            }else {
                System.out.println("该类型的书籍还没有上架，请查看其他类型");
                borrowBook(user);
            }
        }else{
            System.out.println("你的帐户余额不足，不能完成借阅");
        }*/
