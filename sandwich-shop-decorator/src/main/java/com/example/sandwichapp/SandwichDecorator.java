// SandwichDecorator.java
package com.example.sandwichapp;


 // Abstract decorator class that extends SandwichComponent.
  //Holds a reference to another SandwichComponent to allow dynamic additions.

public abstract class SandwichDecorator implements SandwichComponent {
    protected SandwichComponent sandwich;

    public SandwichDecorator(SandwichComponent sandwich) {
        this.sandwich = sandwich;
    }

    @Override
    public double getCost() {
        return sandwich.getCost();
    }

    @Override
    public String getDescription() {
        return sandwich.getDescription();
    }
}

