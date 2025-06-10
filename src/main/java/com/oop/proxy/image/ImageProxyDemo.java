package com.oop.proxy.image;

public class ImageProxyDemo {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("test1.jpg");
        Image image2 = new ProxyImage("test2.jpg");

        image1.display();
        image2.display();
        image1.display();
    }
}
