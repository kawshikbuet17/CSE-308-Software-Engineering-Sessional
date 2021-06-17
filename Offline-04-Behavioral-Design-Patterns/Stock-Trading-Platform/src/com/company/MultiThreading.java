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

    public MultiThreading(Socket connectionSocket, List<Stock>stocks){
        this.connectionSocket = connectionSocket;
        this.stocks = new ArrayList<Stock>();
        this.stocks = stocks;
    }
    public void run() {
        String clientSentence;
        String capitalizedSentence;
        while(true){
            try {
                BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
                DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
                clientSentence = inFromClient.readLine();
                capitalizedSentence = clientSentence.toUpperCase()+'\n';
                outToClient.writeBytes(capitalizedSentence);
            } catch (IOException e) {
                System.out.println("Something went wrong");
                e.printStackTrace();
            }
        }
    }
}
