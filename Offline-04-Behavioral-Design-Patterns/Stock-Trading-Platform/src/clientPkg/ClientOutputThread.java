package clientPkg;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientOutputThread extends Thread {
    private Socket clientSocket;
    public ClientOutputThread(Socket clientSocket){
        this.clientSocket = clientSocket;
    }
    @Override
    public void run() {
        String receiveFromServer;
        try (BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
            while (true) {
                receiveFromServer = inFromServer.readLine();
                System.out.println(receiveFromServer);
                System.out.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
