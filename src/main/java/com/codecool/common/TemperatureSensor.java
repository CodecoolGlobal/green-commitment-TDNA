package com.codecool.common;

import org.w3c.dom.Document;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TemperatureSensor extends Sensor {

    public TemperatureSensor() {
        this.id = 300;
        this.type = "Temperature";
        this.name = "Temperature Sensor";
    }

    @Override
    public Document readData() {
        Document doc;
        SensorParser parser = new SensorParser();
        long yourmilliseconds = System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd,yyyy HH:mm");
        Date resultDate = new Date(yourmilliseconds);
        System.out.println(resultDate);
        double data = generateRandomNumber(-25.00, 40.00);

        doc = parser.createDocument(id, name, resultDate, data, type);
        return doc;
    }
}
