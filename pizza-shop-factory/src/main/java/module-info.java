module com.example.pizzashop {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.pizzashop to javafx.fxml;
    exports com.example.pizzashop;
}