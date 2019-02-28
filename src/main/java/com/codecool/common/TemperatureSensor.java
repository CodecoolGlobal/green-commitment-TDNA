package com.codecool.common;

import org.w3c.dom.Document;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TemperatureSensor extends Sensor {

    public TemperatureSensor() {
        this.id = 300;
        this.type = "Temperature sensor";
    }

    @Override
    public Document readData() {
        Document doc;
        SensorParser parser = new SensorParser();
        long yourmilliseconds = System.currentTimeMillis();
        System.out.println(yourmilliseconds);
        int data = generateRandomNumber(-25, 40);

        doc = parser.createDocument(id, yourmilliseconds, data, type);

        return doc;
    }
}
