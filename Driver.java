package com.example;

import java.time.LocalTime;

public class Driver implements Participant {
    public String name;
    public String shift;
    public String county;

    public Driver(String name, String shift, String county) {
        this.name = name;
        this.shift = shift;
        this.county = county;
    }

    @Override
    public void register() {
        System.out.println("Driver " + name + " registered with CPPFoodDelivery");
    }

    @Override
    public String toString() {
        return name;
    }

    public String getShift() {
        return shift;
    }

    public String getCounty() {
        return county;
    }

    public boolean isAvailable(LocalTime currentTime) {
        switch (shift) {
            case "1st shift":
                return currentTime.isAfter(LocalTime.parse("08:00")) && currentTime.isBefore(LocalTime.parse("16:00"));
            case "2nd shift":
                return currentTime.isAfter(LocalTime.parse("16:00")) && currentTime.isBefore(LocalTime.parse("00:00"));
            case "3rd shift":
                return currentTime.isAfter(LocalTime.parse("00:00")) && currentTime.isBefore(LocalTime.parse("08:00"));
            default:
                return false;
        }
    }

    public boolean canDeliverToCounty(String customerCounty) {
        return county.equals(customerCounty);
    }
}

