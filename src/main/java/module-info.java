module com.example.javafx_practice {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.json;
    requires java.desktop;
    requires lombok;

    opens com.example.javafx_practice to javafx.fxml;
    exports com.example.javafx_practice;
    exports com.example.javafx_practice.item;
    opens com.example.javafx_practice.item to javafx.fxml;
    exports persistence.dto;
    opens persistence.dto to javafx.fxml;
}