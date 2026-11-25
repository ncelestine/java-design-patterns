// VegetableDecorator.java
package com.example.sandwichapp;


 // Decorator for adding vegetables to the sandwich.
 //Each vegetable adds a description and additional cost.

public class Vegetables extends SandwichDecorator {
    private final String vegetable;
    private final double vegetableCost;

    public Vegetables(SandwichComponent sandwich, String vegetable, double vegetableCost) {
        super(sandwich);
        this.vegetable = vegetable;
        this.vegetableCost = vegetableCost;
    }

    @Override
    public double getCost() {
        // Adds the cost of each vegetable to the total sandwich cost
        return super.getCost() + vegetableCost;
    }

    @Override
    public String getDescription() {
        // Adds each vegetable to the sandwich description
        return super.getDescription() + ", Vegetable: " + vegetable;
    }
}

