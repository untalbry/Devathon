package com.currency.currencyconvertor;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CurrencyController {
    @FXML
    private Label welcomeText;
    @FXML
    private TextField input1;
    @FXML
    private TextField input2;
    @FXML
    private ComboBox<String> comboBox1;

    @FXML
    private ComboBox<String> comboBox2;

    public void initialize(){
        comboBox1.getItems().addAll("MXN", "USD", "EUR");
        comboBox2.getItems().addAll("MXN", "USD", "EUR");

    }
    @FXML
    protected void onConvertButtonClick() {
        input2.setText("Hello word");
    }
}