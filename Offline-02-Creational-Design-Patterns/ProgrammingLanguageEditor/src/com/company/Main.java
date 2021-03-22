package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("hello world");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        CodeEditor ce = new CodeEditor(input);
        SyntaxHighlighter sh = ce.GetHighlighted();
        sh.SetSyntaxHighlighted();
        sh.GetSyntaxHighlighted();
    }
}
