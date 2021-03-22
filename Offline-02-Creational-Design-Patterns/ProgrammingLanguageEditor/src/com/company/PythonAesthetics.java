package com.company;

public class PythonAesthetics implements Aesthetics{
    String font;
    String style;
    String color;

    @Override
    public void SetFont() {
        this.font = "Consolas";
    }

    @Override
    public void SetStyle() {
        this.font = "Python Style : Normal";
    }

    @Override
    public void SetColor() {
        this.color = "Python Color : Blue";
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
