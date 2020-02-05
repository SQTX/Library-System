/*
 * Copyright (c) 2020. SQTX
 *
 * Copyright © 2020 SQTX. All rights reserved.
 */

package pl.library.model;

public class Library{
    private final static int MAX_BOOKS = 1000;
    private Book [] books = new Book[MAX_BOOKS];
    private int booksNumber = 0;

//    Metoda odpowiedzialna za sprawdzenie czy limit książek nie został przekroczony oraz dodanie nowej książki
    public void addBook(Book book){
        if(booksNumber< MAX_BOOKS){
            books[booksNumber] = book;
            booksNumber++;
        }else{
            System.out.println("Bioblioteka jest przepełniona.");
        }
    }

//    Metoda odpowiedzialna za rozpoznanie czy są jakies książki i wyświetlenie ich wszystkich w zwartej liście
    public void printBooks() {
        if (booksNumber == 0) {
            System.out.println("Brak książek");
        }
        for (int i=0;i<booksNumber;i++){
            System.out.println("Książka nr. "+(i+1));
            books[i].printInfo();
        }
    }
}
