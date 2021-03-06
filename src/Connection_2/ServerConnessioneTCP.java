/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection_2;

import Connection.*;
import java.io.*;
import java.net.*;
import java.util.*;

/**
 *
 * @author 
 */
public class ServerConnessioneTCP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // porta del server maggiore di 1024 
        int port=2000;
        //oggetto ServerSocket necessario per accettare richieste dal client
        ServerSocket sSocket = null;
        //oggetto da usare per realizzare la connessione TCP
        Socket connection;

        while(true){
            try{
                // il server si mette in ascolto sulla porta voluta
                sSocket = new ServerSocket(port);
                System.out.println("In attesa di connessioni!");
                //si è stabilita la connessione
                connection = sSocket.accept();
                System.out.println("Connessione stabilita!");
                //System.out.println("Socket server: " + connection.getLocalSocketAddress());
                //System.out.println("Socket client: " + connection.getRemoteSocketAddress());
                BufferedReader input = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                
                String s = input.readLine();
                System.out.println("\nIl messaggio che ho ricevuto e': " +s + "\n");
            }
               catch(IOException e){
                   System.err.println("Errore di I/O!");
            }
            
            //chiusura della connessione con il client
            try {
                if (sSocket!=null) sSocket.close();
            } catch (IOException ex) {
                System.err.println("Errore nella chiusura della connessione!");
            }
            System.out.println("Connessione chiusa!\n");
        }
      }
}
