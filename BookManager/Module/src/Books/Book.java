package Books;

public class Book {
    private int num;
    private String name;
    private String author;

    public Book() {
    }

    public Book( String name, String author ,int num) {
        this.num = num;
        this.name = name;
        this.author = author;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String toString() {
        return "书名：" + name + " 作者：" + author + " 库存量：" + num;
    }
}
