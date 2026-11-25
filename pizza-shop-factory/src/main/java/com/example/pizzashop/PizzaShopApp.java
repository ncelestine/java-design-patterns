package com.example.pizzashop;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

 // Main GUI application class for ordering pizza

public class PizzaShopApp extends JFrame {
    private JCheckBox[] toppingSelections;
    private JRadioButton[] sizeOptions;
    private JRadioButton[] crustOptions;
    private JTextArea windowArea;
    private JButton placeOrderButton, printAllOrdersButton;
    private JCheckBox memberCardOption;
    private ArrayList<Pizza> orderList;
    private PizzaFactory pizzaFactory;

    public PizzaShopApp() {
        // Initialize main frame settings
        setTitle("PizzaMania");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Order list and pizza factory for creating orders
        orderList = new ArrayList<>();
        pizzaFactory = new PizzaFactory();

        // Set up title at the top center
        JLabel titleLabel = new JLabel("PizzaMania", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        add(titleLabel, BorderLayout.NORTH);

        // Initialize GUI components
        setupMenu();
        setupOrderComponents();
        setupActionListeners();
    }

    // Set up menu for 'Clear Form' and 'Exit' options
    private void setupMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");

        JMenuItem clearForm = new JMenuItem("Clear Form");
        clearForm.addActionListener(e -> clearForm());
        fileMenu.add(clearForm);

        JMenuItem exit = new JMenuItem("Exit");
        exit.addActionListener(e -> System.exit(0));
        fileMenu.add(exit);

        menuBar.add(fileMenu);
        setJMenuBar(menuBar);
    }

    // Layout and components for pizza order form
    private void setupOrderComponents() {
        JPanel mainPanel = new JPanel(new GridLayout(1, 3));

        // Toppings selection with checkboxes
        JPanel toppingsPanel = new JPanel(new GridLayout(8, 1));
        toppingsPanel.setBorder(BorderFactory.createTitledBorder("Each Topping: $1.50"));
        String[] toppings = {"Tomato", "Green Pepper", "Black Olives", "Mushrooms", "Extra Cheese", "Pepperoni", "Sausage"};
        toppingSelections = new JCheckBox[toppings.length];
        for (int i = 0; i < toppings.length; i++) {
            toppingSelections[i] = new JCheckBox(toppings[i]);
            toppingsPanel.add(toppingSelections[i]);
        }
        mainPanel.add(toppingsPanel);

        // Pizza size selection with radio buttons
        JPanel sizePanel = new JPanel(new GridLayout(5, 1));
        sizePanel.setBorder(BorderFactory.createTitledBorder("Pizza Size"));
        String[] sizes = {"Small", "Medium", "Large", "Family"};
        sizeOptions = new JRadioButton[sizes.length];
        ButtonGroup sizeGroup = new ButtonGroup();
        for (int i = 0; i < sizes.length; i++) {
            sizeOptions[i] = new JRadioButton(sizes[i]);
            sizeGroup.add(sizeOptions[i]);
            sizePanel.add(sizeOptions[i]);
        }
        memberCardOption = new JCheckBox("Members Card");
        sizePanel.add(memberCardOption);
        mainPanel.add(sizePanel);

        // Crust type selection with radio buttons
        JPanel crustPanel = new JPanel(new GridLayout(3, 1));
        crustPanel.setBorder(BorderFactory.createTitledBorder("Pizza Type"));
        String[] crusts = {"Thin Crust", "Medium Crust", "Crust Lover"};
        crustOptions = new JRadioButton[crusts.length];
        ButtonGroup crustGroup = new ButtonGroup();
        for (int i = 0; i < crusts.length; i++) {
            crustOptions[i] = new JRadioButton(crusts[i]);
            crustGroup.add(crustOptions[i]);
            crustPanel.add(crustOptions[i]);
        }
        mainPanel.add(crustPanel);

        add(mainPanel, BorderLayout.CENTER);

        // Display area and buttons for placing and printing orders
        JPanel bottomPanel = new JPanel(new BorderLayout());
        windowArea = new JTextArea(8, 40);
        windowArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(windowArea);
        bottomPanel.add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        placeOrderButton = new JButton("Place Order");
        printAllOrdersButton = new JButton("Print All Orders");
        buttonPanel.add(placeOrderButton);
        buttonPanel.add(printAllOrdersButton);
        bottomPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(bottomPanel, BorderLayout.SOUTH);
    }

    // Clears all form selections
    private void clearForm() {
        for (JCheckBox checkBox : toppingSelections) {
            checkBox.setSelected(false);
        }
        for (JRadioButton radioButton : sizeOptions) {
            radioButton.setSelected(false);
        }
        for (JRadioButton radioButton : crustOptions) {
            radioButton.setSelected(false);
        }
        memberCardOption.setSelected(false);
        windowArea.setText("");
    }

    // Add listeners for place order and print all orders buttons
    private void setupActionListeners() {
        placeOrderButton.addActionListener(e -> placeOrder());
        printAllOrdersButton.addActionListener(e -> printAllOrders());
    }

    // Place an order by creating a pizza instance and appending to display area
    private void placeOrder() {
        Pizza pizza = pizzaFactory.createPizza(getSelectedSize(), getSelectedCrust(), getSelectedToppings(), memberCardOption.isSelected());
        orderList.add(pizza);
        windowArea.append(pizza.toString() + "\n");
    }

    // Print all stored orders in display area
    private void printAllOrders() {
        windowArea.setText("");
        for (Pizza order : orderList) {
            windowArea.append(order.toString() + "\n");
        }
    }

    // methods to get selected size, crust, and toppings
    private String getSelectedSize() {
        for (JRadioButton button : sizeOptions) {
            if (button.isSelected()) return button.getText();
        }
        // Default or first size
        return "Small";
    }

    private String getSelectedCrust() {
        for (JRadioButton button : crustOptions) {
            if (button.isSelected()) return button.getText();
        }
        // Default or first crust
        return "Thin Crust";
    }

    private ArrayList<String> getSelectedToppings() {
        ArrayList<String> selectedToppings = new ArrayList<>();
        for (JCheckBox checkBox : toppingSelections) {
            if (checkBox.isSelected()) selectedToppings.add(checkBox.getText());
        }
        return selectedToppings;
    }

    // Main method to launch application
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PizzaShopApp().setVisible(true));
    }
}







