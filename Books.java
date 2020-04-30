public class Books {

    private String bookTitle;
    private String bookAuthor;
    private int bookPublished;

    public Books(String title, String author, int bookPublished) {
        this.bookTitle = title;
        this.bookAuthor = author;
        this.bookPublished = bookPublished;
    }

    public String toString() {
        return "Title: " + bookTitle + "\n" + "Author: " + bookAuthor + "\n" + "Publish Date: " + bookPublished + "\n";
    }
}