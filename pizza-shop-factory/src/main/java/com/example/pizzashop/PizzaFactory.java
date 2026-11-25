package com.example.pizzashop;

import java.util.ArrayList;


 // PizzaFactory class is responsible for creating Pizza instances.
 //Users get to customize their pizza based on the size,toppings and  crust type
public class PizzaFactory {
    public Pizza createPizza(String size, String crust, ArrayList<String> toppings, boolean memberCard) {
        // Convert String toppings to Topping objects
        ArrayList<Topping> toppingObjects = new ArrayList<>();
        for (String topping : toppings) {
            toppingObjects.add(new Topping(topping));
        }
        return new PizzaSize(size, crust, toppingObjects, memberCard);
    }
}




