package com.company;

public class CAesthetics implements Aesthetics{
    String font;
    String style;
    String color;

    @Override
    public void SetFont() {
        this.font = "Courier New";
    }

    @Override
    public void SetStyle() {
        this.font = "C Style : Normal";
    }

    @Override
    public void SetColor() {
        this.color = "C Color : Blue";
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
