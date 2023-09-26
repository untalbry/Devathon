package com.currency.currencyconvertor;


import java.util.HashMap;


public class CurrencyModel {
    private String currencyKey;
    private final HashMap<String, Double> relation = new HashMap<>();

    public CurrencyModel() {
        /*
         * Colocamos las relaciones:
         * Si quieres añadir mas solamente colócalo en esta parte del código
         * También colócalo en el ComboBox de la parte de vistaConversor
         */
        relation.put("MXN-USD", 0.06);
        relation.put("MXN-EUR", 0.05);
        relation.put("MXN-MXN", 1.00);
        relation.put("USD-MXN", 17.41);
        relation.put("USD-EUR", 0.84);
        relation.put("USD-USD", 1.00);
        relation.put("EUR-MXN", 19.18);
        relation.put("EUR-USD", 1.20);
        relation.put("EUR-EUR", 1.00);
    }

    public void setCurrencyKeys(String currencyKey1, String currencyKey2) {
        currencyKey = currencyKey1 + "-" + currencyKey2;
    }

    public Double convert(Double currency) {
        return currency * relation.get(currencyKey);
    }
}
