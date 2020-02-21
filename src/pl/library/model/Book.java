/*
 * Copyright (c) 2020. SQTX
 *
 * Copyright © 2020 SQTX. All rights reserved.
 */

package pl.library.model;

//cechy obiektu Książka
public class Book extends Publication{

    private String author;
    private int pages;
    private String isbn;

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

//    Metoda odpowiedzialna za wypisanie zapisanych informacji o danej książce
    public void printInfo(){
        String info ="\""+getTitle()+"\""+"\n"+author+"\n"+ getYear()+"\n"+getPublisher();

//        Warunek sprawdzający czy podano jakiś numer isbn czy nie, jeżeli tak to jest wyświetlony
        if (isbn != null){
            System.out.println(info +"\n"+ isbn);
        } else {
            System.out.println(info);
        }
    }
}
