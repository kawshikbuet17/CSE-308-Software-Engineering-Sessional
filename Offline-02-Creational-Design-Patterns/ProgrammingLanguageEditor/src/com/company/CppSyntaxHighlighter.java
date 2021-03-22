package com.company;

public class CppSyntaxHighlighter extends SyntaxHighlighter{
    @Override
    public void SetSyntaxHighlighted() {
        lf = new CppLanguageFactory();
        at = new CppAesthetics();
        ps = new CppParser();
    }
}
