package com.company;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.List;

public class ServerThreadForRead extends Thread{
    Socket connectionSocket;
    User currentUser;

    public ServerThreadForRead(Socket connectionSocket, User currentUser){
        this.connectionSocket = connectionSocket;
        this.currentUser = currentUser;
    }
    public void run() {
        String clientSentence;
        String capitalizedSentence;
        while(true){
            try {
                BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
                DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
                clientSentence = inFromClient.readLine();
                String []arr = clientSentence.split("\\ ");

                if(arr[0].equalsIgnoreCase("S")){
                    for(int i = 0; i< Server.stocks.size(); i++){
                        if(Server.stocks.get(i).getName().equalsIgnoreCase(arr[1])){
                            currentUser.Subscribe(Server.stocks.get(i));
                            capitalizedSentence = "Subscribed to Stock "+ Server.stocks.get(i).getName()+'\n';
                            System.out.println(currentUser.name+" "+capitalizedSentence);
                            outToClient.writeBytes(capitalizedSentence);
                        }
                    }
                }
                else if(arr[0].equalsIgnoreCase("U")){
                    for(int i = 0; i< Server.stocks.size(); i++){
                        if(Server.stocks.get(i).getName().equalsIgnoreCase(arr[1])){
                            currentUser.UnSubscribe(Server.stocks.get(i));
                            capitalizedSentence = "UnSubscribed from Stock "+ Server.stocks.get(i).getName()+'\n';
                            System.out.println(currentUser.name+" "+capitalizedSentence);
                            outToClient.writeBytes(capitalizedSentence);
                        }
                    }
                }

                else if(arr[0].equalsIgnoreCase("I")){
                    for(int i = 0; i< Server.stocks.size(); i++){
                        if(Server.stocks.get(i).getName().equalsIgnoreCase(arr[1])){
                            Server.stocks.get(i).IncreasePrice(Double.parseDouble(arr[2]));
                            capitalizedSentence = "Stock Value of "+ Server.stocks.get(i).getName()+" Changed to "+ Server.stocks.get(i).getPrice() +'\n';
                            for(int j = 0; j< Server.connectionSockets.size(); j++){
                                if(connectionSocket != Server.connectionSockets.get(j)){
                                    boolean present = false;
                                    List<User> temp = Server.stocks.get(i).getSubscriber();
                                    for(int k=0; k<temp.size(); k++){
                                        if(temp.get(k).name.equalsIgnoreCase(Server.users.get(j).name)){
                                            present = true;
                                            break;
                                        }
                                    }
                                    if(present){
                                        DataOutputStream outToClientEach = new DataOutputStream(Server.connectionSockets.get(j).getOutputStream());
                                        outToClientEach.writeBytes(capitalizedSentence);
                                    }
                                }
                            }
                            outToClient.writeBytes(capitalizedSentence);
                        }
                    }
                }

                else if(arr[0].equalsIgnoreCase("D")){
                    for(int i = 0; i< Server.stocks.size(); i++){
                        if(Server.stocks.get(i).getName().equalsIgnoreCase(arr[1])){
                            Server.stocks.get(i).DecreasePrice(Double.parseDouble(arr[2]));
                            capitalizedSentence = "Stock Value of "+ Server.stocks.get(i).getName()+" Changed to "+ Server.stocks.get(i).getPrice() +'\n';
                            for(int j = 0; j< Server.connectionSockets.size(); j++){
                                if(connectionSocket != Server.connectionSockets.get(j)){
                                    boolean present = false;
                                    List<User> temp = Server.stocks.get(i).getSubscriber();
                                    for(int k=0; k<temp.size(); k++){
                                        if(temp.get(k).name.equalsIgnoreCase(Server.users.get(j).name)){
                                            present = true;
                                            break;
                                        }
                                    }
                                    if(present){
                                        DataOutputStream outToClientEach = new DataOutputStream(Server.connectionSockets.get(j).getOutputStream());
                                        outToClientEach.writeBytes(capitalizedSentence);
                                    }
                                }
                            }
                            outToClient.writeBytes(capitalizedSentence);
                        }
                    }
                }

                else if(arr[0].equalsIgnoreCase("C")){
                    for(int i = 0; i< Server.stocks.size(); i++){
                        if(Server.stocks.get(i).getName().equalsIgnoreCase(arr[1])){
                            Server.stocks.get(i).ChangeCount(Integer.parseInt(arr[2]));
                            capitalizedSentence = "Stock Count of "+ Server.stocks.get(i).getName()+" Changed to "+ Server.stocks.get(i).getPrice() +'\n';
                            for(int j = 0; j< Server.connectionSockets.size(); j++){
                                if(connectionSocket != Server.connectionSockets.get(j)){
                                    boolean present = false;
                                    List<User> temp = Server.stocks.get(i).getSubscriber();
                                    for(int k=0; k<temp.size(); k++){
                                        if(temp.get(k).name.equalsIgnoreCase(Server.users.get(j).name)){
                                            present = true;
                                            break;
                                        }
                                    }
                                    if(present){
                                        DataOutputStream outToClientEach = new DataOutputStream(Server.connectionSockets.get(j).getOutputStream());
                                        outToClientEach.writeBytes(capitalizedSentence);
                                    }
                                }
                            }
                            outToClient.writeBytes(capitalizedSentence);
                        }
                    }
                }
            } catch (IOException e) {
                System.out.println("Something went wrong");
                e.printStackTrace();
            }
        }
    }
}
