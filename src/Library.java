/*
 * Copyright © 2020 SQTX. All rights reserved.
 */

public class Library {
    public static void main(String[] args) {
        final String appName = "Library v0.3";

//      Nadanie cech obiektom Książka (przypisanie informacji)
        Book book1 = new Book("W pustyni i w puszczy", "Henryk Sienkiewicz", 2010,
                296, "Greg","9742356874236");

        Book book2 = new Book("Java. Podstawy. Wydanie XI", "Cay S. Horstmann", 2019,
                768, "Helion", "9788328357785");

        Book book3 = new Book("Sztuka podstępu. Łamałem ludzi, nie hasła. Wydanie II",
                "Kevin Mitnick, William L. Simon, Steve Wozniak", 2010, 384,
                "Helion", "9788328331372");

        System.out.println(appName);
        System.out.println("W bibliotece są ksiązki: ");
//      Metody odpowiedzialne za wypisanie informacji o książkach
        book1.printInfo();
        book2.printInfo();
        book3.printInfo();
    }
}
