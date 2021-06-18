package com.company;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MultiThreading extends Thread{
    Socket connectionSocket;
    List<Stock> stocks;
    User currentUser;

    public MultiThreading(Socket connectionSocket, List<Stock>stocks, User currentUser){
        this.connectionSocket = connectionSocket;
        this.stocks = new ArrayList<Stock>();
        this.stocks = stocks;
        this.currentUser = currentUser;
    }
    public void run() {
        String clientSentence;
        String capitalizedSentence;
        String notifications = "NOTIFICATIONS: ";
        while(true){
            try {
                BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
                DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
                clientSentence = inFromClient.readLine();
                String []arr = clientSentence.split("\\ ");

                capitalizedSentence = "";
                if(arr[0].equalsIgnoreCase("S")){
                    for(int i=0; i<stocks.size(); i++){
                        if(stocks.get(i).getName().equalsIgnoreCase(arr[1])){
                            Stock st = stocks.get(i);
//                            st.Register(currentUser);
                            currentUser.Subscribe(st);
                            capitalizedSentence = "Subscribed to Stock "+st.getName()+'\n';
                            outToClient.writeBytes(capitalizedSentence);
                        }
                    }
                }
                else if(arr[0].equalsIgnoreCase("U")){
                    for(int i=0; i<stocks.size(); i++){
                        if(stocks.get(i).getName().equalsIgnoreCase(arr[1])){
                            Stock st = stocks.get(i);
//                            st.UnRegister(currentUser);
                            currentUser.UnSubscribe(st);
                            capitalizedSentence = "UnSubscribed from Stock "+st.getName()+'\n';
                            outToClient.writeBytes(capitalizedSentence);
                        }
                    }
                }
                else if(arr[0].equalsIgnoreCase("N")){
//                    notifications = currentUser.getNotifications();
                    System.out.println("Called for notification");
                    System.out.println(notifications);
                    outToClient.writeBytes(notifications);
                }

//                //stock updating
//                System.out.print("Server I/O: <Enter> to Skip\n<<");
//                Scanner sc = new Scanner(System.in);
//                String input = sc.nextLine();
//                String []inputs = input.split("\\ ");
//                if(input.equalsIgnoreCase("")){
//                    ;
//                }
//                else{
//                    for(int i=0; i<stocks.size(); i++){
//                        if(inputs[1].equalsIgnoreCase(stocks.get(i).getName())){
//                            Stock st = stocks.get(i);
//                            if(inputs[0].equalsIgnoreCase("I")){
//                                st.IncreasePrice(Double.parseDouble(inputs[2]));
//                                notifications = currentUser.getNotifications();
////                                System.out.println(notifications);
//                            }
//                            else if(inputs[0].equalsIgnoreCase("D")){
//                                st.DecreasePrice(Double.parseDouble(inputs[2]));
//                                notifications = currentUser.getNotifications();
////                                System.out.println(notifications);
//                            }
//                            else if(inputs[0].equalsIgnoreCase("C")){
//                                st.ChangeCount(Integer.parseInt(inputs[2]));
//                                notifications = currentUser.getNotifications();
////                                System.out.println(notifications);
//                            }
//                        }
//                    }
//                }
            } catch (IOException e) {
                System.out.println("Something went wrong");
                e.printStackTrace();
            }
        }
    }
}
