/*
 * Copyright (c) 2020. SQTX
 *
 * Copyright © 2020 SQTX. All rights reserved.
 */

package pl.library.app;

import pl.library.model.Book;

public class Library {
    public static void main(String[] args) {
        final String appName = "Library v0.7";

//        Tworzymy obiekt zkładający się z tablicy (pojemność tablicy to 1000 obiektów books)
        Book [] books = new Book[1000];
//        Przypisujemy książki do poszczególnych tablic
        books[0] = new Book("W pustyni i w puszczy", "Henryk Sienkiewicz", 2010,
                296, "Greg");
        books[1] = new Book("Java. Podstawy. Wydanie XI", "Cay S. Horstmann", 2019,
                768, "Helion", "9788328357785");
        books[2] = new Book("Sztuka podstępu. Łamałem ludzi, nie hasła. Wydanie II",
                "Kevin Mitnick, William L. Simon, Steve Wozniak", 2010, 384,
                "Helion", "9788328331372");

        System.out.println(appName+"\n");
        System.out.println("W bibliotece są ksiązki: ");
//        Metody odpowiedzialne za wypisanie informacji o książkach
        books[0].printInfo();
        books[1].printInfo();
        books[2].printInfo();
//        Pojemność naszego systemu - informacja
        System.out.println("System może pomieścić do " + books.length + " książek.");
    }
}
