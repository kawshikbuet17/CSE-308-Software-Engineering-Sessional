package clientPkg;

import java.io.*;
import java.net.Socket;

public class ClientInputThread extends Thread {
    private Socket clientSocket;
    public ClientInputThread(Socket clientSocket){
        this.clientSocket = clientSocket;
    }
    @Override
    public void run() {
        String sendToServer;
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter outToServer = null;
        try {
            outToServer = new PrintWriter(clientSocket.getOutputStream());
            while (true) {
                sendToServer = inFromUser.readLine();
                outToServer.println(sendToServer + '\n');
                outToServer.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
