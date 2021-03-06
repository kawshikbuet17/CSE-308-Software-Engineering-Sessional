package syntaxHighlighterPackage;

import aestheticsPackage.Aesthetics;
import languageFactoryPackage.LanguageFactory;
import languageFactoryPackage.PythonLanguageFactory;
import parserPackage.Parser;

public class PythonSyntaxHighlighter implements SyntaxHighlighter{
    LanguageFactory lf;
    Aesthetics at;
    Parser ps;

    @Override
    public void SetSyntaxHighlighted() {
        lf = new PythonLanguageFactory();
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
