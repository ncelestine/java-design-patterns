package com.example.sandwichapp;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SandwichOrderSystem extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Shop name at the top
        Label shopTitle = new Label("Sandwich Shop");
        shopTitle.setStyle("-fx-font-size: 28px; -fx-font-weight: bold; -fx-text-fill: darkgreen;");

        // Labels with colors
        Label sizeLabel = new Label("Size of Bread");
        sizeLabel.setStyle("-fx-text-fill: teal; -fx-font-weight: bold;");

        Label breadLabel = new Label("Type of Bread");
        breadLabel.setStyle("-fx-text-fill: green; -fx-font-weight: bold;");

        Label sandwichLabel = new Label("Type of Sandwich");
        sandwichLabel.setStyle("-fx-text-fill: purple; -fx-font-weight: bold;");

        Label vegetablesLabel = new Label("Vegetables");
        vegetablesLabel.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");

        Label extrasLabel = new Label("Extras");
        Label saucesLabel = new Label("Sauces");
        saucesLabel.setStyle("-fx-text-fill: blue; -fx-font-weight: bold;");

        // Buttons for Sandwich sizes
        RadioButton sixInch = new RadioButton("Six Inch $20.00");
        RadioButton footLong = new RadioButton("Foot Long $30.00");
        ToggleGroup sizeGroup = new ToggleGroup();
        sixInch.setToggleGroup(sizeGroup);
        footLong.setToggleGroup(sizeGroup);

        // Buttons for choosing types of bread
        RadioButton wheatBread = new RadioButton("Wheat");
        RadioButton italianBread = new RadioButton("Italian");
        RadioButton parmesanOregano = new RadioButton("Parmesan Oregano");
        RadioButton honeyOat = new RadioButton("Honey Oat");
        ToggleGroup breadGroup = new ToggleGroup();
        wheatBread.setToggleGroup(breadGroup);
        italianBread.setToggleGroup(breadGroup);
        parmesanOregano.setToggleGroup(breadGroup);
        honeyOat.setToggleGroup(breadGroup);

        // Buttons for choosing the type of sandwich
        RadioButton italianClassic = new RadioButton("Italian Classic");
        RadioButton clubSandwich = new RadioButton("Club");
        RadioButton steakCheese = new RadioButton("Steak & Cheese");
        RadioButton chickenTeriyaki = new RadioButton("Chicken Teriyaki");
        RadioButton meltSandwich = new RadioButton("Melt");
        RadioButton tuna = new RadioButton("Tuna");
        RadioButton roastBeef = new RadioButton("Roast Beef");
        RadioButton veggieSandwich = new RadioButton("Veggie");
        ToggleGroup sandwichGroup = new ToggleGroup();

        italianClassic.setToggleGroup(sandwichGroup);
        clubSandwich.setToggleGroup(sandwichGroup);
        steakCheese.setToggleGroup(sandwichGroup);
        chickenTeriyaki.setToggleGroup(sandwichGroup);
        meltSandwich.setToggleGroup(sandwichGroup);
        tuna.setToggleGroup(sandwichGroup);
        roastBeef.setToggleGroup(sandwichGroup);
        veggieSandwich.setToggleGroup(sandwichGroup);

        // Individual Checkboxes for Vegetables
        CheckBox cucumbers = new CheckBox("Cucumbers");
        CheckBox bellPeppers = new CheckBox("Green Bell Peppers");
        CheckBox lettuce = new CheckBox("Lettuce");
        CheckBox redOnions = new CheckBox("Red Onions");
        CheckBox tomatoes = new CheckBox("Tomatoes");
        CheckBox pickles = new CheckBox("Pickles");
        CheckBox cheese = new CheckBox("Cheese");

        VBox vegeBox = new VBox(5, cucumbers, bellPeppers, lettuce, redOnions,
                tomatoes, pickles, cheese);
        vegeBox.setPadding(new Insets(5, 0, 5, 0));

        // Checkboxes for the extra toppings
        CheckBox jalapenos = new CheckBox("Jalapenos");
        CheckBox blackOlives = new CheckBox("Black Olives");
        CheckBox pineapples = new CheckBox("Pineapple");

        // Checkboxes for sauces
        CheckBox garlicSauce = new CheckBox("Garlic Sauce");
        CheckBox honeyMustard = new CheckBox("Honey Mustard");
        CheckBox mayo = new CheckBox("Mayonnaise");
        CheckBox sweetOnion = new CheckBox("Sweet Onion");

        // Buttons for making a sandwich, price calculation and total price
        Button makeSandwichButton = new Button("Make Sandwich");
        Button calculatePriceButton = new Button("Calculate Price");
        Label priceLabel = new Label("Total Price: $0.00");
        Label sandwichContentsLabel = new Label("Sandwich Contents: ");

        // Layout setup
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setVgap(10);
        gridPane.setHgap(10);

        // Adding the shop title
        VBox logoBox = new VBox(shopTitle);
        logoBox.setAlignment(Pos.CENTER);
        gridPane.add(logoBox, 0, 0, 2, 1);

        // Layout the components
        gridPane.add(sizeLabel, 0, 1);
        HBox sizeBox = new HBox(10, sixInch, footLong);
        gridPane.add(sizeBox, 1, 1);

        gridPane.add(breadLabel, 0, 2);
        HBox breadBox = new HBox(10, wheatBread, italianBread, parmesanOregano, honeyOat);
        gridPane.add(breadBox, 1, 2);

        gridPane.add(sandwichLabel, 0, 3);
        HBox sandwichBox = new HBox(10, italianClassic, clubSandwich, steakCheese,
                chickenTeriyaki, meltSandwich, tuna, roastBeef, veggieSandwich);
        gridPane.add(sandwichBox, 1, 3);

        gridPane.add(vegetablesLabel, 0, 4);
        gridPane.add(vegeBox, 1, 4);

        gridPane.add(extrasLabel, 0, 5);
        HBox extrasBox = new HBox(10, jalapenos, pineapples, blackOlives);
        gridPane.add(extrasBox, 1, 5);

        gridPane.add(saucesLabel, 0, 6);
        HBox saucesBox = new HBox(10, mayo, honeyMustard, sweetOnion, garlicSauce);
        gridPane.add(saucesBox, 1, 6);

        HBox buttonsBox = new HBox(20, makeSandwichButton, calculatePriceButton);
        buttonsBox.setAlignment(Pos.CENTER);
        gridPane.add(buttonsBox, 1, 7);

        VBox resultsBox = new VBox(10, priceLabel, sandwichContentsLabel);
        resultsBox.setPadding(new Insets(10));
        gridPane.add(resultsBox, 1, 8);

        // Button event for calculating price
        calculatePriceButton.setOnAction(e -> {
            double totalPrice = 0.0;

            // Sandwich size price
            if (sixInch.isSelected()) {
                totalPrice += 20;
            } else if (footLong.isSelected()) {
                totalPrice += 30;
            }

            // Extra cost for specific bread types
            if (parmesanOregano.isSelected() || honeyOat.isSelected()) {
                totalPrice += sixInch.isSelected() ? 1 : 2;
            }

            // Price for sandwich types
            if (chickenTeriyaki.isSelected() || roastBeef.isSelected()) {
                totalPrice += 7;
            } else if (italianClassic.isSelected() || clubSandwich.isSelected() ||
                    steakCheese.isSelected() || meltSandwich.isSelected() || tuna.isSelected()) {
                totalPrice += 5;
            }

            // Cost for extra toppings
            if (jalapenos.isSelected()) totalPrice += sixInch.isSelected() ? 2 : 4;
            if (blackOlives.isSelected()) totalPrice += sixInch.isSelected() ? 2 : 4;
            if (pineapples.isSelected()) totalPrice += sixInch.isSelected() ? 2 : 4;

            // Total Price display
            priceLabel.setText(String.format("Total Price: $%.2f", totalPrice));
        });

        // Make sandwich button event
        makeSandwichButton.setOnAction(e -> {
            StringBuilder sandwichDescription = new StringBuilder("Sandwich contents: ");

            // Sandwich size
            if (sixInch.isSelected()) sandwichDescription.append("size: six inch, ");
            if (footLong.isSelected()) sandwichDescription.append("size: foot long, ");

            // Bread types
            if (italianBread.isSelected()) sandwichDescription.append("Italian bread, ");
            if (honeyOat.isSelected()) sandwichDescription.append("Honey oat bread, ");
            if (parmesanOregano.isSelected()) sandwichDescription.append("Parmesan oregano bread, ");
            if (wheatBread.isSelected()) sandwichDescription.append("Wheat bread, ");

            // Sandwich types
            if (italianClassic.isSelected()) sandwichDescription.append("type: Italian Classic, ");
            if (clubSandwich.isSelected()) sandwichDescription.append("type: Club, ");
            if (steakCheese.isSelected()) sandwichDescription.append("type: Steak & Cheese, ");
            if (chickenTeriyaki.isSelected()) sandwichDescription.append("type: Chicken Teriyaki, ");
            if (meltSandwich.isSelected()) sandwichDescription.append("type: Melt, ");
            if (tuna.isSelected()) sandwichDescription.append("type: Tuna, ");
            if (roastBeef.isSelected()) sandwichDescription.append("type: Roast Beef, ");
            if (veggieSandwich.isSelected()) sandwichDescription.append("type: Veggie, ");

            // Vegetable selections
            StringBuilder vegetables = new StringBuilder("vegetables: ");
            if (cucumbers.isSelected()) vegetables.append("cucumbers, ");
            if (bellPeppers.isSelected()) vegetables.append("green bell peppers, ");
            if (lettuce.isSelected()) vegetables.append("lettuce, ");
            if (redOnions.isSelected()) vegetables.append("red onions, ");
            if (tomatoes.isSelected()) vegetables.append("tomatoes, ");
            if (pickles.isSelected()) vegetables.append("pickles, ");
            if (cheese.isSelected()) vegetables.append("cheese, ");
            // Only add if vegetables were selected
            if (vegetables.length() > 12) {
                // Remove trailing comma and space
                vegetables.setLength(vegetables.length() - 2);
                sandwichDescription.append(vegetables).append(", ");
            }

            // Extras
            StringBuilder extras = new StringBuilder("extras: ");
            if (jalapenos.isSelected()) extras.append("jalapenos, ");
            if (blackOlives.isSelected()) extras.append("black olives, ");
            if (pineapples.isSelected()) extras.append("pineapple, ");
            // Only add if extras were selected
            if (extras.length() > 8) {
                // Remove trailing comma and space
                extras.setLength(extras.length() - 2);
                sandwichDescription.append(extras).append(", ");
            }

            // Sauces
            StringBuilder sauces = new StringBuilder("sauce: ");
            if (garlicSauce.isSelected()) sauces.append("garlic sauce, ");
            if (honeyMustard.isSelected()) sauces.append("honey mustard, ");
            if (mayo.isSelected()) sauces.append("mayonnaise, ");
            if (sweetOnion.isSelected()) sauces.append("sweet onion, ");
            // Only add if sauces were selected
            if (sauces.length() > 7) {
                // Remove trailing comma and space
                sauces.setLength(sauces.length() - 2);
                sandwichDescription.append(sauces).append(", ");
            }

            // Final description cleanup
            if (sandwichDescription.length() > 2) {
                // Remove trailing comma and space
                sandwichDescription.setLength(sandwichDescription.length() - 2);
            }

            // Display final sandwich description
            sandwichContentsLabel.setText(sandwichDescription.toString());
        });

        // Scene setup
        Scene scene = new Scene(gridPane, 600, 500);
        primaryStage.setTitle("Sandwich Shop Order System");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
