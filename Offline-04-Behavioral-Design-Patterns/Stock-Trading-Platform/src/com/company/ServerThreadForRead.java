package com.company;

import java.io.*;
import java.net.Socket;
import java.util.List;

public class ServerThreadForRead extends Thread{
    Socket connectionSocket;
    User currentUser;
    BufferedReader inFromClient;
    PrintWriter outToClient;
    private String fromClientSentence;
    private String toClientSentence;

    public ServerThreadForRead(Socket connectionSocket, User currentUser) throws IOException {
        this.connectionSocket = connectionSocket;
        for(int i=0; i<Server.users.size(); i++){
            if(Server.users.get(i).getName().equalsIgnoreCase(currentUser.getName())){
                this.currentUser = Server.users.get(i);
                break;
            }
        }
        inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
        outToClient = new PrintWriter(connectionSocket.getOutputStream());
    }
    public void Subscribe(String[] arr) throws IOException {
        for(int i = 0; i< Server.stocks.size(); i++){
            if(Server.stocks.get(i).getName().equalsIgnoreCase(arr[1])){
                currentUser.Subscribe(Server.stocks.get(i));
                toClientSentence = "Subscribed to Stock "+ Server.stocks.get(i).getName()+'\n';
                System.out.println(currentUser.name+" "+toClientSentence);
                outToClient.println(toClientSentence);
                outToClient.flush();
            }
        }
    }
    public void UnSubscribe(String[] arr) throws IOException {
        for(int i = 0; i< Server.stocks.size(); i++){
            if(Server.stocks.get(i).getName().equalsIgnoreCase(arr[1])){
                currentUser.UnSubscribe(Server.stocks.get(i));
                toClientSentence = "UnSubscribed from Stock "+ Server.stocks.get(i).getName()+'\n';
                System.out.println(currentUser.name+" "+toClientSentence);
                outToClient.println(toClientSentence);
                outToClient.flush();
            }
        }
    }
//    public void IncreasePrice(String[] arr) throws IOException {
//        for(int i = 0; i< Server.stocks.size(); i++){
//            if(Server.stocks.get(i).getName().equalsIgnoreCase(arr[1])){
//                Server.stocks.get(i).IncreasePrice(Double.parseDouble(arr[2]));
//            }
//        }
//    }
//    public void DecreasePrice(String[] arr) throws IOException {
//        for(int i = 0; i< Server.stocks.size(); i++){
//            if(Server.stocks.get(i).getName().equalsIgnoreCase(arr[1])){
//                Server.stocks.get(i).DecreasePrice(Double.parseDouble(arr[2]));
//            }
//        }
//    }
//
//    public void ChangeCount(String[] arr) throws IOException {
//        for(int i = 0; i< Server.stocks.size(); i++){
//            if(Server.stocks.get(i).getName().equalsIgnoreCase(arr[1])){
//                Server.stocks.get(i).ChangeCount(Integer.parseInt(arr[2]));
//            }
//        }
//    }

    public void run() {
        while(true){
            try {
                fromClientSentence = inFromClient.readLine();
                String []arr = fromClientSentence.split("\\ ");

                if(arr[0].equalsIgnoreCase("S")){
                    Subscribe(arr);
                }
                else if(arr[0].equalsIgnoreCase("U")){
                    UnSubscribe(arr);
                }
//                else if(arr[0].equalsIgnoreCase("I")){
//                    IncreasePrice(arr);
//                }
//                else if(arr[0].equalsIgnoreCase("D")){
//                    DecreasePrice(arr);
//                }
//                else if(arr[0].equalsIgnoreCase("C")){
//                    ChangeCount(arr);
//                }
            } catch (IOException e) {
                System.out.println("Something went wrong");
                e.printStackTrace();
            }
        }
    }
}
