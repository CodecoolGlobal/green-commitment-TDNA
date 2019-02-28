package com.codecool.client;

import com.codecool.common.TemperatureSensor;
import org.w3c.dom.Document;

import java.io.IOException;
import java.net.Socket;
import java.io.*;
import java.net.*;


// Client class
public class Client {
    public void run() throws IOException {
        try {

           /* Scanner scn = new Scanner(System.in);
            System.out.println("How many measurements would you like to send to the server?");
            // getting localhost ip
            String input = scn.nextLine();
            int intInput = Integer.parseInt(input);
            */
            InetAddress ip = InetAddress.getByName("localhost");

            // establish the connection with server port 5056
            Socket s = new Socket(ip, 5056);

            ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
            // obtaining input and out streams


            // the following loop performs the exchange of
            // information between client and client handler

            for(int i = 0; i< 10; i++) {
                TemperatureSensor sensor = new TemperatureSensor();
                Document document = sensor.readData();

                oos.writeObject(document);
                Thread.sleep(1000);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
