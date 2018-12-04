package com.example.paul_.foodappv2.Model;

public class Category {

    private String name;
    private String Image;

    public Category() {

    }

    public Category(String name, String image) {
        this.name = name;
        Image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }
}
