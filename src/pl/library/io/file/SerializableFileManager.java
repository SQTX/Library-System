/*
 * Copyright (c) 2020. SQTX
 *
 * Copyright © 2020 SQTX. All rights reserved.
 */

package pl.library.io.file;

import pl.library.exception.DataExportException;
import pl.library.exception.DataImportException;
import pl.library.model.Library;

import java.io.*;

public class SerializableFileManager implements FileManager{
    private static final String FILE_NAME = "Library.o";

//    Serializowany odczyt pliku
    @Override
    public Library importData() {
        try(
                FileInputStream fis = new FileInputStream(FILE_NAME);
                ObjectInputStream ois = new ObjectInputStream(fis);
                ) {
            return (Library)ois.readObject();
        } catch (FileNotFoundException e) {
            throw new DataImportException("Brak pliku" + FILE_NAME);
        }catch (IOException e){
            throw new DataImportException("Błąd zapisu pliku" + FILE_NAME);
        } catch (ClassNotFoundException e) {
            throw new DataImportException("Niezgodny typ danych" + FILE_NAME);
        }
    }

//    Serializowany zapis pliku
    @Override
    public void exportData(Library library) {
        try(
                FileOutputStream fos = new FileOutputStream(FILE_NAME);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                ) {
            oos.writeObject(library);
        } catch (FileNotFoundException e) {
            throw new DataExportException("Brak pliku" + FILE_NAME);
        }catch (IOException e){
            throw new DataExportException("Błąd zapisu pliku" + FILE_NAME);
        }
    }
}
