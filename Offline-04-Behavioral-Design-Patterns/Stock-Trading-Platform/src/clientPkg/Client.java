package clientPkg;

import java.io.IOException;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket clientSocket = new Socket("localhost", 1705);
        System.out.println("Connected to Stock Server");

        ClientInputThread clientInputThread = new ClientInputThread(clientSocket);
        clientInputThread.start();

        ClientOutputThread clientOutputThread = new ClientOutputThread(clientSocket);
        clientOutputThread.start();
    }
}