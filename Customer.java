package com.example;

public class Customer implements Participant {
    public String name;
    public String dietaryRestrictions;
    public String county;

    public Customer(String name, String dietaryRestrictions, String county) {
        this.name = name;
        this.dietaryRestrictions = dietaryRestrictions;
        this.county = county;
    }

    @Override
    public void register() {
        System.out.println("Customer " + name + " registered with CPPFoodDelivery");
    }

    @Override
    public String toString() {
        return name;
    }

    public String getDietaryRestrictions() {
        return dietaryRestrictions;
    }

    public String getCounty() {
        return county; 
    }
}

