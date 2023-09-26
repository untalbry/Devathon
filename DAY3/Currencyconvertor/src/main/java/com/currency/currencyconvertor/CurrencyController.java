package com.currency.currencyconvertor;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


import java.text.DecimalFormat;

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
    private boolean isInput1Active = false;
    public void initialize(){
        comboBox1.getItems().addAll("MXN", "USD", "EUR");
        comboBox2.getItems().addAll("MXN", "USD", "EUR");
        input1.textProperty().addListener((observable, oldValue, newValue) -> {
            handleInputChange(newValue, input2, comboBox1, comboBox2);
        });

        input2.textProperty().addListener((observable, oldValue, newValue) -> {
            handleInputChange(newValue, input1, comboBox2, comboBox1);
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
    private void handleInputChange(String newValue, TextField targetInput, ComboBox<String> sourceComboBox, ComboBox<String> targetComboBox) {
        if (!newValue.equals(targetInput.getText())) {
            try {
                if (sourceComboBox.getValue() == null || targetComboBox.getValue() == null) {
                    throw new MyException("Selecciona una divisa ");
                }

                boolean isValid = isNumeric(newValue);

                if(!isValid && !newValue.isEmpty()){
                    System.out.println(newValue);
                    throw new MyException("El valor no es un número");
                }

                Platform.runLater(() -> {
                    if (isValid) {
                        cm.setCurrencyKeys(sourceComboBox.getValue(), targetComboBox.getValue());
                        double number = Double.parseDouble(newValue);
                        DecimalFormat df = new DecimalFormat("#.##");
                        String str = df.format(cm.convert(number));
                        targetInput.setText(str);
                    }
                });

            } catch (MyException e) {
                Platform.runLater(() -> {
                    //cleanTextFields();
                    System.out.println(e.getMessage());
                });
            }
        }
    }
    private boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
