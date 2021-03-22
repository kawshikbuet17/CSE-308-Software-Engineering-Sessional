package com.company;

public class CAesthetics implements Aesthetics{
    String font;
    String style;
    String color;

    @Override
    public void SetFont() {
        this.font = "C Font : Courier New";
    }

    @Override
    public void SetStyle() {
        this.style = "C Style : Normal";
    }

    @Override
    public void SetColor() {
        this.color = "C Color : Blue";
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
