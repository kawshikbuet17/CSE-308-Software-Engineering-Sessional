package com.company;

public class CppLanguageFactory implements LanguageFactory{
    @Override
    public Aesthetics createAesthetics() {
        return new CppAesthetics();
    }

    @Override
    public Parser createParser() {
        return new CppParser();
    }
}
