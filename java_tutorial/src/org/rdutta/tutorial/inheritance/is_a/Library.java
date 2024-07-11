package org.rdutta.tutorial.inheritance.is_a;

import java.util.Date;
import java.util.UUID;

public class Library {
    private UUID book_code;
    private String bookName;
    private String author;
    private Date publishedDate;

    public Library() {}

    public Library(UUID book_code, String bookName, String author, Date publishedDate) {
        this.book_code = book_code;
        this.bookName = bookName;
        this.author = author;
        this.publishedDate = publishedDate;
    }

    public UUID getBook_code() {
        if (this.book_code == null) {
            this.book_code = UUID.randomUUID();
        }
        return book_code;
    }

    public String getBookName() {
        if (this.bookName == null) {
            this.bookName = "Physics";
        }
        return bookName;
    }

    public String getAuthor() {
        if (this.author == null) {
            this.author = "H.C Verma";
        }
        return author;
    }

    public Date getPublishedDate() {
        if (this.publishedDate == null) {
            this.publishedDate = new Date();
        }
        return publishedDate;
    }
}
