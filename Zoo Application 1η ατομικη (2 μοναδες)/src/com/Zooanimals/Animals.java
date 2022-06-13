package com.Zooanimals;

import java.io.Serializable;

public class Animals implements Serializable {

    //Μεταβλητες

    private String code;
    public String animalname;
    public String species ;
    private double weight; //κιλα
    private int maxage; //χρονια

    //Setters(για private μεταβλητες μονο)

    public void setCode(String code) {
        this.code = code;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setMaxage(int maxage) {
        this.maxage = maxage;
    }

    //Getters(για private μεταβλητες μονο)

    public String getCode() {
        return code;
    }

    public double getWeight() {
        return weight;
    }

    public int getMaxage() {
        return maxage;
    }
}