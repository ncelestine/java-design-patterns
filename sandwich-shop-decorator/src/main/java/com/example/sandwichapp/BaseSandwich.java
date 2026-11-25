// BaseSandwich.java
package com.example.sandwichapp;


 //Basic sandwich class implementing SandwichComponent.
 // Acts as the starting point for adding components (bread, toppings, etc.)
public class BaseSandwich implements SandwichComponent {
    private double baseCost;
    private String sandwichType;

    public BaseSandwich(double baseCost, String sandwichType) {
        this.baseCost = baseCost;
        this.sandwichType = sandwichType;
    }

    @Override
    public double getCost() {
        return baseCost;
    }

    @Override
    public String getDescription() {
        return sandwichType; // Display chosen sandwich type
    }
}


