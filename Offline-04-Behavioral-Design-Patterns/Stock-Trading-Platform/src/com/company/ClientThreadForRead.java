package com.company;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientThreadForRead extends Thread {
    Socket clientSocket;
    public ClientThreadForRead(Socket clientSocket){
        this.clientSocket = clientSocket;
    }
    @Override
    public void run() {
        String modifiedSentence;
        try (BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
            while (true) {
                modifiedSentence = inFromServer.readLine();
                System.out.print(">>");
                System.out.println(modifiedSentence);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
