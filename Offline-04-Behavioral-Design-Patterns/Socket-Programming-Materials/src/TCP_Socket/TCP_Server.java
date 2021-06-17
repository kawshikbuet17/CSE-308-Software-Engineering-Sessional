package TCP_Socket;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Locale;

public class TCP_Server {
    public static void main(String[] args) throws Exception{
        String clientSentence;
        String capitalizedSentence;

        //set socket no
        ServerSocket welcomeSocket = new ServerSocket(6789);
        while(true){
            //accept connection request
            Socket connectionSocket = welcomeSocket.accept();

            //server input buffer
            BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));

            //which will be sent to client
            DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());

            //get input from client
            clientSentence = inFromClient.readLine();

            //do operation
            capitalizedSentence = clientSentence.toUpperCase()+'\n';

            //send to client
            outToClient.writeBytes(capitalizedSentence);
        }
    }
}
