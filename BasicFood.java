package com.example;

public class BasicFood implements Food {
    @Override
    public String getDescription() {
        return "Basic Food";
    }

    @Override
    public double getCost() {
        return 10.0;
    }
}
