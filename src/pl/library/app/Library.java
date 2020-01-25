/*
 * Copyright (c) 2020. SQTX
 *
 * Copyright © 2020 SQTX. All rights reserved.
 */

package pl.library.app;

import pl.library.io.DataReader;
import pl.library.model.Book;

public class Library {
    public static void main(String[] args) {
        final String appName = "Library v0.8";

//        Tworzymy obiekt zkładający się z tablicy (pojemność tablicy to 1000 obiektów books)
        Book [] books = new Book[1000];

//        Tworzenie obiektu poprzez metdę readAndCreateBook
        DataReader dataReader = new DataReader();
        books[0] = dataReader.readAndCreateBook();
        books[1] = dataReader.readAndCreateBook();

        System.out.println(appName+"\n");
        System.out.println("W bibliotece są książki: ");

//        Metody odpowiedzialne za wypisanie informacji o książkach
        books[0].printInfo();
        books[1].printInfo();
//        Metoda zamknięcia przekazu danych
        dataReader.scClose();

//        Pojemność naszego systemu - informacja
        System.out.println("System może pomieścić do " + books.length + " książek.");
    }
}
