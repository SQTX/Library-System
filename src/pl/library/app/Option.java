/*
 * Copyright (c) 2020. SQTX
 *
 * Copyright © 2020 SQTX. All rights reserved.
 */

package pl.library.app;

import pl.library.exception.NoSuchOptionException;

public enum Option {
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
            return Option.values() [choice];
        }catch (ArrayIndexOutOfBoundsException e){
            throw new NoSuchOptionException("Opcji " + choice + " nie istnieje, podaj ponownie:");
        }
    }
}
