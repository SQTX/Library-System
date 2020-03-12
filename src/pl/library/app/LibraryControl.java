/*
 * Copyright (c) 2020. SQTX
 *
 * Copyright © 2020 SQTX. All rights reserved.
 */

package pl.library.app;

import pl.library.exception.NoSuchOptionException;
import pl.library.io.ConsolePrinter;
import pl.library.io.DataReader;
import pl.library.model.Book;
import pl.library.model.Library;
import pl.library.model.Magazine;
import pl.library.model.Publication;

import java.util.InputMismatchException;

public class LibraryControl {

    private ConsolePrinter printer = new ConsolePrinter();
    private DataReader dataReader = new DataReader(printer);
    private Library library = new Library();

//    Metoda odpowiedzialna za wybór działania
    public void controlLoop() {
        Option choice;
        do{
            printOptions();
            choice = getChoice();
            printer.printNLine("");   //Enter po wybraniu, odstęp dla czytelnoścki kolejnych działań

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
                default:
                    printer.printLine("Nie ma takiej opcji, wprowadź ponownie: "); //w razie W
            }
        }while(choice!= Option.EXIT);
    }

    private Option getChoice() {
        boolean optionOk = true;
        Option choice = null;
        do {
            try {
                choice = Option.createFromInt(dataReader.getInt()); //Przekształaca podaną liczbę w obiekt
                optionOk = false;
            } catch (NoSuchOptionException e) {
                printer.printLine(e.getMessage());
            } catch (InputMismatchException e) {
                printer.printLine("Wprowadzona wartość nie jest liczbą, podaj ponownie: ");
            }
        }while (optionOk);
        return choice;
    }

    private void printOptions() {
        printer.printNLine("");   //Enter po wybraniu, odstęp dla czytelnoścki kolejnych działań
        for (Option value : Option.values()) {
            printer.printNLine(value.toString());  //Polecenie w nawisie domyślnie wygląda tak: "value.toString()", dlatego wyświetla się descryption
        }
        printer.printLine("Wybieram opcję: ");
    }

    private void addBook() {
        try {
            Book book = dataReader.readAndCreateBook(); //Tworzenie obiektu book poprzez wywołanie metody
            library.addBook(book);  //Stworzony powyżej obiekt book zostaje przeniesiony do library.java i zapisany w tablic
        }catch (InputMismatchException e){
            printer.printNLine("Książka nie została dodana, podałeś błędne dane.");
        }catch (ArrayIndexOutOfBoundsException e){
            printer.printNLine("Osiągnięto limit pojemności, nie można dodać kolejnej książki.");
        }
    }
    private void addMagazine() {
        try {
            Magazine magazine = dataReader.readAndCreateMagazine(); //Tworzenie obiektu magazine poprzez wywołanie metody
            library.addMagazine(magazine);  //Stworzony powyżej obiekt magazine zostaje przeniesiony do library.java i zapisany w tablic
        }catch (InputMismatchException e){
            printer.printNLine("Magazyn nie została dodana, podałeś błędne dane.");
        }catch (ArrayIndexOutOfBoundsException e){
        printer.printNLine("Osiągnięto limit pojemności, nie można dodać kolejnego magazynu.");
    }
    }

    private void printBooks() {
        Publication[] publications = library.getPublications();
        printer.printBooks(publications);
    }
    private void printMagazines() {
        Publication[] publications = library.getPublications();
        printer.printMagazine(publications);
    }

    private void exit() {
        printer.printNLine("Zamykanie systemu...");
        dataReader.scClose();
    }
}
