/*
 * Copyright (c) 2020. SQTX
 *
 * Copyright © 2020 SQTX. All rights reserved.
 */

package pl.library.io;

import pl.library.model.*;
import java.util.Collection;

public class ConsolePrinter {

    //    Metoda odpowiedzialna za rozpoznanie czy są jakies książki i wyświetlenie ich wszystkich w zwartej liście
    public void printBooks(Collection<Publication> publications) {
        long count = publications.stream()  //Tworzymy strumień
                .filter(p -> p instanceof Book) //Sprawdzamy czy to książki
                .map(Object::toString)  //Zamieniamy publikacje na Stringi
                .peek(this::printNLine) //Wyświetlamy daną publikację
                .count();   //Zlaiczamy liczbę publikacji

        if(count==0){
            printNLine("Brak książek w bibliotece.");
        }


    }

//    Metoda odpowiedzialna za rozpoznanie czy są jakies magazynów i wyświetlenie ich wszystkich w zwartej liście
    public void printMagazine(Collection<Publication> publications) {
        long count = publications.stream()
                .filter(p -> p instanceof Magazine)
                .map(Object::toString)
                .peek(this::printNLine)
                .count();
        if (count == 0) {
            printNLine("Brak magazynów w bibliotece.");
        }
    }

    public void printUsers(Collection<LibraryUser> users){
        for(LibraryUser user: users){
            printNLine(user.toString());
        }
    }

//    Wyświetlacze wartości string na consoli
    public void printLine(String text){
        System.out.print(text);
    }

    public void printNLine(String text){
        System.out.println(text);
    }
}
