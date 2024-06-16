package com.example.demo.controller;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TitledPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

public class SideBarController {
    @FXML
    private HBox MainContainer;

    @FXML
    private AnchorPane btnBehavior;

    @FXML
    private AnchorPane btnBehaviorContainer;

    @FXML
    private AnchorPane btnCatalog;

    @FXML
    private AnchorPane btnCreation;

    @FXML
    private AnchorPane btnCreationContainer;

    @FXML
    private AnchorPane btnFactoryMethod;

    @FXML
    private AnchorPane btnFactoryMethodContainer;

    @FXML
    private AnchorPane btnHome;

    @FXML
    private AnchorPane btnStructure;

    @FXML
    private AnchorPane btnStructureContainer;

    private AnchorPane selectedBtn;

    @FXML
    private void initialize() {
        btnCatalog.setOnMouseClicked(event -> {
            toggleVisibility(btnCreationContainer, btnBehaviorContainer, btnStructureContainer);
            handleButtonClick(event);
        });

        btnCreation.setOnMouseClicked(event -> {
            toggleVisibility(btnFactoryMethodContainer);
            handleButtonClick(event);
        });

        selectedBtn = btnHome;
        Label label = new Label();
        label.setText("<html><b><i>This is bold and italic text</i></b></html>");
        label.setStyle("-fx-font-size: 20px;");
        MainContainer.getChildren().add(label);
    }

    private void toggleVisibility(AnchorPane... panes) {
        for (AnchorPane pane : panes) {
            if (pane.equals(btnCreationContainer)) {
                setVisible(btnFactoryMethodContainer);
            }
            if (pane.equals(btnBehaviorContainer)) {}
            if (pane.equals(btnStructureContainer)) {}
            boolean isVisible = pane.isVisible();
            pane.setVisible(!pane.isVisible());
            pane.setManaged(!pane.isManaged());
            if (!isVisible) {
                applySlideInAnimation(pane);
            }
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

    private void applySlideInAnimation(AnchorPane pane) {
        TranslateTransition transition = new TranslateTransition(Duration.millis(300), pane);
        transition.setFromY(-30);
        transition.setToY(0);
        transition.play();
    }
}
