package com.codecool.common;

import org.w3c.dom.Document;

import java.util.concurrent.ThreadLocalRandom;

public abstract class Sensor{

    int id;
    String type;
    String name;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Sensor(int id, String type, String name) {
        this.id = id;
        this.type = type;
        this.name = name;
    }

    public Sensor(){}

    public abstract Document readData();

    double generateRandomNumber(double minNumber, double maxNumber){
        return ThreadLocalRandom.current().nextDouble(minNumber, maxNumber);
    }

    long currentTimeMillis(){
        return System.currentTimeMillis();
    }
}
