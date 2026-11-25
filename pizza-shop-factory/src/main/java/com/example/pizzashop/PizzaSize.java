package com.example.pizzashop;

import java.util.ArrayList;

/**
 * PizzaSize class extends the Pizza abstract class.
 * Represents a customizable pizza with specific size, crust, toppings, and discounts.
 * Calculates the cost based on size, crust type, number of toppings, and membership discounts.
 */
public class PizzaSize extends Pizza {
    private CrustType crustType; // Crust type represented as a CrustType object

    public PizzaSize(String size, String crust, ArrayList<Topping> toppings, boolean memberCard) {
        super(size, crust, new ArrayList<>(), memberCard);
        this.crustType = new CrustType(crust);

        // Convert Topping objects to their names for display in toString()
        for (Topping topping : toppings) {
            this.toppings.add(topping.toString());
        }
    }

    @Override
    public double calculateCost() {
        // Base cost depends on the pizza size
        double baseCost = switch (size) {
            case "Small" -> 25.00;
            case "Medium" -> 50.00;
            case "Large" -> 75.00;
            case "Family" -> 130.00;
            default -> 25.00;
        };

        // Cost of toppings added to the pizza
        double toppingsCost = toppings.size() * 1.50;

        // Membership discount based on pizza size
        double discount = memberCard ? baseCost * (size.equals("Small") ? 0.02 : size.equals("Medium") ? 0.05 : size.equals("Large") ? 0.07 : 0.10) : 0;

        // Final cost includes base cost, crust cost, toppings cost, minus discount
        return baseCost + crustType.getCrustCost() + toppingsCost - discount;
    }
}
