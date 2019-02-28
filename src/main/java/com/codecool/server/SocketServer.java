package com.codecool.server;

import java.io.*;
import java.net.*;

// Server class 
public class SocketServer
{
    public void run() throws IOException
    {
        // server is listening on port 5056 
        ServerSocket ss = new ServerSocket(5056);

        // running infinite loop for getting 
        // client request 
        while (true)
        {
            Socket s = null;

            try
            {
                // socket object to receive incoming client requests 
                s = ss.accept();

                System.out.println("A new client is connected : " + s);

                // obtaining input and out streams 


                System.out.println("Assigning new thread for this client");

                // create a new thread object

                Thread t = new ClientHandler(s, new ObjectInputStream(s.getInputStream()));

                // Invoking the start() method 
                t.run();

            }
            catch (Exception e){
                s.close();
                e.printStackTrace();
            }
        }
    }
}

