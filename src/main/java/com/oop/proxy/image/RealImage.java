package com.oop.proxy.image;

public class RealImage implements Image {

    private String filename;

    public RealImage(String filename) {
        this.filename = filename;
        loadImage();
    }

    private void loadImage() {
        System.out.println("Loading image " + filename);
    }

    @Override
    public void display() {
        System.out.println("RealImage display" + filename);

    }
}
