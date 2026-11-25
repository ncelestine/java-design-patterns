module com.example.sandwichapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.sandwichapp to javafx.fxml;
    exports com.example.sandwichapp;
}