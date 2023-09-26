module com.binaryconverter.binaryconverter {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.binaryconverter.binaryconverter to javafx.fxml;
    exports com.binaryconverter.binaryconverter;
}