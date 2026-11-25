// BreadDecorator.java
package com.example.sandwichapp;


 // adding a specific bread type to the sandwich.
 // Adds both description and additional cost based on bread type.

public class BreadType extends SandwichDecorator {
    private final String breadType;
    private final double breadCost;

    public BreadType(SandwichComponent sandwich, String breadType, double breadCost) {
        super(sandwich);
        this.breadType = breadType;
        this.breadCost = breadCost;
    }

    @Override
    public double getCost() {
        // Adds the cost of the bread to the total sandwich cost
        return super.getCost() + breadCost;
    }

    @Override
    public String getDescription() {
        // Adds the bread type to the sandwich description
        return super.getDescription() + ", Bread: " + breadType;
    }
}


