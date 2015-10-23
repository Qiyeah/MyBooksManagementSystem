package com.Dishyan.Qiyeah.Test;


import com.Dishyan.Qiyeah.Modle.Users;
import com.Dishyan.Qiyeah.View.BorrowBookPage;

/**
 * Created by Qiyeah on 2015/10/16.
 */
public class TestBorrowPage {
    public static void main(String[] args) {
        Users user = new Users("user2015101210590898552829098792", "feiyu", "feiyu", 1000.00, null, null, 1);
        new BorrowBookPage().borrowBook(user);

    }
}
