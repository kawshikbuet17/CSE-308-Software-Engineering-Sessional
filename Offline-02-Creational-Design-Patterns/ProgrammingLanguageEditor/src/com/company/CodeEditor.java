package com.company;

public class CodeEditor {
    private static SyntaxHighlighter sh;
    private CodeEditor(){
        sh = null;
    }

    public static SyntaxHighlighter ActivateHighlightFeature(String languageName){
        if (sh == null){
            if (languageName.equalsIgnoreCase("C")){
                sh = new CSyntaxHighlighter();
            }else if (languageName.equalsIgnoreCase("CPP")){
                sh = new CppSyntaxHighlighter();
            }else if(languageName.equalsIgnoreCase("PYTHON")){
                sh = new PythonSyntaxHighlighter();
            }
        }
        return sh;
    }
}
