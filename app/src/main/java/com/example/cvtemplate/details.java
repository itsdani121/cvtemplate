package com.example.cvtemplate;

public class details {
    private int image,sizes;
    private String title,path;

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getSizes() {
        return sizes;
    }

    public void setSizes(int sizes) {
        this.sizes = sizes;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public details(int image, int size, String title, String path) {
        this.image = image;
        this.sizes = size;//idr sizes likha hua tha liken idr size ana chaye tha ok ho gya
        this.title = title;
        this.path = path;
    }
}
