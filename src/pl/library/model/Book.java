/*
 * Copyright (c) 2020. SQTX
 *
 * Copyright © 2020 SQTX. All rights reserved.
 */

package pl.library.model;

import java.util.Objects;

//cechy obiektu Książka
public class Book extends Publication{
    private String author;
    private int pages;
    private String isbn;

//    Konstruktor odpowiedzialny za tworzenie obiektu Książka
    public Book(String title, String author, int year, int pages, String publisher) {
//        Informacje podane w Liblary.java zostają tu przeniesione i zapisane w chechach obiektu książka
        super(title, publisher, year);
        this.author = author;
        this.pages = pages;

    }
//    Konstruktor z numerem ISBN
    public Book(String title, String author, int year, int pages, String publisher,
         String isbn) {
        this(title, author, year, pages, publisher);
        this.isbn = isbn;
    }

//    gettery i settery
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPages() {
        return pages;
    }
    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

//    toString przesyła dane w postaci wiadomości do wyświetlenia
    @Override
    public String toString() {
        String info ="\""+getTitle()+"\""+"\n"+author+"\n"+ getYear()+"\n"+getPublisher();

//        Warunek sprawdzający czy podano jakiś numer isbn czy nie, jeżeli tak to jest wyświetlony
        if (isbn != null){
            return(info +"\n"+ isbn);
        } else {
            return info;
        }
    }

//    equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Book book = (Book) o;
        return pages == book.pages &&
                Objects.equals(author, book.author) &&
                Objects.equals(isbn, book.isbn);
    }

//    hashCode
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), author, pages, isbn);
    }
}
