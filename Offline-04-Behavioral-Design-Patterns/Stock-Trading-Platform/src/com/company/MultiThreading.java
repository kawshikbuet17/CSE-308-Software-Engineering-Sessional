package com.company;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class MultiThreading extends Thread{
    Socket connectionSocket;
    List<Stock> stocks;
    User currentUser;

    public MultiThreading(Socket connectionSocket, List<Stock>stocks, User currentUser){
        this.connectionSocket = connectionSocket;
        this.stocks = new ArrayList<Stock>();
        this.stocks = stocks;
        this.currentUser = currentUser;
    }
    public void run() {
        String clientSentence;
        String capitalizedSentence;
        while(true){
            try {
                BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
                DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
                clientSentence = inFromClient.readLine();
                String []arr = clientSentence.split("\\ ");

                capitalizedSentence = "";
                if(arr[0].equalsIgnoreCase("S")){
                    for(int i=0; i<stocks.size(); i++){
                        if(stocks.get(i).getName().equalsIgnoreCase(arr[1])){
                            Stock st = stocks.get(i);
//                            st.Register(currentUser);
                            currentUser.Subscribe(st);
                            capitalizedSentence = "Subscribed to Stock "+st.getName()+'\n';
                            outToClient.writeBytes(capitalizedSentence);
                        }
                    }
                }
                else if(arr[0].equalsIgnoreCase("U")){
                    for(int i=0; i<stocks.size(); i++){
                        if(stocks.get(i).getName().equalsIgnoreCase(arr[1])){
                            Stock st = stocks.get(i);
//                            st.UnRegister(currentUser);
                            currentUser.UnSubscribe(st);
                            capitalizedSentence = "UnSubscribed from Stock "+st.getName()+'\n';
                            outToClient.writeBytes(capitalizedSentence);
                        }
                    }
                }
                else {
                    capitalizedSentence = "Notifications: "+'\n';
                    outToClient.writeBytes(capitalizedSentence);
                }
            } catch (IOException e) {
                System.out.println("Something went wrong");
                e.printStackTrace();
            }
        }
    }
}
