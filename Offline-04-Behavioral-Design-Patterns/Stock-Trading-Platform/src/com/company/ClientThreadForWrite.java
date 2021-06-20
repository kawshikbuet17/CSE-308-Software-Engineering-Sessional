package com.company;

import java.io.*;
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

        PrintWriter outToServer = null;
        try {
            outToServer = new PrintWriter(clientSocket.getOutputStream());
            while (true) {
                System.out.print("<<");
                sentence = inFromUser.readLine();
                if (sentence.equalsIgnoreCase("exit")) {
                    break;
                }
                outToServer.println(sentence + '\n');
                outToServer.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
