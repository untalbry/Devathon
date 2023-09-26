package com.binaryconverter.binaryconverter;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    private TextField textField1;
    @FXML
    private TextField textField2;
    @FXML
    protected void onConvertButtonClick() {
        textField2.setText(textField1.getText());
    }
}