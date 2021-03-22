package languageFactoryPackage;

import aestheticsPackage.Aesthetics;
import aestheticsPackage.CAesthetics;
import parserPackage.CParser;
import parserPackage.Parser;

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
