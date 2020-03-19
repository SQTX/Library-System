/*
 * Copyright (c) 2020. SQTX
 *
 * Copyright © 2020 SQTX. All rights reserved.
 */

package pl.library.io.file;

import pl.library.exception.NoSuchFileTypeException;
import pl.library.io.ConsolePrinter;
import pl.library.io.DataReader;

public class FileManagerBuilder {
    private ConsolePrinter printer;
    private DataReader reader;

    public FileManagerBuilder(ConsolePrinter printer, DataReader reader) {
        this.printer = printer;
        this.reader = reader;
    }

    public FileManager build(){
        printer.printNLine("Wybierz format danych: ");
        FileType fileType = getFileType();
        switch (fileType){
            case SERIAL: {
                return new SerializableFileManager();
            }
            default:{
                throw new NoSuchFileTypeException("Nieobsługiwany typ danych.");
            }

        }
    }

//    Wczytanie od użytkownika jaki rodzaj zapisu danych wybiera
    private FileType getFileType(){
        boolean typeOk = false;
        FileType result = null;
        do{
            printerTypes();
            String type = reader.getString().toUpperCase();
            try {
                result = FileType.valueOf(type);
                typeOk = true;
            }catch (IllegalArgumentException e){
                printer.printNLine("Nieobsługiwany typ danych\nWybierz ponownie");
            }
        }while(!typeOk);
        return result;
    }

    private void printerTypes() {
        for(FileType value: FileType.values()){
            printer.printNLine(value.name());
        }
    }
}
