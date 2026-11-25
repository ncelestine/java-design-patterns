package com.example.pizzashop;

import java.util.ArrayList;
 // Abstract base class for Pizza.
 //Defines the structure and essential properties of a pizza, toppings, crust,  including size,  and membership discount.

public abstract class Pizza {
    // Pizza size
    protected String size;
    // Crust type
    protected String crust;
    // List of topping options
    protected ArrayList<String> toppings;
    // Shows if the customer has a membership card for discounts
    protected boolean memberCard;

    public Pizza(String size, String crust, ArrayList<String> toppings, boolean memberCard) {
        this.size = size;
        this.crust = crust;
        this.toppings = toppings;
        this.memberCard = memberCard;
    }

    // Abstract method to be implemented by subclasses to calculate the pizza's cost
    public abstract double calculateCost();

    @Override
    public String toString() {
        // Provides a formatted description of the pizza, including size, crust, toppings, and overall cost
        return "Size: " + size + ", Crust: " + crust + ", Toppings: " + toppings + ", Cost: $" + calculateCost();
    }
}
