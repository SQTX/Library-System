/*
 * Copyright (c) 2020. SQTX
 *
 * Copyright © 2020 SQTX. All rights reserved.
 */

package pl.library.io.file;

import pl.library.exception.DataExportException;
import pl.library.exception.DataImportException;
import pl.library.exception.InvalidDataException;
import pl.library.model.*;
import java.io.*;
import java.text.CollationElementIterator;
import java.util.Collection;
import java.util.Scanner;

public class CsvFileManager implements FileManager {
    private static final String FILE_NAME = "Library.csv";
    private static final String USERS_FILE_NAME = "Library_users.csv";

    @Override
    public Library importData() {
        Library library = new Library();
        importPublications(library);
        importUsers(library);

        return library;
    }

    private void importUsers(Library library) {
        try (
                BufferedReader bufferedReader = new BufferedReader(new FileReader(USERS_FILE_NAME))
        ) {
            bufferedReader.lines()
                    .map(this::createUserFromString)
                    .forEach(library::addUser);

        } catch (FileNotFoundException e) {
            throw new DataImportException("Brak pliku" + USERS_FILE_NAME);
        } catch (IOException e){
            throw new DataImportException("Błąd odczytu pliku "+ USERS_FILE_NAME);
        }
    }

    private LibraryUser createUserFromString(String csvText) {
        String[] split = csvText.split(";");
        String firstName = split[0];
        String lastName = split[1];
        String pesel = split[2];
        return new LibraryUser(firstName, lastName, pesel);
    }

    private void importPublications(Library library) {
        try (
                BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_NAME))
        ) {
            bufferedReader.lines()
                    .map(this::createObjectFromString)
                    .forEach(library::addPublication);
        } catch (FileNotFoundException e) {
            throw new DataImportException("Brak pliku" + FILE_NAME);
        } catch (IOException e){
            throw new DataImportException("Błąd odczytu pliku "+ USERS_FILE_NAME);
        }
    }

    //    line jest to wiersz tekstu zapisany w pliku
    private Publication createObjectFromString(String line) {
        String[] split = line.split(";");
        String type = split[0];
        if (Book.TYPE.equals(type)) {
            return createBook(split);
        } else if (Magazine.TYPE.equals(type)) {
            return createMagazine(split);
        }
        throw new InvalidDataException("Nieznany typ publikacji " + type);
    }

    private Publication createBook(String[] split) {
        String title = split[1];
        String author = split[2];
        int year = Integer.valueOf(split[3]);
        int pages = Integer.valueOf(split[4]);
        String publisher = split[5];
        String isbn = split[6];
        return new Book(title, author, year, pages, publisher, isbn);
    }

    private Publication createMagazine(String[] split) {
        String title = split[1];
        String publisher = split[2];
        String language = split[3];
        int year = Integer.valueOf(split[4]);
        int month = Integer.valueOf(split[5]);
        int day = Integer.valueOf(split[6]);
        return new Magazine(title, publisher, language, year, month, day);
    }


    @Override
    public void exportData(Library library) {
        exportPublications(library);
        exportUsers(library);
    }

    private void exportUsers(Library library) {
        Collection<LibraryUser> users = library.getUsers().values(); //Mapa została zamieniona na interface nadrzędny'
        // Collection, a dokładnie value, alby móc po nim iterować (po mapie jest to niemożliwe)
        exportToCsv(users, USERS_FILE_NAME);
    }

    private void exportPublications(Library library) {
        Collection<Publication> publications = library.getPublications().values();
        exportToCsv(publications, FILE_NAME);
    }

    private <T extends CsvConvertible> void exportToCsv(Collection<T> collection, String fileName) {
//        objekt nie określony T jest rozszerzony o interface CsvConvertible

        try (
                var fileWriter = new FileWriter(fileName);
                var bufferedWriter = new BufferedWriter(fileWriter);
        ) {
            for (T element : collection) { //iterowanie
                bufferedWriter.write(element.toCsv()); //Przekształcenie danych na format CSV
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            throw new DataExportException("Błąd zapisu pliku" + USERS_FILE_NAME);
        }
    }
}
