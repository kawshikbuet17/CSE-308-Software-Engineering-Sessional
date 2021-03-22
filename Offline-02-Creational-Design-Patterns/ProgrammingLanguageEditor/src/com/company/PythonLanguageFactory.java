package com.company;

public class PythonLanguageFactory implements LanguageFactory{
    @Override
    public Aesthetics createAesthetics() {
        return new PythonAesthetics();
    }

    @Override
    public Parser createParser() {
        return new PythonParser();
    }
}
