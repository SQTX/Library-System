/*
 * Copyright (c) 2020. SQTX
 *
 * Copyright © 2020 SQTX. All rights reserved.
 */

package pl.library.app;

import pl.library.exception.DataExportException;
import pl.library.exception.DataImportException;
import pl.library.exception.NoSuchOptionException;
import pl.library.io.ConsolePrinter;
import pl.library.io.DataReader;
import pl.library.io.file.FileManager;
import pl.library.io.file.FileManagerBuilder;
import pl.library.model.Book;
import pl.library.model.Library;
import pl.library.model.Magazine;
import pl.library.model.Publication;

import java.util.InputMismatchException;

public class LibraryControl {

    private ConsolePrinter printer = new ConsolePrinter();
    private DataReader dataReader = new DataReader(printer);
    private Library library;
    private FileManager fileManager;

    public LibraryControl(){
        fileManager = new FileManagerBuilder(printer, dataReader).build();
        try {
            library = fileManager.importData();
            printer.printNLine("Zaimportowano dane z pliku.");
        }catch (DataImportException e){
            printer.printNLine(e.getMessage());
            printer.printNLine("Zainicjowano nową bazę.");
            library = new Library();
        }
    }

    //    Metoda odpowiedzialna za wybór działania
    public void controlLoop() throws InterruptedException {
        Option choice;
        do {
            printOptions();
            choice = getChoice();
            printer.printNLine("");   //Enter po wybraniu, odstęp dla czytelnoścki kolejnych działań

            switch (choice) {
                case EXIT:
                    exit();
                    break;
                case ADD_BOOK:
                    addBook();
                    break;
                case ADD_MAGAZINE:
                    addMagazine();
                    break;
                case PRINT_BOOKS:
                    printBooks();
                    break;
                case PRINT_MAGAZINES:
                    printMagazines();
                    break;
                default:
                    printer.printLine("Nie ma takiej opcji, wprowadź ponownie: "); //w razie W
            }
        } while (choice != Option.EXIT);
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
        } while (optionOk);
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
        } catch (InputMismatchException e) {
            printer.printNLine("Książka nie została dodana, podałeś błędne dane.");
        } catch (ArrayIndexOutOfBoundsException e) {
            printer.printNLine("Osiągnięto limit pojemności, nie można dodać kolejnej książki.");
        }
    }

    private void addMagazine() {
        try {
            Magazine magazine = dataReader.readAndCreateMagazine(); //Tworzenie obiektu magazine poprzez wywołanie metody
            library.addMagazine(magazine);  //Stworzony powyżej obiekt magazine zostaje przeniesiony do library.java i zapisany w tablic
        } catch (InputMismatchException e) {
            printer.printNLine("Magazyn nie została dodana, podałeś błędne dane.");
        } catch (ArrayIndexOutOfBoundsException e) {
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

    private void exit() throws InterruptedException {
        try{
            fileManager.exportData(library);
            printer.printNLine("Dane zostały zapisane");
        }catch (DataExportException e){
            printer.printNLine(e.getMessage());
        }
        printer.printLine("Zamykanie systemu");
        for (int i = 0; i<3; i++){  //Efekt 3 kropek po zamknięciu
            Thread.sleep(600);
            printer.printLine(".");
        }
        dataReader.scClose();
    }

//    Klasa wewnętrzna
    enum Option {
        EXIT(0, "wyjście"),
        ADD_BOOK(1, "dodaj książkę"),
        ADD_MAGAZINE(2, "dodaj magazyn"),
        PRINT_BOOKS(3, "wyświetl dostępne książki"),
        PRINT_MAGAZINES(4, "wyświetl dostępne magazyny");

        private final int value;
        private final String description;

        Option(int value, String description) {
            this.value = value;
            this.description = description;
        }

        //    gettery
        public int getValue() {
            return value;
        }

        public String getDescription() {
            return description;
        }

        @Override
        public String toString() {
            return value + " - " + description;
        }

        public static Option createFromInt(int choice) throws NoSuchOptionException {
            try {
                return Option.values()[choice];
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new NoSuchOptionException("Opcji " + choice + " nie istnieje, podaj ponownie:");
            }
        }
    }
}
