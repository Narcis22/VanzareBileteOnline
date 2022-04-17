package event;

import java.util.List;

public class BookSigning extends Event{

    public String author;
    public String bookTitle;
    public Boolean hasBookRead;

    public BookSigning(String eventName, Location eventLocation, String author, String bookTitle, Boolean hasBookRead) {
        super(eventName, eventLocation);
        this.author = author;
        this.bookTitle = bookTitle;
        this.hasBookRead = hasBookRead;
    }

    public String getAuthor() {
        return author;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public Boolean getHasBookRead() {
        return hasBookRead;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public void setHasBookRead(Boolean hasBookRead) {
        this.hasBookRead = hasBookRead;
    }

    @Override
    public String toString() {
        return "BookSigning{" +
                "author='" + author + '\'' +
                ", bookTitle='" + bookTitle + '\'' +
                ", hasBookRead=" + hasBookRead +
                ", eventName='" + eventName + '\'' +
                ", eventLocation=" + eventLocation +
                '}';
    }
}
