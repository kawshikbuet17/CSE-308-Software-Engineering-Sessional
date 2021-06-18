package com.company;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ServerPointRunner {
    public static void main(String[] args) throws Exception {
        File fileObj = new File("stock.txt");
        List<Stock> stocks = new ArrayList<Stock>();
        try {
            Scanner sc = new Scanner(fileObj);
            while (sc.hasNextLine()){
                String input = sc.nextLine();
                String[] arr = input.split("\\ ");
                Stock stock = new Stock(arr[0], Integer.parseInt(arr[1]), Double.parseDouble(arr[2]));
                stocks.add(stock);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File input error");
            e.printStackTrace();
        }

        ServerSocket welcomeSocket = new ServerSocket(6789);

        int userCount = 0;
        while(true){
            Socket connectionSocket = welcomeSocket.accept();
            userCount++;
            System.out.println("user"+userCount + " connected");
            User currentUser = new User("user"+userCount);
            MultiThreading t1 = new MultiThreading(connectionSocket, stocks, currentUser);
            t1.start();
        }
    }
}
