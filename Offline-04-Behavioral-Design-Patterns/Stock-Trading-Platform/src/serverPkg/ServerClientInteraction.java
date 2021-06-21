package serverPkg;

import userPkg.User;

import java.io.*;
import java.net.Socket;

public class ServerClientInteraction extends Thread{
    private Socket connectionSocket;
    private User currentUser;
    private BufferedReader inFromClient;
    private PrintWriter outToClient;
    private String receiveFromClient;
    private String sendToClient;

    public ServerClientInteraction(Socket connectionSocket, User currentUser) throws IOException {
        this.connectionSocket = connectionSocket;
        for(int i=0; i<Server.users.size(); i++){
            if(Server.users.get(i).getName().equalsIgnoreCase(currentUser.getName())){
                this.currentUser = Server.users.get(i);
                break;
            }
        }
        inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
        outToClient = new PrintWriter(connectionSocket.getOutputStream());
    }

    public void Subscribe(String[] arr) throws IOException {
        for(int i = 0; i< Server.stocks.size(); i++){
            if(Server.stocks.get(i).getName().equalsIgnoreCase(arr[1])){
                currentUser.Subscribe(Server.stocks.get(i));
                sendToClient = "Subscribed to Stock "+ Server.stocks.get(i).getName()+'\n';
                System.out.println(currentUser.getName()+" "+ sendToClient);
                outToClient.println(sendToClient);
                outToClient.flush();
            }
        }
    }

    public void UnSubscribe(String[] arr) throws IOException {
        for(int i = 0; i< Server.stocks.size(); i++){
            if(Server.stocks.get(i).getName().equalsIgnoreCase(arr[1])){
                currentUser.UnSubscribe(Server.stocks.get(i));
                sendToClient = "UnSubscribed from Stock "+ Server.stocks.get(i).getName()+'\n';
                System.out.println(currentUser.getName()+" "+ sendToClient);
                outToClient.println(sendToClient);
                outToClient.flush();
            }
        }
    }

    public void run() {
        while(true){
            try {
                receiveFromClient = inFromClient.readLine();
                String []arr = receiveFromClient.split("\\ ");
                if(arr[0].equalsIgnoreCase("S")){
                    Subscribe(arr);
                }
                else if(arr[0].equalsIgnoreCase("U")){
                    UnSubscribe(arr);
                }
            } catch (IOException e) {
                System.out.println("Something went wrong");
                e.printStackTrace();
            }
        }
    }
}
