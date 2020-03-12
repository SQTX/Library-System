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

    //    Alternatywa dla tworzenia nowego obiektu DataReader
    private ConsolePrinter printer;
    public DataReader(ConsolePrinter printer) {
        this.printer = printer;
    }

    //    Tworzenie książki
    public Book readAndCreateBook(){
        printer.printLine("Tytuł: ");
        String title = sc.nextLine();
        printer.printLine("Autor: ");
        String author = sc.nextLine();
        printer.printLine("Wydawnictwo: ");
        String publisher = sc.nextLine();
        printer.printLine("Rok wydania : ");
        int releaseDate = getInt();
        printer.printLine("Liczba stron: ");
        int pages = getInt();
        printer.printLine("ISBN: ");
        String isbn = sc.nextLine();

        return new Book(title,author,releaseDate,pages,publisher,isbn);
    }

//    Tworzenie magazynu
    public Magazine readAndCreateMagazine(){
        printer.printLine("Tytuł: ");
        String title = sc.nextLine();
        printer.printLine("Wydawnictwo: ");
        String publisher = sc.nextLine();
        printer.printLine("Język: ");
        String language = sc.nextLine();
        printer.printLine("Rok wydania : ");
        int year = getInt();
        printer.printLine("Miesiąc: ");
        int month = getInt();
        printer.printLine("Dzień: ");
        int day = getInt();

        return new Magazine(title, publisher, language, year, month, day);
    }

//    Pobieranie wybraniej opcji
    public int getInt(){
        try {
            return sc.nextInt();
        } finally {
            sc.nextLine();
        }
    }

//    Zamykanie systemu pobierania danych
    public void scClose(){
        sc.close();
    }

}
