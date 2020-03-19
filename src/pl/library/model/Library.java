/*
 * Copyright (c) 2020. SQTX
 *
 * Copyright © 2020 SQTX. All rights reserved.
 */

package pl.library.model;

import java.io.Serializable;

public class Library implements Serializable {

    private final static int MAX_PUBLICATIONS = 2000;
    private Publication[] publications = new Publication[MAX_PUBLICATIONS];
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
        if (publicationsNumber >= MAX_PUBLICATIONS){
            throw new ArrayIndexOutOfBoundsException("Max publications exceeded" + MAX_PUBLICATIONS);
        }
        publications[publicationsNumber] = publication;
        publicationsNumber++;
    }
}
