package com.currency.currencyconvertor;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

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

            try {
                if (sourceComboBox.getValue() == null || targetComboBox.getValue() == null) {
                    throw new MyException("Selecciona una divisa ");
                }
                boolean isValid;
                if(!newValue.isEmpty()){
                    isValid = isNumeric(newValue);
                    if(isValid){
                        Platform.runLater(() -> {
                            System.out.println(newValue);
                            cm.setCurrencyKeys(sourceComboBox.getValue(), targetComboBox.getValue());
                            BigDecimal number = new BigDecimal(newValue);
                            BigDecimal result = cm.convert(number);
                            // Formatear el resultado a dos decimales
                            DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.getDefault());
                            symbols.setDecimalSeparator('.');
                            DecimalFormat df = new DecimalFormat("#.00", symbols);
                            df.setRoundingMode(RoundingMode.HALF_UP);
                            String str = df.format(result);
                            targetInput.setText(str);
                        });
                    }else{
                        System.out.println("Exception con : "+ newValue);
                        System.out.println(isValid);
                        throw new MyException("El valor no es un numero");
                    }
                }


            } catch (MyException e) {
                Platform.runLater(() -> {
                    //cleanTextFields();
                    System.out.println(e.getMessage());
                });
            }
        }

    private boolean isNumeric(String str) {
        try {
            new BigDecimal(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
