package com.currency.currencyconvertor;
import java.math.BigDecimal;
import java.util.HashMap;
/**
 * Clase que representa un modelo para realizar conversiones de divisas.
 */
public class CurrencyModel {
    private String currencyKey;
    private final HashMap<String, BigDecimal> relation = new HashMap<>();
    /**
     * Constructor de la clase CurrencyModel.
     * Se inicializan las relaciones de conversión entre distintas monedas.
     * Si deseas añadir más relaciones, puedes hacerlo aquí.
     */
    public CurrencyModel() {
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

    /**
     * Establece las claves de las monedas entre las que se desea realizar la conversión.
     * @param currencyKey1 Clave de la moneda de origen.
     * @param currencyKey2 Clave de la moneda de destino.
     */
    public void setCurrencyKeys(String currencyKey1, String currencyKey2) {
        currencyKey = currencyKey1 + "-" + currencyKey2;
    }

    /**
     * Realiza una conversión de una cantidad de dinero en la moneda de origen a la moneda de destino.
     * @param currency Cantidad de dinero en la moneda de origen.
     * @return La cantidad de dinero convertida a la moneda de destino.
     */
    public BigDecimal convert(BigDecimal currency) {
        // Multiplica la cantidad de dinero por la tasa de conversión y redondea el resultado a 2 decimales.
        return currency.multiply(relation.get(currencyKey)).setScale(2, BigDecimal.ROUND_HALF_UP);
    }
}
