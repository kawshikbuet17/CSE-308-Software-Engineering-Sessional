package com.company;

public class CSyntaxHighlighter extends SyntaxHighlighter{
    @Override
    public void SetSyntaxHighlighted() {
        lf = new CLanguageFactory();
        at = new CAesthetics();
        ps = new CParser();
    }
}
