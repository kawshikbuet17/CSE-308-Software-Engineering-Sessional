package com.company;

import builderPackage.Builder;
import builderPackage.TeaGASBuilder;
import productPackage.TeaGAS;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Director director = new Director();
        Builder builder = new TeaGASBuilder();

        Scanner sc = new Scanner(System.in);


        System.out.println("1. ATMega32 with load sensor");
        System.out.println("2. Arduino with weight module");
        System.out.println("3. Raspberry Pi with load sensor");
        System.out.println("4. Raspberry Pi with weight module");

        String input = sc.nextLine();
        String connection = "wifi";
        String framework = "django";

        if (input.equals("1")){
            System.out.println("1. WiFi");
            System.out.println("2. Sim Card GSM");
            input = sc.nextLine();

            if (input.equals("1")){
                connection = "wifi";
            }
            else if (input.equals("2")){
                connection = "gsm";
            }

            System.out.println("1. Django");
            System.out.println("2. Spring");
            System.out.println("3. Laravel");

            input = sc.nextLine();

            if (input.equals("1")){
                framework = "django";
            }
            else if (input.equals("2")){
                framework = "spring";
            }
            else if (input.equals("3")){
                framework = "laravel";
            }
            director.setRequirement(connection, framework);
            director.constructSilver(builder);
        }
        else if (input.equals("2")){

            System.out.println("1. WiFi");
            System.out.println("2. Sim Card GSM");
            input = sc.nextLine();

            if (input.equals("1")){
                connection = "wifi";
            }
            else if (input.equals("2")){
                connection = "gsm";
            }

            System.out.println("1. Django");
            System.out.println("2. Spring");
            System.out.println("3. Laravel");

            input = sc.nextLine();

            if (input.equals("1")){
                framework = "django";
            }
            else if (input.equals("2")){
                framework = "spring";
            }
            else if (input.equals("3")){
                framework = "laravel";
            }

            director.setRequirement(connection, framework);
            director.constructGold(builder);
        }
        else if (input.equals("3")){

            System.out.println("1. WiFi");
            System.out.println("2. Sim Card GSM");
            System.out.println("3. Ethernet");

            input = sc.nextLine();

            if (input.equals("1")){
                connection = "wifi";
            }
            else if (input.equals("2")){
                connection = "gsm";
            }
            else if (input.equals("3")){
                connection = "ethernet";
            }

            System.out.println("1. Django");
            System.out.println("2. Spring");
            System.out.println("3. Laravel");

            input = sc.nextLine();

            if (input.equals("1")){
                framework = "django";
            }
            else if (input.equals("2")){
                framework = "spring";
            }
            else if (input.equals("3")){
                framework = "laravel";
            }

            director.setRequirement(connection, framework);
            director.constructDiamond(builder);
        }
        else if (input.equals("4")) {

            System.out.println("1. WiFi");
            System.out.println("2. Sim Card GSM");
            System.out.println("3. Ethernet");

            input = sc.nextLine();

            if (input.equals("1")){
                connection = "wifi";
            }
            else if (input.equals("2")){
                connection = "gsm";
            }
            else if (input.equals("3")){
                connection = "ethernet";
            }

            System.out.println("1. Django");
            System.out.println("2. Spring");
            System.out.println("3. Laravel");

            input = sc.nextLine();

            if (input.equals("1")){
                framework = "django";
            }
            else if (input.equals("2")){
                framework = "spring";
            }
            else if (input.equals("3")){
                framework = "laravel";
            }
            director.setRequirement(connection, framework);
            director.constructPlatinum(builder);
        }

        TeaGAS teaGAS = builder.getResult();
        teaGAS.getTeaGASPrint();
    }
}
