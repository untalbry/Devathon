package com.currency.currencyconvertor;


import java.util.HashMap;

public class CurrencyModel {
    private Double inputValue;
    private Double result;
    private String currencyKey;
    private final HashMap<String, Double> relation = new HashMap<>();
    public CurrencyModel(){
        result=0.0;
        /*
         * Colocamos las relaciones:
         * Si quieres añadir mas solamente colocalo en esta parte del código
         * También colocalo en el ComboBox de la parte de vistaConversor
         */
        relation.put("MXN-USD", 0.049);
        relation.put("MXN-EUR", 0.052);
        relation.put("MXN-MXN", 1.000);
        relation.put("USD-MXN", 20.280);
        relation.put("USD-EUR", 0.840);
        relation.put("USD-USD", 1.000);
        relation.put("EUR-MXN", 19.180);
        relation.put("EUR-USD", 1.200);
        relation.put("EUR-EUR", 1.000);
    }

}
