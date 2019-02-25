package com.codecool.common;

import org.w3c.dom.Document;

import java.util.concurrent.ThreadLocalRandom;

public abstract class Sensor{

    private int id;
    private String type;
    private double value;
    private boolean isStarted;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public void setStarted(boolean started) {
        isStarted = started;
    }


    public boolean isStarted() {
        return isStarted;
    }

    public String startStopSensor() {
        if (isStarted) {
            isStarted = false;
            return id + " sensor stopped!";
        } else {
            isStarted = true;
            return id + " sensor started!";
        }
    }

    public Sensor(int id, String type, double value, boolean isStarted) {
        this.id = id;
        this.type = type;
        this.value = value;
        this.isStarted = isStarted;
    }

    public abstract Document readData();

    double generateRandomNumber(double minNumber, double maxNumber){
        return ThreadLocalRandom.current().nextDouble(minNumber, maxNumber);
    }

    long currentTimeMillis(){
        return System.currentTimeMillis();
    }
}
