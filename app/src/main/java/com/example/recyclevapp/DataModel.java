package com.example.recyclevapp;

public class DataModel {

    private String name;
    private String description;
    private String quote;
    private int image; // Integer
    private int id_;

    public DataModel(String name, String description, String quote, int image, int id_) {
        this.name = name;
        this.description = description;
        this.quote = quote;
        this.image = image;
        this.id_ = id_;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getId_() {
        return id_;
    }

    public void setId_(int id_) {
        this.id_ = id_;
    }
}








