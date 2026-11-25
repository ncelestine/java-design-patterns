package com.example.sandwichapp;

public class Extras extends SandwichDecorator {
    private final String extra;
    private final double extraCost;

    public Extras(SandwichComponent sandwich, String extra, double extraCost) {
        super(sandwich);
        this.extra = extra;
        this.extraCost = extraCost;
    }

    @Override
    public double getCost() {
        return super.getCost() + extraCost;
    }

    @Override
    public String getDescription() {
        //Adds extra topping to the sandiwch desription
        return super.getDescription() + ", Extra: " + extra;
    }
}
