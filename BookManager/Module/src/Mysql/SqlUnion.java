package Mysql;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


import Books.Book;

//数据库操作
public class SqlUnion {

    //判断书籍是否已经存在
    public boolean Judge(String TargetName) {
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement pstate = null;
        int count = 0;
        try {
            conn = Connections.getConn();
            String sql = "select * from book where book_name =?";
            pstate = conn.prepareStatement(sql);
            pstate.setString(1, TargetName);
            rs = pstate.executeQuery();
            while (rs.next()) {
                count = rs.getInt(3);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Connections.closeconn(conn, pstate, rs);
        }
        return count != 0;
    }

    //获取所有书籍
    public List<Book> GetAllBooks() {
        Connection conn = null;
        Statement state = null;
        ResultSet rs = null;
        List<Book> book = new ArrayList<>();
        try {
            conn = Connections.getConn();
            String sql = "select * from book";
            state = conn.createStatement();
            rs = state.executeQuery(sql);
            while (rs.next()) {
                String book_name = rs.getString(1);
                String book_author = rs.getString(2);
                int book_num = rs.getInt(3);
                Book boo = new Book(book_name, book_author, book_num);
                book.add(boo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Connections.closeconn(conn, state, rs);
        }
        return book;
    }

    //查找书籍
    public Book Find(String TargetName) {
        Connection conn = null;
        PreparedStatement state = null;
        ResultSet rs = null;
        Book boo = new Book();
        try {
            conn = Connections.getConn();
            String sql = "select * from book where book_name =?";
            state = conn.prepareStatement(sql);
            state.setString(1, TargetName);
            rs = state.executeQuery();
            while (rs.next()) {
                boo.setName(rs.getString("book_name"));
                boo.setAuthor(rs.getString("book_author"));
                boo.setNum(rs.getInt("book_num"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Connections.closeconn(conn, state, rs);
        }
        return boo;
    }

    //增加书籍
    public void Add(Book boo) {
        Connection conn = null;
        PreparedStatement state = null;
        try {
            conn = Connections.getConn();
            String sql = "insert into book values(?,?,?)";
            state = conn.prepareStatement(sql);
            state.setString(1, boo.getName());
            state.setString(2, boo.getAuthor());
            state.setInt(3, boo.getNum());
            state.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Connections.closeconn(conn, state);
        }

    }

    //修改书籍
    public void Modify(String TargetName, Book boo) {
        Connection conn = null;
        PreparedStatement state = null;
        try {
            conn = Connections.getConn();
            String sql = "update book set book_name =? , book_author =? , book_num =? where book_name =?";
            state = conn.prepareStatement(sql);
            state.setString(1, boo.getName());
            state.setString(2, boo.getAuthor());
            state.setInt(3, boo.getNum());
            state.setString(4, TargetName);
            state.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Connections.closeconn(conn, state);
        }
    }

    //删除书籍
    public void Delete(String TargetName){
        Connection conn = null;
        PreparedStatement state = null;
        try {
            conn = Connections.getConn();
            String sql = "delete from book where book_name =?";
            state = conn.prepareStatement(sql);
            state.setString(1, TargetName);
            state.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        } finally{
            Connections.closeconn(conn , state);
        }

    }
}

