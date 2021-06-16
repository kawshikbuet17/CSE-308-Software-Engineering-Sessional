package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        File fileObj = new File("stock.txt");
        try {
            Scanner sc = new Scanner(fileObj);
            while (sc.hasNextLine()){
                String input = sc.nextLine();
                String[] arr = input.split("\\ ");
                Stock stock = new Stock(arr[0], Integer.parseInt(arr[1]), Double.parseDouble(arr[2]));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File input error");
            e.printStackTrace();
        }
    }
}
