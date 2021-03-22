package com.company;

public class CppAesthetics implements Aesthetics{
    String font;
    String style;
    String color;

    @Override
    public void SetFont() {
        this.font = "Cpp Font : Monaco";
    }

    @Override
    public void SetStyle() {
        this.style = "Cpp Style : Normal";
    }

    @Override
    public void SetColor() {
        this.color = "Cpp Color : Blue";
    }

    @Override
    public void GetFont() {
        System.out.println(font);
    }

    @Override
    public void GetStyle() {
        System.out.println(style);
    }

    @Override
    public void GetColor() {
        System.out.println(color);
    }
}
