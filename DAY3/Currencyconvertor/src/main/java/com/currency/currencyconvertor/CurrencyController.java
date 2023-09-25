package com.currency.currencyconvertor;

import javafx.fxml.FXML;
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
    protected void onConvertButtonClick() {
        input2.setText("Hello word");
    }
}