package com.company;

public class CodeEditor {
    SyntaxHighlighter sh;
    String languageName;

    CodeEditor(String languageName){
        this.languageName = languageName;
//        sh = null;
    }

    public SyntaxHighlighter GetHighlighted(){
        if (languageName.equalsIgnoreCase("C")){
            sh = new CSyntaxHighlighter();
        }else if (languageName.equalsIgnoreCase("CPP")){
            sh = new CppSyntaxHighlighter();
        }else if(languageName.equalsIgnoreCase("PYTHON")){
            sh = new PythonSyntaxHighlighter();
        }
        return sh;
    }
}
