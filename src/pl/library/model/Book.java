/*
 * Copyright (c) 2020. SQTX
 *
 * Copyright © 2020 SQTX. All rights reserved.
 */

package pl.library.model;

//cechy obiektu Książka
public class Book {
    private String title;
    private String author;
    private int releaseDate;
    private int pages;
    private String publisher;
    private String isbn;

//  gettery i settery
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(int releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

//  Konstruktor odpowiedzialny za tworzenie obiektu Książka
    public Book(String title, String author, int releaseDate, int pages, String publisher) {
//      Informacje podane w Liblary.java zostają tu przeniesione i zapisane w chechach obiektu książka
        this.title = title;
        this.author = author;
        this.releaseDate = releaseDate;
        this.pages = pages;
        this.publisher = publisher;
    }
//  Konstruktor z numerem ISBN
    public Book(String title, String author, int releaseDate, int pages, String publisher,
         String isbn) {
        this(title, author, releaseDate, pages, publisher);
        this.isbn = isbn;
    }

//  Metoda odpowiedzialna za wypisanie zapisanych informacji o danej książce
    public void printInfo(){
        String info =title+"\n"+author+"\n"+releaseDate+"\n"+publisher+"\n"+isbn+"\n";
        System.out.println(info);
    }
}