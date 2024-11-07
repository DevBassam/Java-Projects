package org.example;

public class Book {

    private final int isbn;
    private final String title;
    private final String author;
    private final String genre;
    private final String publishDate;
    private final int availableCopies;

    public Book(int isbn,String title, String author, String genre, String publishDate, int availableCopies) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.publishDate = publishDate;
        this.availableCopies = availableCopies;
    }
    @Override
    public String toString() {
        return "{" +
                "isbn=" + isbn +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                ", publishDate='" + publishDate + '\'' +
                ", availableCopies=" + availableCopies +
                '}';
    }
}
