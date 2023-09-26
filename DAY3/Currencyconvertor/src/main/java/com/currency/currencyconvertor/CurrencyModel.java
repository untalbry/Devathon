package com.currency.currencyconvertor;


import java.math.BigDecimal;
import java.util.HashMap;


public class CurrencyModel {
    private String currencyKey;
    private final HashMap<String, BigDecimal> relation = new HashMap<>();

    public CurrencyModel() {
        /*
         * Colocamos las relaciones:
         * Si quieres añadir mas solamente colócalo en esta parte del código
         * También colócalo en el ComboBox de la parte de vistaConversor
         */
        relation.put("MXN-USD", new BigDecimal(0.057232995));
        relation.put("MXN-EUR", new BigDecimal(0.054064068));
        relation.put("MXN-MXN", BigDecimal.ONE);
        relation.put("USD-MXN", new BigDecimal(17.472473));
        relation.put("USD-EUR", new BigDecimal(0.94466491));
        relation.put("USD-USD", BigDecimal.ONE);
        relation.put("EUR-MXN", new BigDecimal(18.496573));
        relation.put("EUR-USD", new BigDecimal(1.0585764));
        relation.put("EUR-EUR", BigDecimal.ONE);
    }

    public void setCurrencyKeys(String currencyKey1, String currencyKey2) {
        currencyKey = currencyKey1 + "-" + currencyKey2;
    }

    public BigDecimal convert(BigDecimal currency) {
        return currency.multiply(relation.get(currencyKey)).setScale(2, BigDecimal.ROUND_HALF_UP);
    }
}
