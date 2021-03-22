package com.company;

public class SyntaxHighlighter {
    String languageName;
    LanguageFactory lf;

    SyntaxHighlighter(String languageName){
        this.languageName = languageName;
        lf = null;
    }

    public LanguageFactory GetSyntaxHighlighted(){
        if (languageName.equalsIgnoreCase("C")){
            lf = new CLanguageFactory();
            lf.createAesthetics();
            lf.createParser();
        }else if (languageName.equalsIgnoreCase("CPP")){
            lf = new CLanguageFactory();
            lf.createAesthetics();
            lf.createParser();
        }else if (languageName.equalsIgnoreCase("Python")){
            lf = new CLanguageFactory();
            lf.createAesthetics();
            lf.createParser();
        }
        return lf;
    }
}
