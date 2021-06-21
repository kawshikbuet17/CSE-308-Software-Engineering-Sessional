package serverPkg;

import stockPkg.Stock;
import userPkg.User;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Server {
    public static List<Stock> stocks;
    public static List<Socket> connectionSockets;
    public static List<User> users;
    public static void main(String[] args) throws Exception {
        File fileObj = new File("stock.txt");
        stocks = new ArrayList<Stock>();
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

        ServerSocket welcomeSocket = new ServerSocket(1705);
        connectionSockets = new ArrayList<>();
        users = new ArrayList<>();
        int userCount = 0;

        ServerInputThread serverInputThread = new ServerInputThread();
        serverInputThread.start();

        while(true){
            Socket connectionSocket = welcomeSocket.accept();
            connectionSockets.add(connectionSocket);
            userCount++;
            System.out.println("user"+userCount + " connected");
            User currentUser = new User("user"+userCount, connectionSocket);
            users.add(currentUser);
            ServerClientInteraction serverClientInteraction = new ServerClientInteraction(connectionSocket, currentUser);
            serverClientInteraction.start();
        }
    }
}
