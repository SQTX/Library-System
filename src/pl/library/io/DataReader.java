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

    public Book readAndCreateBook(){
        //        Tworzenie książki
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
    public void scClose(){
        sc.close();
    }
}
