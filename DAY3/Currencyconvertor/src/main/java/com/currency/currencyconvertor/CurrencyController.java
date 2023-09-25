package com.currency.currencyconvertor;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CurrencyController {
    private CurrencyModel cm = new CurrencyModel();
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
        input1.textProperty().addListener((observable, oldValue, newValue) -> {
            if(cm.isNumer(newValue)){
                input2.setText(newValue);
            }else{
                Platform.runLater(this::cleanTextFields);
            }
        });
        input2.textProperty().addListener((observable, oldValue, newValue) ->{
            if(cm.isNumer(newValue)){
                input1.setText(newValue);

            }else{
                Platform.runLater(this::cleanTextFields);
            }
        });
    }
    @FXML
    protected void onConvertButtonClick() {
        cleanTextFields();
    }
    private void cleanTextFields(){
        input1.setText("");
        input2.setText("");
    }

}