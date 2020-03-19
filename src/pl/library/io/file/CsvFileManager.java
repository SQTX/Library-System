/*
 * Copyright (c) 2020. SQTX
 *
 * Copyright © 2020 SQTX. All rights reserved.
 */

package pl.library.io.file;

import pl.library.exception.DataExportException;
import pl.library.exception.DataImportException;
import pl.library.exception.InvalidDataException;
import pl.library.model.Book;
import pl.library.model.Library;
import pl.library.model.Magazine;
import pl.library.model.Publication;

import java.io.*;
import java.util.Scanner;

public class CsvFileManager implements FileManager{
    private static final String FILE_NAME = "Library.csv";

    @Override
    public Library importData() {
        Library library = new Library();
        try(
                Scanner fileReader = new Scanner(new File(FILE_NAME));  //W skanerze tworzymy obiekt File a nie samo file
                ) {
            while (fileReader.hasNextLine()){
                String line = fileReader.nextLine();
                Publication publication = createObjectFromString(line);
                library.addPublication(publication);
            }
        } catch (FileNotFoundException e) {
            throw new DataImportException("Brak pliku" + FILE_NAME);
        }
        return library;
    }

//    line jest to wiersz tekstu zapisany w pliku
    private Publication createObjectFromString(String line) {
        String[] split = line.split(";");
        String type = split[0];
        if(Book.TYPE.equals(type)){
            return createBook(split);
        }else if(Magazine.TYPE.equals(type)){
            return createMagazine(split);
        }
        throw new InvalidDataException("Nieznany typ publikacji "+ type);
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
        Publication[] publications = library.getPublications();
        try(
                var fileWriter = new FileWriter(FILE_NAME);
                var bufferedWriter = new BufferedWriter(fileWriter);
        ){
            for (Publication publication : publications){
                bufferedWriter.write(publication.toCsv()); //Przekształcenie danych na format CSV
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            throw new DataExportException("Błąd zapisu pliku" + FILE_NAME);
        }
    }
}
