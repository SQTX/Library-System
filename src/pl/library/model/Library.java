/*
 * Copyright (c) 2020. SQTX
 *
 * Copyright © 2020 SQTX. All rights reserved.
 */

package pl.library.model;

import pl.library.exception.PublicationAlreadyExistsException;
import pl.library.exception.UserAlreadyExistsException;
import java.io.Serializable;
import java.util.*;

public class Library implements Serializable {

    private Map<String, Publication> publications = new HashMap<>();
    private Map<String, LibraryUser> users = new HashMap<>();

    public Map<String, Publication> getPublications() {
        return publications;
    }

    public Collection<Publication> getSortedPublications (Comparator<Publication> comparator){
        List <Publication> list = new ArrayList<>(this.publications.values());
        list.sort(comparator);
        return list;
    }

    public Optional<Publication> findPublicationByTitle(String title){
        return Optional.ofNullable(publications.get(title));    //Wyszukuje publikację po tytule (który jest kluczem)
    }

    public Map<String, LibraryUser> getUsers() {
        return users;
    }

    public Collection<LibraryUser> getSortedUsers (Comparator<LibraryUser> comparator){
        List <LibraryUser> list = new ArrayList<>(this.users.values());
        list.sort(comparator);
        return list;
    }

//    Metoda odpowiedzialna za sprawdzenie czy nie ma kopii i dodanie nowej publikacji
    public void addPublication(Publication publication){
        if(publications.containsKey(publication.getTitle())){
            throw new PublicationAlreadyExistsException(
                    "Publikacja o tym tytule istnieje "+publication.getTitle()
            );
        }
        publications.put(publication.getTitle(), publication);
    }

//    Metoda podpowiedzialna za sprawdzenie czy podany urzytkownik jest już zapisany w bazie
    public void addUser(LibraryUser user) {
        if(users.containsKey(user.getPesel())){
            throw new UserAlreadyExistsException(
                    "Ta osoba już jest zapisana w bazie " + user.getPesel()
            );
        }
        users.put(user.getPesel(), user);
    }

//    Metoda do usuwania publikacji
    public boolean removePublication(Publication pub){
        if(publications.containsValue(pub)){
            publications.remove(pub.getTitle());
            return true;
        } else{
            return false;
        }
    }
}
