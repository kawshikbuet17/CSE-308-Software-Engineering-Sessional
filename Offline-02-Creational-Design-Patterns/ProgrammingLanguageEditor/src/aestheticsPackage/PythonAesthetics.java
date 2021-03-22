package aestheticsPackage;

public class PythonAesthetics implements Aesthetics{
    String font;
    String style;
    String color;

    @Override
    public void SetFont() {
        this.font = "Python Font : Consolas";
    }

    @Override
    public void SetStyle() {
        this.style = "Python Style : Normal";
    }

    @Override
    public void SetColor() {
        this.color = "Python Color : Blue";
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
