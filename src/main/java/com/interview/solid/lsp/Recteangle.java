package com.interview.solid.lsp;

public class Recteangle implements Shape {

    private int width;
    private int height;

    public Recteangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public int getArea() {
        return width * height;
    }
}
