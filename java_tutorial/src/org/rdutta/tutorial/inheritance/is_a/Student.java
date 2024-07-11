package org.rdutta.tutorial.inheritance.is_a;

import java.util.Date;
import java.util.UUID;

public class Student extends Library {
    private UUID student_UID;
    private String name;

    public Student() {
        this.student_UID = UUID.randomUUID();
        this.name = "Raj";
    }

    public Student(UUID book_code, String bookName, String author, Date publishedDate, UUID student_UID, String name) {
        super(book_code, bookName, author, publishedDate);
        this.student_UID = student_UID;
        this.name = name;
    }

    public UUID getStudent_UID() {
        return student_UID;
    }

    public void setStudent_UID(UUID student_UID) {
        this.student_UID = student_UID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void readingTheBook(UUID book_UID, UUID student_UID) {
        System.out.println("Book " + book_UID + " is currently occupied by Student with ID: " + student_UID);
    }

    public boolean keptTheBook(UUID book_UID, String shelf) {
        return book_UID != null && shelf != null;
    }

    public static void main(String[] args) {
        Student stdObject = new Student();
        UUID book_UID = stdObject.getBook_code();
        stdObject.readingTheBook(book_UID, stdObject.getStudent_UID());

        if (!stdObject.keptTheBook(book_UID, stdObject.getAuthor())) {
            System.out.println(stdObject.getName() + " Still Reading!!");
        } else {
            System.out.println("Done!");
        }
    }
}
