package com.example.demo.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class DesignPatternController {
    @FXML
    private TextFlow TextFlowImplement;

    @FXML
    private TextFlow TextFlowProsandCons;

    @FXML
    private TextFlow TextFlowStructure;

    @FXML
    private TextFlow codeJava;

    @FXML
    private TextFlow codePython;

    @FXML
    private ImageView imgIntent;

    @FXML
    private ImageView imgStructure;

    @FXML
    private Text labelIntent;

    @FXML
    private Label labelPattern;

    @FXML
    private void initialize() {

    }

    public void setData(String label, String intent, String implement, String ProsNCons, String _codeJava, String _codePython) {
        labelPattern.setText(label);
        labelIntent.setText(intent);
        Text text1 = new Text(ProsNCons);
        TextFlowProsandCons.getChildren().add(text1);
        Text text2 = new Text(implement);
        TextFlowImplement.getChildren().add(text2);
        Text text3 = new Text(_codeJava);
        codeJava.getChildren().add(text3);
        Text text4 = new Text(_codePython);
        codePython.getChildren().add(text4);
    }
}
