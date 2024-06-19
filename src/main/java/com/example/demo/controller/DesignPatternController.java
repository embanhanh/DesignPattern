package com.example.demo.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import java.util.Objects;

public class DesignPatternController {
    @FXML
    private TextFlow TextFlowImplement;

    @FXML
    private TextFlow TextFlowProsandCons;

    @FXML
    private TextFlow TextFlowStructure;

    @FXML
    private TextArea codeCPP;

    @FXML
    private TextArea codeCS;

    @FXML
    private TextArea codeJava;

    @FXML
    private TextArea codePython;

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

    public void setData(String label, String intent, String implement, String ProsNCons, String _codeJava, String _codePython, String _codeCPP, String _codeCS, String _imgIntent, String _imgStructure) {
        labelPattern.setText(label);
        labelIntent.setText(intent);
        Text text1 = new Text(ProsNCons);
        TextFlowProsandCons.getChildren().add(text1);
        Text text2 = new Text(implement);
        TextFlowImplement.getChildren().add(text2);
        codeJava.setText(_codeJava);
        codePython.setText(_codePython);
        codeCPP.setText(_codeCPP);
        codeCS.setText(_codeCS);
        setImage(imgIntent, _imgIntent);
        setImage(imgStructure, _imgStructure);
    }

    private void setImage(ImageView imageView, String imagePath) {
        Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream(imagePath)));
        imageView.setImage(image);
    }
}
