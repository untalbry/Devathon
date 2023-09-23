package com.currency.currencyconvertor;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class CurrencyController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}