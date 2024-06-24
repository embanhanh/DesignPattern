package com.example.demo.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class OptionDesignPatternController implements Initializable {

    @FXML
    private ImageView img;

    @FXML
    private Label labelDescribe;

    @FXML
    private Label labelName;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void setData(String _img, String _name, String _describe) {
        labelName.setText(_name);
        labelDescribe.setText(_describe);
        setImage(img, _img);
    }

    private void setImage(ImageView imageView, String imagePath) {
        Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream(imagePath)));
        imageView.setImage(image);
    }
}
