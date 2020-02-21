/*
 * Copyright (c) 2020. SQTX
 *
 * Copyright © 2020 SQTX. All rights reserved.
 */

package pl.library.model;

//Cechy które będą dziedziczone przez wszystkie publikacje w bibliotece
public class Publication {
    private String title;
    private String publisher;
    private int year;

//    gettery i settery
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }

    public String getPublisher() {
        return publisher;
    }
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Publication(String title, String publisher,int releaseDate) {
        this.title = title;
        this.publisher = publisher;
        this.year = releaseDate;
    }
}
