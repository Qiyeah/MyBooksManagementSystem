package com.Dishyan.Qiyeah.DAO;

import com.Dishyan.Qiyeah.Modle.BookType;
import com.Dishyan.Qiyeah.Modle.Books;
import com.Dishyan.Qiyeah.Util.GetData;
import com.Dishyan.Qiyeah.Util.RandID;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Qiyeah on 2015/10/12.
 */
public class BookDAO extends BaseDAO {
    private Connection conn = null;
    private ResultSet rs = null;
    private PreparedStatement prestat = null;
    private String sql = null;//"":ռ���ڴ棬null:��ռ�ڴ�
    private Statement stat = null;

    public boolean addBook(Books book) {//�����ϼ�
        sql = "insert into Books (bk_ID,bk_Name,bk_Author,bk_Price,bk_Count,bt_ID) values(?,?,?,?,?,?)";
        String bk_ID = new RandID().getID(RandID.BookID);
        String bk_Name = book.getBk_Name();
        String bk_Author = book.getBk_Author();
        double bk_Price = book.getBk_Price();
        int bk_Count = book.getBk_Count();
        String bt_ID = book.getBt_ID();
        return doUpdate(sql, bk_ID, bk_Name, bk_Author, bk_Price, bk_Count, bt_ID);
    }

    public ArrayList<BookType> getBookType(String bt_RID) {//�ҳ�ͼ������еĴ��ࡣͨ����RID����
        rs = doQuery("select * from BookType where bt_RID = ?", bt_RID);
        ArrayList<BookType> bookType = new ArrayList<BookType>();
        BookType bt = null;
        try {
            while (rs.next()) {
                bt = new BookType();
                bt.setBt_ID(rs.getString("bt_ID"));
                bt.setBt_Name(rs.getString("bt_Name"));
                bt.setBt_RID(rs.getString("bt_RID"));
                bt.setBt_Time(rs.getInt("bt_Time"));
                bookType.add(bt);
            }
            return bookType;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public ArrayList<Books> findBooks(String bt_ID) {
        ArrayList<Books> listBooks = new ArrayList<Books>();
        Books bk = null;
        conn = getConn();
        sql = "select * from Books where bt_ID =?";
        try {
            prestat = conn.prepareStatement(sql);
            prestat.setString(1, bt_ID);
            rs = prestat.executeQuery();
            while (rs.next()) {
                bk = new Books();
                bk.setBk_ID(rs.getString("bk_ID"));
                bk.setBk_Name(rs.getString("bk_Name"));
                bk.setBk_Author(rs.getString("bk_Author"));
                bk.setBk_Price(rs.getDouble("bk_Price"));
                bk.setBk_Count(rs.getInt("bk_Count"));
                bk.setBk_State(rs.getInt("bk_State"));
                listBooks.add(bk);
            }
            return listBooks;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int countBooks(String bt_ID) {
        int count = 0;
        sql = "select count(*) as bk_Count from(select t.*,rownum rn FROM(select *from Books where bt_ID = ?)t)";
        conn = getConn();
        try {
            prestat = conn.prepareStatement(sql);
            prestat.setString(1, bt_ID);
            rs = prestat.executeQuery();
            while (rs.next()) {
                count = rs.getInt("bk_Count");
                return count;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public Books getBook(String type) {

        int bk_Count = countBooks(type);
        if (bk_Count != 0) {
            int pages = bk_Count / 5 + 1;
            for (int i = 1; i <= pages + 1 && i >= 0; ) {
                GetData gd = new GetData();
                ArrayList<Books> bookList = findBooks(type, i);
                if (i == pages + 1 || i == 0) {
                    System.out.println("��ǰҳ������,��ת����ҳ");
                    i = 1;
                } else {
                    System.out.println("-------------------------------listBook------------------------------------");
                    for (int j = 0; j < bookList.size(); j++) {
                        System.out.println((j + 1) + "." + bookList.get(j).getBk_Name());
                    }
                    System.out.println("N  ��һҳ\t\tP  ��һҳ");
                    String cmd = gd.getData();
                    if (cmd.matches("[Pp]")) {
                        i--;
                    } else if (cmd.matches("[Nn]")) {
                        i++;
                    } else if (cmd.matches("[1-5]")) {
                        return bookList.get(Integer.parseInt(cmd) - 1);
                    }
                }
            }
        }
        return null;
    }

    public ArrayList<Books> findBooks(String bt_ID, int currentPage) {
        String sql = "select * from (select t.*,rownum rn from(select * from books where bt_ID = ?)t)where rn>=? and rn <=?";
        int start = (currentPage - 1) * 5 + 1;//��ǰҳ����ʼֵ
        int end = currentPage * 5;//��ǰҳ�Ľ���ֵ
        conn = getConn();
        try {
            prestat = conn.prepareStatement(sql);
            prestat.setString(1, bt_ID);
            prestat.setInt(2, start);
            prestat.setInt(3, end);
            rs = prestat.executeQuery();
            ArrayList<Books> books = new ArrayList<>();
            boolean flag = false;
            while (rs.next()) {
                flag = true;
                Books book = new Books();
                book.setBk_ID(rs.getString(1));
                book.setBk_Name(rs.getString(2));
                book.setBk_Author(rs.getString(3));
                book.setBk_Price(rs.getDouble(4));
                book.setBk_Count(rs.getInt(5));
                book.setBk_State(rs.getInt(6));
                book.setBt_ID(rs.getString(7));
                books.add(book);
            }
            if (flag) {
                return books;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll();
        }
        return null;
    }
}




    /*
    public ArrayList<Books> findBorrowBook(Users user){
        String sql ="SELECT * from books where bk_id IN(SELECT bk_id from borrowInfo WHERE br_id IN(SELECT br_id FROM borrow WHERE user_id=?)) ";
        conn = getConn();
        try {
            prestat =conn.prepareStatement(sql);
            prestat.setString(1,user.getUser_ID());
            rs = prestat.executeQuery();
            ArrayList<Books> books = new ArrayList<>();
            boolean flag = false;
            while (rs.next()){
                flag = true;
                Books book = new Books();
                book.setBk_ID(rs.getString(1));
                book.setBk_Name(rs.getString(2));
                book.setBk_Author(rs.getString(3));
                book.setBk_Price(rs.getDouble(4));
                book.setBk_Count(rs.getInt(5));
                book.setBk_State(rs.getInt(6));
                book.setBt_ID(rs.getString(7));
                books.add(book);
            }
            if(flag){
                return books;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }


    public int addBooks(File file){
        conn = getConn();
        BufferedReader bufr = null;
        try {
            stat = conn.createStatement();
            bufr = new BufferedReader(new FileReader(file));
            String line;
            while (null!=(line = bufr.readLine())){
                String bk_ID = new RandID().getID(RandID.BookID);
                stat.addBatch("insert into Books VALUES ('"+bk_ID+"',line,)");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public ArrayList<String> getBookBigType(){
        conn = getConn();
        sql = "select bt_Name from bookType";
        ArrayList<String> bg_Type = new ArrayList<String>();
        try {
            prestat = conn.prepareStatement(sql);
            rs = prestat.executeQuery();
            while (rs.next()){
                bg_Type.add(rs.getString("bt_Name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public Books findBooks(String bt_Name){
        sql = "select * from Books where bt_Name = ?";
        conn = getConn();
        try {
            prestat = conn.prepareStatement(sql);
            prestat.setString(1,bt_Name);
            rs = prestat.executeQuery();
            if (rs.next()){
                Books book = new Books();
                book.setBk_ID(rs.getString("bk_ID"));
                book.setBk_Name(rs.getString("bk_Name"));
                book.setBk_Author(rs.getString("bk_Author"));
                book.setBk_Price(rs.getDouble("bk_Price"));
                book.setBk_Count(rs.getInt("bt_Count"));
                book.setBt_ID(rs.getString("bt_ID"));
                book.setBk_State(rs.getInt("bt_State"));
                return book;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public ArrayList<String> findBookType(){//����ͼ����࣬�鵽����ͼ������bt_Name
        String sql = "select * from bookType where bt_rid = 0";
        conn = getConn();
        try {
            prestat = conn.prepareStatement(sql);
            rs= prestat.executeQuery();
            ArrayList<String> bookTypes = new ArrayList<>();
            boolean flag = false;//�������while���ʾ�н�����ٷ��ؽ�������û�з���null
            while (rs.next()){
                flag = true;
                bookTypes.add(rs.getString("bt_Name"));
            }
            if (flag){
                return bookTypes;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeAll();
        }

        return null;
    }*/

/*public ArrayList<String> listBookType(String type){//�ҳ�ͼ������е�С�ࡣͨ����RID����
        ArrayList<String> listType = new ArrayList<>();
        conn = getConn();
        sql = "select BT_ID from BookType where bt_RID =?";
        try {
            prestat = conn.prepareStatement(sql);
            prestat.setString(1,type);
            rs = prestat.executeQuery();
            while (rs.next()){
                listType.add(rs.getString("bt_Name"));
            }
            return listType;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }*/
    /*conn = getConn();
        sql = "select * from bookType where bt_RID = ?";
        ArrayList<BookType> bookType = new ArrayList<BookType>();
        BookType bt = new BookType();
        try {
            prestat = conn.prepareStatement(sql);
            prestat.setString(1,bt_RID);
            rs = prestat.executeQuery();
            while (rs.next()){
                bt.setBt_ID(rs.getString("bt_ID"));
                bt.setBt_Name(rs.getString("bt_Name"));
                bt.setBt_RID(rs.getString("bt_RID"));
                bt.setBt_Time(rs.getInt("bt_Time"));
                bookType.add(bt);
            }
            return bookType;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeAll();
        }*/