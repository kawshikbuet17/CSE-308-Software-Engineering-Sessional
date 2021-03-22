package syntaxHighlighterPackage;

import aestheticsPackage.Aesthetics;
import languageFactoryPackage.CppLanguageFactory;
import languageFactoryPackage.LanguageFactory;
import parserPackage.Parser;

public class CppSyntaxHighlighter implements SyntaxHighlighter{
    LanguageFactory lf;
    Aesthetics at;
    Parser ps;

    @Override
    public void SetSyntaxHighlighted() {
        lf = new CppLanguageFactory();
        at = lf.createAesthetics();
        ps = lf.createParser();

        at.SetFont();
        at.SetStyle();
        at.SetColor();
    }

    @Override
    public void GetSyntaxHighlighted() {
        at.GetFont();
        at.GetStyle();
        at.GetColor();
        ps.Parse();
    }
}
