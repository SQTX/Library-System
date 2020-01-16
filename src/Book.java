/*
 * Copyright © 2020 SQTX. All rights reserved.
 */

//cechy obiektu Książka
public class Book {
    String title;
    String author;
    int releaseDate;
    int pages;
    String publisher;
    String isbn;

//  Konstruktor odpowiedzialny za tworzenie obiektu Książka
    Book(String title, String author, int releaseDate, int pages, String publisher) {
//      Informacje podane w Liblary.java zostają tu przeniesione i zapisane w chechach obiektu książka
        this.title = title;
        this.author = author;
        this.releaseDate = releaseDate;
        this.pages = pages;
        this.publisher = publisher;
    }
//  Konstruktor z numerem ISBN
    Book(String title, String author, int releaseDate, int pages, String publisher,
         String isbn) {
        this(title, author, releaseDate, pages, publisher);
        this.isbn = isbn;
    }

//  Metoda odpowiedzialna za wypisanie zapisanych informacji o danej książce
    void printInfo(){
        String info =title+"\n"+author+"\n"+releaseDate+"\n"+publisher+"\n"+isbn+"\n";
        System.out.println(info);
    }
}
