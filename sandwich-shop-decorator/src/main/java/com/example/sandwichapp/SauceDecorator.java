package com.example.sandwichapp;


public class SauceDecorator extends SandwichDecorator {
    private final String sauce;
    private final double sauceCost;

    public SauceDecorator(SandwichComponent sandwich, String sauce, double sauceCost) {
        super(sandwich);
        this.sauce = sauce;
        this.sauceCost = sauceCost;
    }

    @Override
    public double getCost() {
        return super.getCost() + sauceCost;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Sauce: " + sauce;
    }
}
