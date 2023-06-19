package Books;

import Mysql.Connections;

import java.util.Scanner;

public class BookSystemRun {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        BookManager book = new BookManager();

        boolean flag = true;

        int temp = 0;

        while (flag) {
            if(temp == 0) {
                System.out.println("请输入用户名：");
                String userName = sc.next();
                System.out.println("请输入密码：");
                String password = sc.next();
                if(!("root".equals(userName) && "2333".equals(password))) {
                    System.out.println("账户名或密码错误!");
                    continue;
                }
                temp = 1;
            }

            //界面
            System.out.println("------------");
            System.out.println("欢迎来到图书管理系统");
            System.out.println("0 显示全部图书");
            System.out.println("1 按名搜索图书");
            System.out.println("2 增加图书");
            System.out.println("3 修改图书");
            System.out.println("4 删除图书");
            System.out.println("5 退出");
            System.out.println("------------");
            System.out.println("请选择：");

            int choice = sc.nextInt();
            //   try/catch
            try {
                if(choice == 5){
                    System.out.println("您已退出该系统");
                    flag = false;
                }
                else
                    book.Manage(choice);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        sc.close();
    }
}
