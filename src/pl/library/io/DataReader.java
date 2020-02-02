/*
 * Copyright (c) 2020. SQTX
 *
 * Copyright © 2020 SQTX. All rights reserved.
 */

package pl.library.io;

import pl.library.model.Book;
import java.util.Scanner;

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
        int releaseDate = sc.nextInt();
        sc.nextLine();
        System.out.print("Liczba stron: ");
        int pages = sc.nextInt();
        sc.nextLine();
        System.out.print("ISBN: ");
        String isbn = sc.nextLine();

        return new Book(title,author,releaseDate,pages,publisher,isbn);
    }

//    Pobieranie wybraniej opcji
    public int getInt(){
        int choice = sc.nextInt();
        sc.nextLine();
        return choice;
    }

//    Zamykanie systemu pobierania danych
    public void scClose(){
        sc.close();
    }
}
