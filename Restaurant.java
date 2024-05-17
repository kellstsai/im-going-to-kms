package com.example;

import java.time.LocalTime;
import java.util.List; 

public class Restaurant implements Participant {
    public String name;
    public String address;
    public String county;
    public String operatingHours;
    public String cuisineType;
    public List<String> menu;
    public LocalTime openingTime;
    public LocalTime closingTime; 


    public Restaurant(String name, String address, String county, String openingTime, String closingTime, String cuisineType, List<String> menu) {
        this.name = name;
        this.address = address;
        this.county = county;
        this.openingTime = LocalTime.parse(openingTime);
        this.closingTime = LocalTime.parse(closingTime);
        this.cuisineType = cuisineType;
        this.menu = menu;
    }

    @Override
    public void register() {
        System.out.println("Restaurant " + name + " registered with CPPFoodDelivery");
    }

    public String getAddress() {
        return address;
    }

    public String getCounty() {
        return county;
    }

    public String getOperatingHours() {
        return operatingHours;
    }

    public String getCuisineType() {
        return cuisineType;
    }

    public List<String> getMenu() {
        return menu;
    }

    public boolean isOperatingHours(LocalTime currentTime) {
        return currentTime.isAfter(openingTime) && currentTime.isBefore(closingTime);
    }

    public String getName() {
        return name; 
    }
}
