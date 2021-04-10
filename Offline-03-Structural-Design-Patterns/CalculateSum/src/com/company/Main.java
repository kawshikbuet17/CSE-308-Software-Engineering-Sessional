package com.company;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        File fileObj = new File("decimal.txt");

        System.out.println("Decimal Sum : ");
        CalculateSum calculateSum1 = new CalculateSum("decimal", fileObj);
        System.out.println(calculateSum1.getSum());

        System.out.println("Ascii Sum : ");
        fileObj = new File("ascii.txt");
        CalculateSum calculateSum2 = new CalculateSum("ascii", fileObj);
        System.out.println(calculateSum2.getSum());
    }
}
