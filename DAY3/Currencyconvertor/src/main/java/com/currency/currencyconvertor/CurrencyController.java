package com.currency.currencyconvertor;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import java.math.BigDecimal;

public class CurrencyController {
    private CurrencyModel cm = new CurrencyModel();
    // Campos de entrada para los valores y ComboBox para las monedas
    @FXML
    private TextField input1;
    @FXML
    private TextField input2;
    @FXML
    private ComboBox<String> comboBox1;
    @FXML
    private ComboBox<String> comboBox2;

    // Listeners para rastrear los cambios en los campos de entrada
    private final ChangeListener<String> input1Listener = (obs, oldText, newText) -> {
        handleInputChange(newText, input2, comboBox1, comboBox2);
    };

    private final ChangeListener<String> input2Listener = (obs, oldText, newText) -> {
        handleInputChange(newText, input1, comboBox2, comboBox1);
    };

    // Método llamado cuando se inicializa la vista
    public void initialize() {
        // Agregar opciones a los ComboBox
        comboBox1.getItems().addAll("MXN", "USD", "EUR");
        comboBox2.getItems().addAll("MXN", "USD", "EUR");

        // Agregar listeners para rastrear el foco de los campos de entrada
        input1.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                // El TextField input1 tiene el foco, agregamos el listener
                input1.textProperty().addListener(input1Listener);
            } else {
                // El TextField input1 no tiene el foco, removemos el listener
                input1.textProperty().removeListener(input1Listener);
            }
        });

        input2.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                // El TextField input2 tiene el foco, agregamos el listener
                input2.textProperty().addListener(input2Listener);
            } else {
                // El TextField input2 no tiene el foco, removemos el listener
                input2.textProperty().removeListener(input2Listener);
            }
        });
    }

    // Método llamado cuando se hace clic en el botón de conversión
    @FXML
    protected void onConvertButtonClick() {
        // Limpiar los campos de entrada
        cleanTextFields();
    }

    // Método para limpiar los campos de entrada
    private void cleanTextFields() {
        input1.setText("");
        input2.setText("");
    }


    // Método para manejar los cambios en los campos de entrada
    private void handleInputChange(String newValue, TextField targetInput, ComboBox<String> sourceComboBox, ComboBox<String> targetComboBox) {
        try {
            // Verificar si las monedas de origen y destino están seleccionadas
            if (sourceComboBox.getValue() == null || targetComboBox.getValue() == null) {
                sourceComboBox.setStyle(sourceComboBox.getValue() == null ? "-fx-border-color: red;" : "-fx-border-color: #a6b0c3;");
                targetComboBox.setStyle(targetComboBox.getValue() == null ? "-fx-border-color: red;" : "-fx-border-color: #a6b0c3;");

                throw new MyException("Selecciona una divisa ");
            }else{
                sourceComboBox.setStyle("-fx-border-color: #a6b0c3;");
                targetComboBox.setStyle("-fx-border-color: #a6b0c3;");
            }
            boolean isValid;
            if (!newValue.isEmpty()) {
                // Verificar si el valor ingresado es numérico
                isValid = isNumeric(newValue);
                if (isValid) {
                    // Realizar la conversión y actualizar el otro campo de entrada
                    Platform.runLater(() -> {
                        cm.setCurrencyKeys(sourceComboBox.getValue(), targetComboBox.getValue());
                        BigDecimal number = new BigDecimal(newValue);
                        BigDecimal result = cm.convert(number);
                        targetInput.setText(result.toString());
                    });
                } else {
                    throw new MyException("El valor no es un número");
                }
            }
        } catch (MyException e) {
            // Manejar excepciones y mostrar mensajes de error
            Platform.runLater(() -> {
                cleanTextFields();
                System.out.println(e.getMessage());
            });
        }
    }

    // Método para verificar si una cadena es numérica
    private boolean isNumeric(String str) {
        try {
            new BigDecimal(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
