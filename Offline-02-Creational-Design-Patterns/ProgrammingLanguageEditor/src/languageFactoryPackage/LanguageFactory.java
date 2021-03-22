package languageFactoryPackage;

import aestheticsPackage.Aesthetics;
import parserPackage.Parser;

public interface LanguageFactory {
    Aesthetics createAesthetics();
    Parser createParser();
}
