package com.Dishyan.Qiyeah.Util;

import java.util.Scanner;

/**
 * Created by Administrator on 15-9-30.
 */
public class GetData {
    public String getData() {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        if (null != str && !"".equals(str)) {
            return str;
        } else {
            System.out.println("莫乱搞，你的输入要不得");
            return getData();
        }
    }
}
