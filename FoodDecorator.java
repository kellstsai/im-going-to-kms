package com.example;

public abstract class FoodDecorator implements Food {
    protected Food decoratedFood;

    public FoodDecorator(Food decoratedFood) {
        this.decoratedFood = decoratedFood;
    }

    public String getDescription() {
        return decoratedFood.getDescription();
    }

    public double getCost() {
        return decoratedFood.getCost();
    }
}
