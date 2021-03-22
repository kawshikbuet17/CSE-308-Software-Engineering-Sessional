package com.company;

public class CppAesthetics implements Aesthetics{
    String font;
    String style;
    String color;

    @Override
    public void SetFont() {
        this.font = "Monaco";
    }

    @Override
    public void SetStyle() {
        this.font = "Cpp Style : Normal";
    }

    @Override
    public void SetColor() {
        this.color = "Cpp Color : Blue";
    }

    @Override
    public String GetFont() {
        return font;
    }

    @Override
    public String GetStyle() {
        return style;
    }

    @Override
    public String GetColor() {
        return color;
    }
}
