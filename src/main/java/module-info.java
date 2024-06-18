module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires jdk.compiler;


    opens com.example.demo to javafx.fxml;
    opens com.example.demo.controller to javafx.fxml;
    exports com.example.demo;
    exports com.example.demo.controller to javafx.fxml;
    opens com.example.demo.controller.ContentOfSection to javafx.fxml;
    exports com.example.demo.controller.ContentOfSection to javafx.fxml;
}