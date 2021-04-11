package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("1. Beef Pizza with French fry");
        System.out.println("2. Veggi Pizza with onion rings");
        System.out.println("3. A combo meal with Veggi Pizza, French Fry and Coke");
        System.out.println("4. A combo meal with Veggi Pizza, Onion Rings and Coffee");
        System.out.println("5. A Beef Pizza only");
        System.out.println("0. Program Exit");

        Scanner sc = new Scanner(System.in);
        String input;
        while (sc.hasNextLine()){
            input = sc.nextLine();

            if(input.equalsIgnoreCase("1")){
                BeefPizza_FrenchFry beefPizza_frenchFry = new BeefPizza_FrenchFry((Food) new BeefPizza());
                System.out.println(beefPizza_frenchFry.prepareFood());
                System.out.println(beefPizza_frenchFry.foodPrice());
            }else if(input.equalsIgnoreCase("2")){
                VeggiPizza_OrionRings veggiPizza_orionRings = new VeggiPizza_OrionRings((Food) new VeggiPizza());
                System.out.println(veggiPizza_orionRings.prepareFood());
                System.out.println(veggiPizza_orionRings.foodPrice());
            }else if(input.equalsIgnoreCase("3")){
                VeggiPizza_FrenchFry_Coke veggiPizza_frenchFry_coke = new VeggiPizza_FrenchFry_Coke((Food) new VeggiPizza());
                System.out.println(veggiPizza_frenchFry_coke.prepareFood());
                System.out.println(veggiPizza_frenchFry_coke.foodPrice());
            }else if(input.equalsIgnoreCase("4")){
                VeggiPizza_OnionRings_Coffee veggiPizza_onionRings_coffee = new VeggiPizza_OnionRings_Coffee((Food) new VeggiPizza());
                System.out.println(veggiPizza_onionRings_coffee.prepareFood());
                System.out.println(veggiPizza_onionRings_coffee.foodPrice());
            }else if(input.equalsIgnoreCase("5")){
                BeefPizza beefPizza = new BeefPizza();
                System.out.println(beefPizza.prepareFood());
                System.out.println(beefPizza.foodPrice());
            }else if(input.equalsIgnoreCase("0")){
                System.out.println("Program Exited...");
                break;
            }
        }
    }
}
