package com.company;

public abstract class SyntaxHighlighter {
    LanguageFactory lf;
    Aesthetics at;
    Parser ps;

    SyntaxHighlighter(){
        lf = null;
        at = null;
        ps = null;
    }

    public abstract void SetSyntaxHighlighted();
    public void GetSyntaxHighlighted(){
        at.GetFont();
        at.GetStyle();
        at.GetColor();

        ps.Parse();
    }
}
