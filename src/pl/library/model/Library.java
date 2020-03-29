/*
 * Copyright (c) 2020. SQTX
 *
 * Copyright © 2020 SQTX. All rights reserved.
 */

package pl.library.model;

import java.io.Serializable;
import java.util.Arrays;

public class Library implements Serializable {

    private final static int INITIAL_CAPACITY= 2;
    private Publication[] publications = new Publication[INITIAL_CAPACITY];
    private int publicationsNumber = 0;

    public Publication[] getPublications() {
        Publication[] result = new Publication[publicationsNumber];
        for (int i =0; i < result.length; i++){
            result[i] = publications[i];
        }
        return result;
    }

//    Metoda odpowiedzialna za sprawdzenie czy limit magazynów nie został przekroczony oraz dodanie nowej publikacji
    public void addPublication(Publication publication){
        if (publicationsNumber >= publications.length){
            publications = Arrays.copyOf(publications, publications.length*2);
        }
        publications[publicationsNumber] = publication;
        publicationsNumber++;
    }

//    Metoda do usuwania publikacji
    public boolean removePublication(Publication publication){
        final int notFound = -1;
        int found = notFound;
        int i=0;
        while(i < publicationsNumber && found==notFound) {
            if(publication.equals(publications[i])){
                found = i;
            } else {
                i++;
            }
        }
        if(found != notFound) {
            System.arraycopy(publications, found+1, publications, found, publications.length-1);
            publicationsNumber--;
            publications[publicationsNumber] = null;
            return true;
        }
        return false;
    }
}
