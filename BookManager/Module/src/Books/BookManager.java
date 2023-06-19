package Books;

import Mysql.SqlUnion;

import java.util.List;
import java.util.Scanner;


public class BookManager {
    Scanner sc = new Scanner(System.in);

    public void Manage(int choice) throws Exception {
        switch (choice) {
            case 0:
                findallbooks();
                break;
            case 1:
                search();
                break;
            case 2:
                add();
                break;
            case 3:
                modify();
                break;
            case 4:
                delete();
                break;
            default:
                throw new Exception("没有该功能，请重新选择！");

        }
    }

    //展示所有书籍的信息
    public void findallbooks() {
        SqlUnion sql = new SqlUnion();
        List<Book> list = sql.GetAllBooks();
        System.out.println("以下是所有图书的信息");
        for (Book boo : list) {
            System.out.println(boo);
        }
    }

    //增加书籍
    public void add() {
        SqlUnion sql = new SqlUnion();
        System.out.println("请输入要添加的书籍名字");
        String name = sc.next();
        if (sql.Judge(name)) {
            System.out.println("该图书已存在！");
        } else {
            System.out.println("请输入作者名");
            String author = sc.next();
            System.out.println("请输入数量");
            int num = sc.nextInt();
            sql.Add(new Book(name, author, num));
            System.out.println("添加成功！");
        }
    }

    //查找书籍
    public void search() {
        SqlUnion sql = new SqlUnion();
        System.out.println("请输入要查找的书籍的名字");
        String name = sc.next();
        if (!sql.Judge(name)) {
            System.out.println("您查找的书籍不存在");
        } else {
            Book boo = sql.Find(name);
            System.out.println(boo);
        }
    }

    //删除书籍
    public void delete() {
        SqlUnion sql = new SqlUnion();
        System.out.println("请输入要删除的书籍的名字");
        String name = sc.next();
        if (!sql.Judge(name)) {
            System.out.println("该书籍不存在");
        } else {
            sql.Delete(name);
            System.out.println("删除成功");
        }
    }

    //修改书籍
    public void modify() {
        SqlUnion sql = new SqlUnion();
        System.out.println("请输入要修改的书籍名字");
        String name = sc.next();
        if (!sql.Judge(name)){
            System.out.println("该书籍不存在");
        }else {
            System.out.println("请重新输入书籍名字");
            String names = sc.next();
            System.out.println("请输入书籍作者");
            String author = sc.next();
            System.out.println("请输入书籍数量");
            int num = sc.nextInt();
            sql.Modify(name , new Book(names , author , num));
            System.out.println("修改成功");
        }
    }
}
