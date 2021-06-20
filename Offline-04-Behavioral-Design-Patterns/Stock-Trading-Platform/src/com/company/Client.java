package com.company;

import java.io.IOException;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket clientSocket = new Socket("localhost", 1705);
        System.out.println("Connected to Stock Server");

        ClientThreadForWrite ctfw = new ClientThreadForWrite(clientSocket);
        ctfw.start();

        ClientThreadForRead ctfr = new ClientThreadForRead(clientSocket);
        ctfr.start();
    }
}