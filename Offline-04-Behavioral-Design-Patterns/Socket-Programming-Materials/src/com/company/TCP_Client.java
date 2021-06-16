package com.company;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class TCP_Client {

    public static void main(String[] args) throws IOException {
        String sentence;
        String modifiedSentence;

        //client input buffer
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));

        //connect to server
        Socket clientSocket = new Socket("localhost", 6789);

        //which will be received by server as input
        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());

        //which will be received by client from server
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        //take input
        sentence = inFromUser.readLine();

        //send to server
        outToServer.writeBytes(sentence+'\n');

        //receive from server
        modifiedSentence = inFromServer.readLine();

        System.out.println("From Server: "+modifiedSentence);
        clientSocket.close();
    }
}
