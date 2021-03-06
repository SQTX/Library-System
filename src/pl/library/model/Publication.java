/*
 * Copyright (c) 2020. SQTX
 *
 * Copyright © 2020 SQTX. All rights reserved.
 */

package pl.library.model;

import java.io.Serializable;
import java.time.Year;
import java.util.Objects;

//Cechy które będą dziedziczone przez wszystkie publikacje w bibliotece
public abstract class Publication implements Serializable, Comparable<Publication>, CsvConvertible {
    private String title;
    private String publisher;
    private Year year;

    public Publication(String title, String publisher,int year) {
        this.title = title;
        this.publisher = publisher;
        this.year = Year.of(year);
    }

//    gettery i settery
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public Year getYear() {
        return year;
    }

    public void setYear(Year year) {
        this.year = year;
    }

    public String getPublisher() {
        return publisher;
    }
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Publication that = (Publication) o;
        return Objects.equals(title, that.title) &&
                Objects.equals(publisher, that.publisher) &&
                Objects.equals(year, that.year);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, publisher, year);
    }

    @Override
    public int compareTo(Publication p) {
        return title.compareToIgnoreCase(p.title);
    }
}
