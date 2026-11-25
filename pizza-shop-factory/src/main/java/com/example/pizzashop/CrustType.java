package com.example.pizzashop;

// This class is for the types of crust the customer can choose from
public class CrustType {
    // The name of the crust type
    private String crustName;
    // The cost of the crust type
    private double crustCost;

    public CrustType(String crustName) {
        this.crustName = crustName;
        this.crustCost = switch (crustName) {
            case "Thin Crust" -> 2.00;
            case "Medium Crust" -> 3.00;
            case "Crust Lover" -> 4.00;
            default -> 2.00;
        };
    }

    public double getCrustCost() {
        return crustCost;
    }

    @Override
    public String toString() {
        return crustName;
    }
}



