package com.codecool;


import com.codecool.client.Client;
import com.codecool.common.TemperatureSensor;

import java.util.stream.Collectors;

public class Main {
    private static final String CLIENT = "CLIENT";
    private static final String SERVER = "SERVER";
    private static final String Temperature = "Temperature";


    public static void main(String[] args) throws Exception {

        if (args.length == 0) {
            System.err.println("First argument must be there");
        } else {
            String mode = args[0];
            try {
                switch (mode) {
                    case CLIENT:
                        break;
                    case Temperature:
                        TemperatureSensor temp = new TemperatureSensor();
                        temp.readData();
                        break;
                    default:
                        System.err.println("Mode not implemented: " + mode);
                        break;
                }
            } catch (IllegalArgumentException ex) {
                System.err.println("Wrong argument: " + ex.getMessage());
            }
        }

    }
}
