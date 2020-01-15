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
    Book(String bookTitle, String bookAuthor, int bookReleaseDate, int bookPages, String bookPublisher,
         String bookIsbn) {
//      Informacje podane w Liblary.java zostają tu przeniesione i zapisane w chechach obiektu książka
        title = bookTitle;
        author = bookAuthor;
        releaseDate = bookReleaseDate;
        pages = bookPages;
        publisher = bookPublisher;
        isbn = bookIsbn;
    }
//  Metoda odpowiedzialna za wypisanie zapisanych informacji o danej książce
    void printInfo(){
        String info =title+"\n"+author+"\n"+releaseDate+"\n"+publisher+"\n"+isbn+"\n";
        System.out.println(info);

    }
}
