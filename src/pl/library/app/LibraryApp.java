/*
 * Copyright (c) 2020. SQTX
 *
 * Copyright © 2020 SQTX. All rights reserved.
 */

package pl.library.app;

public class LibraryApp {
    final static String APP_NAME = "Biblioteka v1.0";

    public static void main(String[] args) {
        final String appName = APP_NAME;
        System.out.println(appName);
        LibraryControl libraryControl = new LibraryControl();
        libraryControl.controlLoop();
    }
}
