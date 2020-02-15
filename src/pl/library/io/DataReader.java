/*
 * Copyright (c) 2020. SQTX
 *
 * Copyright © 2020 SQTX. All rights reserved.
 */

package pl.library.io;

import java.util.Scanner;
import pl.library.model.Book;
import pl.library.model.Magazine;

public class DataReader {
    private Scanner sc = new Scanner(System.in);

//    Tworzenie książki
    public Book readAndCreateBook(){
        System.out.print("Tytuł: ");
        String title = sc.nextLine();
        System.out.print("Autor: ");
        String author = sc.nextLine();
        System.out.print("Wydawnictwo: ");
        String publisher = sc.nextLine();
        System.out.print("Rok wydania : ");
        int releaseDate = getInt();
        System.out.print("Liczba stron: ");
        int pages = getInt();
        System.out.print("ISBN: ");
        String isbn = sc.nextLine();

        return new Book(title,author,releaseDate,pages,publisher,isbn);
    }

//    Tworzenie magazynu
    public Magazine readAndCreateMagazine(){
        System.out.print("Tytuł: ");
        String title = sc.nextLine();
        System.out.print("Wydawnictwo: ");
        String publisher = sc.nextLine();
        System.out.print("Język: ");
        String language = sc.nextLine();
        System.out.print("Rok wydania : ");
        int year = getInt();
        System.out.print("Miesiąc: ");
        int month = getInt();
        System.out.print("Dzień: ");
        int day = getInt();

        return new Magazine(title, publisher, language, year, month, day);
    }

//    Pobieranie wybraniej opcji
    public int getInt(){
        int number = sc.nextInt();
        sc.nextLine();
        return number;
    }

//    Zamykanie systemu pobierania danych
    public void scClose(){
        sc.close();
    }
}
