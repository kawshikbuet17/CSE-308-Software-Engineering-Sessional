package com.company;

import foodPkg.decoratorPkg.appentizerDecoratorPkg.AppentizerDecorator;
import foodPkg.decoratorPkg.appentizerDecoratorPkg.FrenchFryAppentizerDecorator;
import foodPkg.decoratorPkg.appentizerDecoratorPkg.OnionRingsAppentizerDecorator;
import foodPkg.appentizerPkg.FrenchFries;
import foodPkg.appentizerPkg.OnionRings;
import foodPkg.decoratorPkg.PizzaDecorator;
import foodPkg.decoratorPkg.drinksDecoratorPkg.CoffeeDrinksDecorator;
import foodPkg.decoratorPkg.drinksDecoratorPkg.CokeDrinksDecorator;
import foodPkg.decoratorPkg.drinksDecoratorPkg.DrinksDecorator;
import foodPkg.drinksPkg.Coffee;
import foodPkg.drinksPkg.Coke;
import foodPkg.Food;
import foodPkg.pizzaPkg.BeefPizza;
import foodPkg.pizzaPkg.Pizza;
import foodPkg.pizzaPkg.VeggiPizza;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Price List : ");
        System.out.println("\t"+new BeefPizza().prepareFood() + " = " + new BeefPizza().foodPrice());
        System.out.println("\t"+new VeggiPizza().prepareFood() + " = " + new VeggiPizza().foodPrice());
        System.out.println("\t"+new FrenchFries().prepareFood() + " = " + new FrenchFries().foodPrice());
        System.out.println("\t"+new OnionRings().prepareFood() + " = " + new OnionRings().foodPrice());
        System.out.println("\t"+new Coffee().prepareFood() + " = " + new Coffee().foodPrice());
        System.out.println("\t"+new Coke().prepareFood() + " = " + new Coke().foodPrice());
        System.out.println("Select Menu : ");
        System.out.println("\t1. Beef Pizza with French fry");
        System.out.println("\t2. Veggi Pizza with onion rings");
        System.out.println("\t3. A combo meal with Veggi Pizza, French Fry and Coke");
        System.out.println("\t4. A combo meal with Veggi Pizza, Onion Rings and Coffee");
        System.out.println("\t5. A Beef Pizza only");
        System.out.println("\t0. Program Exit");

        Scanner sc = new Scanner(System.in);
        String input;
        while (sc.hasNextLine()){
            input = sc.nextLine();

            if(input.equalsIgnoreCase("1")){
                Food beefPizza_frenchFry = (PizzaDecorator) new FrenchFryAppentizerDecorator(
                        (Pizza) new BeefPizza()
                );
                System.out.println(beefPizza_frenchFry.prepareFood());
                System.out.println(beefPizza_frenchFry.foodPrice());
            }

            else if(input.equalsIgnoreCase("2")){
                Food veggiPizza_orionRings = (PizzaDecorator) new OnionRingsAppentizerDecorator(
                        (Food) new VeggiPizza()
                );
                System.out.println(veggiPizza_orionRings.prepareFood());
                System.out.println(veggiPizza_orionRings.foodPrice());
            }

            else if(input.equalsIgnoreCase("3")){
                Food veggiPizza_frenchFry_coke = (PizzaDecorator) new PizzaDecorator(
                        (DrinksDecorator) new CokeDrinksDecorator(
                                (AppentizerDecorator) new FrenchFryAppentizerDecorator(
                                        (Pizza) new VeggiPizza()
                                )
                        )
                );
                System.out.println(veggiPizza_frenchFry_coke.prepareFood());
                System.out.println(veggiPizza_frenchFry_coke.foodPrice());
            }

            else if(input.equalsIgnoreCase("4")){
                Food veggiPizza_onionRings_coffee = (PizzaDecorator)new PizzaDecorator(
                        (DrinksDecorator)new CoffeeDrinksDecorator(
                                (AppentizerDecorator)new OnionRingsAppentizerDecorator(
                                        (Pizza)new VeggiPizza()
                                )
                        )
                );
                System.out.println(veggiPizza_onionRings_coffee.prepareFood());
                System.out.println(veggiPizza_onionRings_coffee.foodPrice());
            }

            else if(input.equalsIgnoreCase("5")){
                Pizza beefPizza = new BeefPizza();
                System.out.println(beefPizza.prepareFood());
                System.out.println(beefPizza.foodPrice());
            }

            else if(input.equalsIgnoreCase("0")){
                System.out.println("Program Exited...");
                break;
            }
        }
    }
}
