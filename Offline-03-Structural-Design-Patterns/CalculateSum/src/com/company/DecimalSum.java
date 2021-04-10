package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DecimalSum implements CalculateSum{
    int decimalSum;

    public DecimalSum() {
        this.decimalSum = 0;
    }

    @Override
    public void getFile(File fileObj) {
        try (Scanner sc = new Scanner(fileObj)) {
            while (sc.hasNext()){
                int a = sc.nextInt();
                decimalSum += a;
            }
        } catch (FileNotFoundException e) {
            System.out.println("Some error occured in file " + fileObj.getName());
            e.printStackTrace();
        }
    }

    @Override
    public int getSum() {
        return decimalSum;
    }
}
