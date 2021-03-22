package languageFactoryPackage;

import aestheticsPackage.Aesthetics;
import aestheticsPackage.CppAesthetics;
import parserPackage.CppParser;
import parserPackage.Parser;

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
