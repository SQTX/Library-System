/*
 * Copyright (c) 2020. SQTX
 *
 * Copyright © 2020 SQTX. All rights reserved.
 */

package pl.library.app;

import pl.library.io.ConsolePrinter;

public class LibraryApp {
    final static String APP_NAME = "Biblioteka v2.1";
    public static void main(String[] args) throws InterruptedException {
        System.out.println(APP_NAME);
        LibraryControl libraryControl = new LibraryControl();
        libraryControl.controlLoop();
    }
}
