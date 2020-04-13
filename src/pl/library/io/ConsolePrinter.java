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
        int countBooks = 0;
        for (Publication publication: publications){
            if(publication instanceof Book) {
                printNLine("Książka nr. " + (++countBooks));
                printNLine(((Book) publication).toString());
            }
        }
        if(countBooks==0){
            printNLine("Brak książek w bibliotece.");
        }
    }

//    Metoda odpowiedzialna za rozpoznanie czy są jakies magazynów i wyświetlenie ich wszystkich w zwartej liście
    public void printMagazine(Collection<Publication> publications) {
        int countMagazine = 0;
        for (Publication publication: publications){
            if(publication instanceof Magazine){
                printNLine("Magazyn nr. "+(++countMagazine));
                printNLine(((Magazine)publication).toString());
            }
        }
        if (countMagazine == 0) {
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
