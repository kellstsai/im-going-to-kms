package com.example;

public class CPPFoodDeliverySystem {
    private static CPPFoodDeliverySystem instance;

    private CPPFoodDeliverySystem() {
        // private constructor to prevent instantiation
    }

    public static CPPFoodDeliverySystem getInstance() {
        if (instance == null) {
            instance = new CPPFoodDeliverySystem();
        }
        return instance;
    }

    // other system-specific methods can be added here
}
