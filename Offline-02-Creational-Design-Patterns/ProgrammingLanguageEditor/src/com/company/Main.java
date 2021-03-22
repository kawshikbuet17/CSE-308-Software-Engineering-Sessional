package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Input your filename : ");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println(input);
        String[] arr = input.split("\\.");
        input = arr[arr.length-1];
        if (input.equalsIgnoreCase("py")){
            input = "python";
        }

        //CodeEditor ce = new CodeEditor();
        SyntaxHighlighter sh = CodeEditor.ActivateHighlightFeature(input);
        sh.SetSyntaxHighlighted();
        sh.GetSyntaxHighlighted();
    }
}
