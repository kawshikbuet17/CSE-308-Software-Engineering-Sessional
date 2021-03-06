package serverPkg;

import java.io.IOException;
import java.util.Scanner;

public class ServerInputThread extends Thread{
    @Override
    public void run(){
        while (true){
            try{
                Scanner sc = new Scanner(System.in);
                String input;
                input = sc.nextLine();
                String []arr = input.split("\\ ");
                if(arr[0].equalsIgnoreCase("I")){
                    IncreasePrice(arr);
                }
                else if(arr[0].equalsIgnoreCase("D")){
                    DecreasePrice(arr);
                }
                else if(arr[0].equalsIgnoreCase("C")){
                    ChangeCount(arr);
                }
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    public void IncreasePrice(String[] arr) throws IOException {
        for(int i = 0; i< Server.stocks.size(); i++){
            if(Server.stocks.get(i).getName().equalsIgnoreCase(arr[1])){
                Server.stocks.get(i).IncreasePrice(Double.parseDouble(arr[2]));
            }
        }
    }
    public void DecreasePrice(String[] arr) throws IOException {
        for(int i = 0; i< Server.stocks.size(); i++){
            if(Server.stocks.get(i).getName().equalsIgnoreCase(arr[1])){
                Server.stocks.get(i).DecreasePrice(Double.parseDouble(arr[2]));
            }
        }
    }

    public void ChangeCount(String[] arr) throws IOException {
        for(int i = 0; i< Server.stocks.size(); i++){
            if(Server.stocks.get(i).getName().equalsIgnoreCase(arr[1])){
                Server.stocks.get(i).ChangeCount(Integer.parseInt(arr[2]));
            }
        }
    }
}
