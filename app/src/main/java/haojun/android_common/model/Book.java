package haojun.android_common.model;

public class Book {
    private String id;
    private String title;
    private int price;
    private String createDate;

    public Book(String id, String title, int price, String createDate) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.createDate = createDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
}

