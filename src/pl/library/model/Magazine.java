/*
 * Copyright (c) 2020. SQTX
 *
 * Copyright © 2020 SQTX. All rights reserved.
 */

package pl.library.model;

public class Magazine extends Publication {
    private int month;
    private int day;
    private String language;

    public Magazine(String title, String publisher, String language, int year, int month, int day) {
        super(title, publisher, year);
        this.month = month;
        this.day = day;
        this.language = language;
    }

//    gettery i settery
    public int getMonth() {
        return month;
    }
    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }
    public void setDay(int day) {
        this.day = day;
    }

    public String getLanguage() {
        return language;
    }
    public void setLanguage(String language) {
        this.language = language;
    }

    //    Metoda odpowiedzialna za wypisanie zapisanych informacji o danym magazynie
    public void printInfo() {
        String info = "\"" + getTitle() + "\"" + "\n" + getPublisher() + "\n" + getLanguage() + "\n" + getYear() +
                "\n" + getMonth() + "\n" + getDay();
        System.out.println(info);
    }
}
