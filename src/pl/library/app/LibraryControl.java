/*
 * Copyright (c) 2020. SQTX
 *
 * Copyright © 2020 SQTX. All rights reserved.
 */

package pl.library.app;

import pl.library.io.DataReader;
import pl.library.model.Book;
import pl.library.model.Library;
import pl.library.model.Magazine;

public class LibraryControl {

    private DataReader dataReader = new DataReader();
    private Library library = new Library();

//    Stałe przypisujące wartościom ich zadania wykonywane w switchu
    private final static int EXIT = 0;
    private final static int ADD_BOOK = 1;
    private final static int ADD_MAGAZINE = 2;
    private final static int PRINT_BOOKS = 3;
    private final static int PRINT_MAGAZINES = 4;

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
                case ADD_MAGAZINE: addMagazine();
                break;
                case PRINT_BOOKS: printBooks();
                break;
                case PRINT_MAGAZINES: printMagazines();
                break;
                default: System.out.println("Polecenie nierozpoznane");
                break;
            }
        }while(choice!= EXIT);
    }

    private void printOptions() {
        System.out.println("\nWybierz opcję:");
        System.out.println(EXIT+" - wyjście");
        System.out.println(ADD_BOOK+" - dodaj książkę");
        System.out.println(ADD_MAGAZINE+" - dodaj magazyn");
        System.out.println(PRINT_BOOKS+" - wyświetl dostępne książki");
        System.out.println(PRINT_MAGAZINES+" - wyświetl dostępne magazyny");
        System.out.print("Wybieram opcję: ");
    }

    private void addBook() {
        Book book = dataReader.readAndCreateBook(); //Tworzenie obiektu book poprzez wywołanie metody
        library.addBook(book);  //Stworzony powyżej obiekt book zostaje przeniesiony do library.java i zapisany w tablic
    }
    private void addMagazine() {
        Magazine magazine = dataReader.readAndCreateMagazine(); //Tworzenie obiektu magazine poprzez wywołanie metody
        library.addMagazine(magazine);  //Stworzony powyżej obiekt magazine zostaje przeniesiony do library.java i zapisany w tablic
    }

    private void printBooks() {
        library.printBooks();
    }
    private void printMagazines() {
        library.printMagazine();
    }

    private void exit() {
        System.out.println("Zamykanie systemu");
        dataReader.scClose();
    }
}
