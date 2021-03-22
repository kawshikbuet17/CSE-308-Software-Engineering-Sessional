package com.company;

public class CSyntaxHighlighter implements SyntaxHighlighter{
    LanguageFactory lf;
    Aesthetics at;
    Parser ps;
    @Override
    public void SetSyntaxHighlighted() {
        lf = new CLanguageFactory();
        at = lf.createAesthetics();
        ps = lf.createParser();

        at.SetFont();
        at.SetStyle();
        at.SetColor();
    }

    @Override
    public void GetSyntaxHighlighted() {
        at.GetFont();
        at.GetStyle();
        at.GetColor();
        ps.Parse();
    }
}
