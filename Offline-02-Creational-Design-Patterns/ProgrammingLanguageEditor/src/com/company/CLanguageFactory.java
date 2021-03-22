package com.company;

public class CLanguageFactory implements LanguageFactory{
    @Override
    public Aesthetics createAesthetics() {
        return new CAesthetics();
    }

    @Override
    public Parser createParser() {
        return new CParser();
    }
}
