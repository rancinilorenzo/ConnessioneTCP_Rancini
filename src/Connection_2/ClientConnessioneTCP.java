/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection_2;

import Connection.*;
import java.io.*;
import java.net.*;

/**
 *
 * @author 
 */
public class ClientConnessioneTCP {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        //oggetto da usare per realizzare la connessione TCP
        Socket connection = null;
        //nome o IP del server
        String serverAddress = "localhost";
        //porta del server in ascolto
        int port = 2000;

        //apertura della connessione al server sulla porta specificata
        try{
            connection = new Socket(serverAddress, port);
            System.out.println("Connessione aperta");
            
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Inserisci il messaggio da spedire: ");
            String messaggio = in.readLine();
                  
            BufferedWriter output = new BufferedWriter (new OutputStreamWriter(connection.getOutputStream()));
            
            output.write(messaggio);
        }
        
        catch(ConnectException e){
            System.err.println("Server non disponibile!");
        }
        
        catch(UnknownHostException e1){
            System.err.println("Errore DNS!");
        }

        catch(IOException e2){//
            System.err.println(e2);
            e2.printStackTrace();
        }

        //chiusura della connnessione
        finally{
                try {
            if (connection!=null)
                {
                    connection.close();
                    System.out.println("Connessione chiusa!");
                }
            }
            catch(IOException e){
                System.err.println("Errore nella chiusura della connessione!");
            }
        }
    }
}
