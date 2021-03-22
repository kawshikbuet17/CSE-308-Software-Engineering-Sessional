package languageFactoryPackage;

import aestheticsPackage.Aesthetics;
import aestheticsPackage.PythonAesthetics;
import parserPackage.Parser;
import parserPackage.PythonParser;

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
