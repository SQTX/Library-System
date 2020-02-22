/*
 * Copyright (c) 2020. SQTX
 *
 * Copyright © 2020 SQTX. All rights reserved.
 */

package pl.library.model;

public class Library{

    private final static int MAX_PUBLICATIONS = 2000;
    private Publication[] publications = new Publication[MAX_PUBLICATIONS];
    private int publicationsNumber = 0;

//    Metoda odpowiedzialna za sprawdzenie czy limit książek nie został przekroczony oraz dodanie nowej książki
    public void addBook(Book book){
        if(publicationsNumber< MAX_PUBLICATIONS){
            publications[publicationsNumber] = book;
            publicationsNumber++;
        }else{
            System.out.println("Biblioteka jest przepełniona.");
        }
    }

    //    Metoda odpowiedzialna za sprawdzenie czy limit magazynów nie został przekroczony oraz dodanie nowego magazynu
    public void addMagazine(Magazine magazine){
        if(publicationsNumber< MAX_PUBLICATIONS){
            publications[publicationsNumber] = magazine;
            publicationsNumber++;
        }else{
            System.out.println("Biblioteka jest przepełniona.");
        }
    }

//    Metoda odpowiedzialna za rozpoznanie czy są jakies książki i wyświetlenie ich wszystkich w zwartej liście
    public void printBooks() {
        int countBooks = 0;
        for (int i=0;i<publicationsNumber;i++){
            if(publications[i] instanceof Book)
                System.out.println("Książka nr. "+(++countBooks));
                ((Book)publications[i]).printInfo();
        }
        if(countBooks==0){
            System.out.println("Brak książek w bibliotece.");
        }
    }

    //    Metoda odpowiedzialna za rozpoznanie czy są jakies magazynów i wyświetlenie ich wszystkich w zwartej liście
    public void printMagazine() {
        int countMagazine = 0;
        for (int i=0;i<publicationsNumber;i++){
            if(publications[i] instanceof Magazine){
                System.out.println("Magazyn nr. "+(++countMagazine));
                ((Magazine)publications[i]).printInfo();
        }
        }
        if (countMagazine == 0) {
            System.out.println("Brak magazynów w bibliotece");
        }
    }
}
