module com.currency.currencyconvertor {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.currency.currencyconvertor to javafx.fxml;
    exports com.currency.currencyconvertor;
}