package org.example;

import java.util.ArrayList;
import java.util.List;

public final class Library {
    private final List<Book> libraryList = new ArrayList<>();

    public boolean add(Book book) {
        if (!libraryList.contains(book)) {
            libraryList.add(book);
            return true;
        }
        else return false;
    }

    public boolean delete(Book book) {
        boolean flag = libraryList.contains(book);
        if (flag) libraryList.remove(book);
        return flag;
    }

    public boolean change(Book one, Book another) {
        if (libraryList.contains(one)) {
            int i = libraryList.indexOf(one);
            libraryList.set(i, another);
            return true;
        }
        else return false;
    }

    public boolean move(Book book, String code) {
        if (!code.matches("[А-Я]\\d+"))
            throw new IllegalArgumentException("Wrong format of code");
        if (libraryList.contains(book)) {
            book.setCode(code);
            return true;
        }
        else return false;
    }

    public List<Book> searchByAuthor(String author) {
        List<Book> out = new ArrayList<>();
        for (Book book: libraryList) {
            if (book.getAuthor().equals(author)) out.add(book);
        }
        return out;
    }

    public List<Book> searchByGenre(String genre) {
        List<Book> out = new ArrayList<>();
        for (Book book: libraryList) {
            if (book.getGenre().equals(genre)) out.add(book);
        }
        return out;
    }

    public Book searchByCode(String code) {
        if (!code.matches("[А-Я]\\d+"))
            throw new IllegalArgumentException("Wrong format of code");
        Book found = new Book("", "", "", "");
        for (Book book: libraryList) {
            if (book.getCode().equals(code)) found = book;
        }
        return found;
    }

    public List<Book> searchByTitle(String title) {
        List<Book> out = new ArrayList<>();
        for (Book book: libraryList) {
            if (book.getTitle().equals(title)) out.add(book);
        }
        return out;
    }

    public List<Book> searchByString(String string) {
        List<Book> out = new ArrayList<>();
        for (Book book: libraryList) {
            if (book.getTitle().toLowerCase().contains(string.toLowerCase())) out.add(book);
        }
        return out;
    }

    public List<Book> getLibraryList() {
        return libraryList;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj instanceof Library) {
            Library another = (Library) obj;
            boolean flag = this.getLibraryList().size() == another.getLibraryList().size();
            for (Book book: this.getLibraryList()) {
                if (!another.getLibraryList().contains(book)) {
                    flag = false;
                    break;
                }
            }
            return flag;
        }
        else return false;
    }


}
