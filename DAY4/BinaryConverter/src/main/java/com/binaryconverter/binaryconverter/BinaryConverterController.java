package com.binaryconverter.binaryconverter;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class BinaryConverterController {
    @FXML
    private Label welcomeText;
    @FXML
    private TextField input1;
    @FXML
    private TextField input2;
    private TextField lastFocusedTextField;
    private int binary;
    public void initialize() {
        input1.focusedProperty().addListener((observable, oldValue, newValue)->{
            if(newValue){
                lastFocusedTextField = input1;
            }
        });
        input2.focusedProperty().addListener((observable, oldValue, newValue)->{
            if(newValue){
                lastFocusedTextField = input2;

            }
        });
    }
    @FXML
    protected void onConvertButtonClick(ActionEvent event) {
        if(lastFocusedTextField != null){
            String newValue = lastFocusedTextField.getText();
            if(lastFocusedTextField == input1){
                try{
                    binary = Integer.parseInt(newValue);
                    input2.setText(Integer.toBinaryString(binary));
                }catch (NumberFormatException e){
                    System.out.println("Valor ingresado no es un decimal");
                }
            }else{
                try{
                    int decimalNumber = Integer.parseInt(newValue, 2);
                    input1.setText(Integer.toString(decimalNumber));
                }catch(NumberFormatException e){
                    System.out.println("Valor ingresado no es un binario");
                }

            }

        }


    }

}