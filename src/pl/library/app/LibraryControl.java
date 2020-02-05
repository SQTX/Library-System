/*
 * Copyright (c) 2020. SQTX
 *
 * Copyright © 2020 SQTX. All rights reserved.
 */

package pl.library.app;

import pl.library.io.DataReader;
import pl.library.model.Book;
import pl.library.model.Library;

public class LibraryControl {

    private DataReader dataReader = new DataReader();
    private Library library = new Library();

//    Stałe przypisujące wartościom ich zadania wykonywane w switchu
    private final static int EXIT = 0;
    private final static int ADD_BOOK = 1;
    private final static int PRINT_BOOKS = 2;

//    Metoda odpowiedzialna za wybór działania
    public void controlLoop() {
        int choice;
        do{
            printOptions();
            choice = dataReader.getInt();
            System.out.println("");   //Enter po wybraniu, odstęp dla czytelnoścki kolejnych działań

            switch(choice){
                case EXIT: exit();
                break;
                case ADD_BOOK: addBook();
                break;
                case PRINT_BOOKS: printBooks();
                break;
                default: System.out.println("Polecenie nierozpoznane");
                break;
            }
        }while(choice!= EXIT);
    }

    private void printOptions() {
        System.out.println("\nWybierz opcję:");
        System.out.println("0 - wyjście");
        System.out.println("1 - dodaj książkę");
        System.out.println("2 - wyświetl dostępne książki");
        System.out.print("Wybieram opcję: ");
    }

    private void addBook() {
        Book book = dataReader.readAndCreateBook(); //Tworzenie obiektu book poprzez wywołanie metody
        library.addBook(book);  //Stworzony powyżej obiekt book zostaje przeniesiony do library.java i zapisany w tablic
    }

    private void printBooks() {
        library.printBooks();
    }

    private void exit() {
        System.out.println("Zamykanie systemu");
        dataReader.scClose();
    }
}
