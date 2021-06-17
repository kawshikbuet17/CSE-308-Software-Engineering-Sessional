package com.company;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientPointRunner {

    public static void main(String[] args) throws IOException {
        String sentence;
        String modifiedSentence;

        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));

        Socket clientSocket = new Socket("localhost", 6789);
        System.out.println("Connected to Stock Server");
        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        while(true){
            sentence = inFromUser.readLine();
            if(sentence.equalsIgnoreCase("exit")){
                break;
            }
            outToServer.writeBytes(sentence+'\n');
            modifiedSentence = inFromServer.readLine();
            System.out.println("From Server: "+modifiedSentence);
        }
        clientSocket.close();
    }
}