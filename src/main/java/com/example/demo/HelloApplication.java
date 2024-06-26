package com.example.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

import static com.example.demo.Handle.SearchHandle.searchPattern;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        System.out.println(searchPattern("behavioral design pattern that lets you traverse elements"));
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/Main.fxml"));
            Scene scene = new Scene(loader.load());
            stage.setTitle("Design Pattern");
            stage.setScene(scene);
            stage.setWidth(1270);
            stage.setHeight(820);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error loading FXML file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        launch();
    }
}