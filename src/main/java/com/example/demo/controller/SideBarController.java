package com.example.demo.controller;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TitledPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

import java.io.IOException;
import java.util.Objects;

public class SideBarController {
    @FXML
    private HBox MainContainer;

    @FXML
    private AnchorPane tabBehavioral;

    @FXML
    private AnchorPane tabCreational;

    @FXML
    private AnchorPane tabHome;

    @FXML
    private AnchorPane tabStructural;

    private AnchorPane selectedBtn;

    @FXML
    private void initialize() {

        selectedBtn = tabHome;
        tabStructural.getStyleClass().add("default-pane");
        tabBehavioral.getStyleClass().add("default-pane");
        tabCreational.getStyleClass().add("default-pane");
        tabHome.getStyleClass().add("selected-pane");
        try {
            AnchorPane additionalView = FXMLLoader.load(getClass().getResource("/UI/Home.fxml"));
            MainContainer.getChildren().add(additionalView);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void setVisible(AnchorPane... panes) {
        for (AnchorPane pane : panes) {
            pane.setVisible(false);
            pane.setManaged(false);
        }
    }

    public void handleButtonClick(MouseEvent event) {
        System.out.println("Clicked");
        AnchorPane clickedButton = (AnchorPane) event.getSource();
        selectedBtn.getStyleClass().removeAll("selected-pane");
        selectedBtn.getStyleClass().add("default-pane");

        selectedBtn = clickedButton;
        selectedBtn.getStyleClass().removeAll("default-pane");
        selectedBtn.getStyleClass().add("selected-pane");
    }

    public void handleButtonClick_CreationalPattern(MouseEvent event) {
        System.out.println("Clicked creational pattern");
        AnchorPane clickedButton = (AnchorPane) event.getSource();
        selectedBtn.getStyleClass().removeAll("selected-pane");
        selectedBtn.getStyleClass().add("default-pane");
        try {
//            AnchorPane additionalView = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/UI/ContentOfSection/CreationalPattern.fxml")));
//            MainContainer.getChildren().removeLast();
//            MainContainer.getChildren().add(additionalView);
            Parent newContent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/UI/ContentOfSection/CreationalPattern.fxml")));
            MainContainer.getChildren().removeLast();
            MainContainer.getChildren().add(newContent);
        } catch (IOException e) {
            e.printStackTrace();
        }
        selectedBtn = clickedButton;
        selectedBtn.getStyleClass().removeAll("default-pane");
        selectedBtn.getStyleClass().add("selected-pane");
    }

    public void handleButtonClick_StructuralPattern(MouseEvent event) {
        System.out.println("Clicked structural pattern");
        AnchorPane clickedButton = (AnchorPane) event.getSource();
        selectedBtn.getStyleClass().removeAll("selected-pane");
        selectedBtn.getStyleClass().add("default-pane");
        try {
//            AnchorPane additionalView = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/UI/ContentOfSection/StructuralPattern.fxml")));
//            MainContainer.getChildren().removeLast();
//            MainContainer.getChildren().add(additionalView);
            Parent newContent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/UI/ContentOfSection/StructuralPattern.fxml")));
            MainContainer.getChildren().removeLast();
            MainContainer.getChildren().add(newContent);
        } catch (IOException e) {
            e.printStackTrace();
        }
        selectedBtn = clickedButton;
        selectedBtn.getStyleClass().removeAll("default-pane");
        selectedBtn.getStyleClass().add("selected-pane");
    }

    public void handleButtonClick_BehavioralPattern(MouseEvent event) {
        System.out.println("Clicked behavioral pattern");
        AnchorPane clickedButton = (AnchorPane) event.getSource();
        selectedBtn.getStyleClass().removeAll("selected-pane");
        selectedBtn.getStyleClass().add("default-pane");
        try {
//            AnchorPane additionalView = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/UI/ContentOfSection/BehavioralPattern.fxml")));
//            MainContainer.getChildren().removeLast();
//            MainContainer.getChildren().add(additionalView);
            Parent newContent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/UI/ContentOfSection/BehavioralPattern.fxml")));
            MainContainer.getChildren().removeLast();
            MainContainer.getChildren().add(newContent);
        } catch (IOException e) {
            e.printStackTrace();
        }
        selectedBtn = clickedButton;
        selectedBtn.getStyleClass().removeAll("default-pane");
        selectedBtn.getStyleClass().add("selected-pane");
    }

}
