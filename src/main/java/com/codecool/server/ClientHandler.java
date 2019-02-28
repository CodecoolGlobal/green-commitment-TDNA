package com.codecool.server;

import com.codecool.common.Chart;
import com.codecool.common.SensorParser;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

// ClientHandler class
class ClientHandler extends Thread {
    final ObjectInputStream ois;
    final Socket s;
    private SensorParser sensorParser;
    private List<Document> listOfMeasurements = new ArrayList<>();


    // Constructor
    public ClientHandler(Socket s, ObjectInputStream ois) {
        this.s = s;
        this.ois = ois;
    }

    @Override
    public void run() {
        String type = "";
        sensorParser = new SensorParser();
        for(int i = 0; i<10; i++) {
            Document receivedDoc = null;
            try {
                receivedDoc = (Document) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
            sensorParser.parseDocument(receivedDoc);
            listOfMeasurements.add(receivedDoc);
        }

        for(Document doc : listOfMeasurements) {
            System.out.println(doc.getDocumentElement().getAttribute("id"));
            System.out.println(doc.getDocumentElement().getChildNodes().item(0).getChildNodes().item(0).getTextContent());
            System.out.println(doc.getDocumentElement().getChildNodes().item(0).getChildNodes().item(1).getTextContent());
            System.out.println(doc.getDocumentElement().getChildNodes().item(0).getChildNodes().item(2).getTextContent());
            type = doc.getDocumentElement().getChildNodes().item(0).getChildNodes().item(2).getTextContent();
        }
        try {
            Chart.run(listOfMeasurements, type);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

