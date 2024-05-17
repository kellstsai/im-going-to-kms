package com.example;

public class ExtraTopping extends FoodDecorator {
    public ExtraTopping(Food decoratedFood) {
        super(decoratedFood);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " with extra topping";
    }

    @Override
    public double getCost() {
        return super.getCost() + 2.0;
    }
}
