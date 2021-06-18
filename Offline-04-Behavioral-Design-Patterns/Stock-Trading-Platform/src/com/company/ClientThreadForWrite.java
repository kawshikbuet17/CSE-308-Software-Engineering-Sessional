package com.company;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientThreadForWrite extends Thread {
    Socket clientSocket;
    public ClientThreadForWrite(Socket clientSocket){
        this.clientSocket = clientSocket;
    }
    @Override
    public void run() {
        String sentence;
        String modifiedSentence;
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));

        DataOutputStream outToServer = null;
        try {
            outToServer = new DataOutputStream(clientSocket.getOutputStream());
            while (true) {
                System.out.print("<<");
                sentence = inFromUser.readLine();
                if (sentence.equalsIgnoreCase("exit")) {
                    break;
                }
                outToServer.writeBytes(sentence + '\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
