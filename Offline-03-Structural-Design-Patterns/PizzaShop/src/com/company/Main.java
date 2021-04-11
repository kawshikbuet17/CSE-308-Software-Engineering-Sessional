package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("1. Beef Pizza with French fry");
        System.out.println("2. Veggi Pizza with onion rings");
        System.out.println("3. A combo meal with Veggi Pizza, French Fry and Coke");
        System.out.println("4. A combo meal with Veggi Pizza, Onion Rings and Coffee");
        System.out.println("5. A Beef Pizza only");

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        if(input.equalsIgnoreCase("1")){
            System.out.println("1");
        }else if(input.equalsIgnoreCase("2")){
            System.out.println("2");
        }else if(input.equalsIgnoreCase("3")){
            System.out.println("3");
        }else if(input.equalsIgnoreCase("4")){
            System.out.println("4");
        }else if(input.equalsIgnoreCase("5")){
            System.out.println("5");
        }
    }
}
