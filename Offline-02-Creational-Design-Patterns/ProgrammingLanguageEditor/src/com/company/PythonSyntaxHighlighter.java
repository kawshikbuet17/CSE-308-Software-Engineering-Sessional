package com.company;

public class PythonSyntaxHighlighter extends SyntaxHighlighter{
    @Override
    public void SetSyntaxHighlighted() {
        lf = new PythonLanguageFactory();
        at = new PythonAesthetics();
        ps = new PythonParser();
    }
}
