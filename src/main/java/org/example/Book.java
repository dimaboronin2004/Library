package org.example;

public final class Book {
    private final String title;
    private final String author;
    private final String genre;
    private String code;

    Book(String title, String author, String genre, String code) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.code = code;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
