package org.example;

import java.util.ArrayList;
import java.util.List;

public final class Library {
    private final List<Book> library = new ArrayList<>();

    public boolean add(Book book) {
        if (!library.contains(book)) {
            library.add(book);
            return true;
        }
        else return false;
    }

    public boolean delete(Book book) {
        boolean flag = library.contains(book);
        if (flag) library.remove(book);
        return flag;
    }

    public boolean change(Book one, Book another) {
        if (library.contains(one)) {
            int i = library.indexOf(one);
            library.set(i, another);
            return true;
        }
        else return false;
    }

    public boolean move(Book book, String code) {
        if (!code.matches("[А-Я]\\d+"))
            throw new IllegalArgumentException("Wrong format of code");
        if (library.contains(book)) {
            book.setCode(code);
            return true;
        }
        else return false;
    }

    public List<Book> searchByAuthor(String author) {
        List<Book> out = new ArrayList<>();
        for (Book book: library) {
            if (book.getAuthor().equals(author)) out.add(book);
        }
        return out;
    }

    public List<Book> searchByGenre(String genre) {
        List<Book> out = new ArrayList<>();
        for (Book book: library) {
            if (book.getGenre().equals(genre)) out.add(book);
        }
        return out;
    }

    public Book searchByCode(String code) {
        if (!code.matches("[А-Я]\\d+"))
            throw new IllegalArgumentException("Wrong format of code");
        Book found = new Book("", "", "", "");
        for (Book book: library) {
            if (book.getCode().equals(code)) found = book;
        }
        return found;
    }

    public List<Book> searchByTitle(String title) {
        List<Book> out = new ArrayList<>();
        for (Book book: library) {
            if (book.getTitle().equals(title)) out.add(book);
        }
        return out;
    }

    public List<Book> searchByString(String string) {
        List<Book> out = new ArrayList<>();
        for (Book book: library) {
            if (book.getTitle().toLowerCase().contains(string.toLowerCase())) out.add(book);
        }
        return out;
    }

    public List<Book> getLibrary() {
        return library;
    }


    public boolean equals(Library another) {
        if (this.getLibrary().size() != another.getLibrary().size()) return false;
        boolean flag = true;
        for (Book book: this.getLibrary()) {
            if (!another.getLibrary().contains(book)) {
                flag = false;
                break;
            }
        }
        return flag;
    }
}
