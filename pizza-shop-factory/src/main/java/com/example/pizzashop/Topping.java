package com.example.pizzashop;

/**
 * Topping class represents a topping option for the pizza.
 * Each topping has a fixed cost that contributes to the total cost of the pizza.
 */
public class Topping {
    // Name of the topping (e.g., Tomato, Extra Cheese)
    private String toppingName;
    // Cost of the topping
    private double toppingCost;

    public Topping(String toppingName) {
        this.toppingName = toppingName;
        this.toppingCost = 1.50; // Cost per topping
    }

    public double getToppingCost() {
        return toppingCost;
    }

    @Override
    public String toString() {
        return toppingName;
    }
}

