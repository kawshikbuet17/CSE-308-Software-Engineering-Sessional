package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("hello world");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        SyntaxHighlighter sh = new SyntaxHighlighter(input);
        sh.GetSyntaxHighlighted();
    }
}
