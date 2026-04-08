package com.acme.entity;

import java.util.ArrayList;

public abstract class Publication {
    
    private String title;
    private short year;
    private byte volume;
    private ArrayList<Author> authors = new ArrayList<>();
    
    public void addAuthor(Author author) {
        authors.add(author);
    }
    
    public ArrayList<Author> getAuthors() {
        return this.authors;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public short getYear() {
        return year;
    }

    public void setYear(short year) {
        this.year = year;
    }

    public byte getVolume() {
        return volume;
    }

    public void setVolume(byte volume) {
        this.volume = volume;
    }
    
    
}
