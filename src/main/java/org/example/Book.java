package org.example;

public final class Book {
    private final String title;
    private final String author;
    private final String genre;
    private String code;

    Book(String title, String author, String genre, String code) {
        if (!code.matches("[А-Я]\\d+"))
            throw new IllegalArgumentException("Wrong format of code");
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
        if (!code.matches("[А-Я]\\d+"))
            throw new IllegalArgumentException("Wrong format of code");
        this.code = code;
    }

    public Book toBook(String s) {
        if (!s.matches("[А-я ]+, [А-я ]+, [А-я ]+, [А-я]\\d+"))
            throw new IllegalArgumentException("String inconvertible to Book");
        String title = s.split(", ")[0];
        String author = s.split(", ")[1];
        String genre = s.split(", ")[2];
        String code = s.split(", ")[3];
        return new Book(title, author, genre, code);
    }

    @Override
    public String toString() {
        return title + ", " + author + ", " + genre + ", " + code;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj instanceof Book) {
            Book another = (Book) obj;
            return this.title.equals(another.title)
                    && this.author.equals(another.author)
                    && this.genre.equals(another.genre)
                    && this.code.equals(another.code);
        } else return false;
    }
}
