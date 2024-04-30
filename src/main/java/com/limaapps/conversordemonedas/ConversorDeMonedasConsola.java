package com.limaapps.conversordemonedas;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class ConversorDeMonedasConsola {
    public String reqResultado = "";
    Map<String, Double> tasaDeCambio = new HashMap<>();

    public void obtenerTasasDeCambio(String monedaLocal) throws IOException {
        String url_str = "https://v6.exchangerate-api.com/v6/667dbfc4f3b7ca3754b9e386/latest/" + monedaLocal;

        URL url = new URL(url_str);
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.connect();

        // Convertir a JSON
        JsonParser jp = new JsonParser();
        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
        JsonObject jsonobj = root.getAsJsonObject();

        reqResultado = jsonobj.get("result").getAsString();

        if (!reqResultado.equals("success")) {
            // manejar errores
        } else {
            JsonObject conversionRates = jsonobj.getAsJsonObject("conversion_rates");
            for (Map.Entry<String, JsonElement> entry : conversionRates.entrySet()) {
                String key = entry.getKey();
                double value = entry.getValue().getAsDouble();
                tasaDeCambio.put(key, value);
            }
        }
    }

    public String cambiarMoneda(String monedaOrigen, String monedaDestino, double cantidad) {
        DecimalFormat df = new DecimalFormat("0.000");
        double resultado = 0;
        double valorOrigen = tasaDeCambio.get(monedaOrigen);
        double valorDestino = tasaDeCambio.get(monedaDestino);

        resultado = (valorDestino / valorOrigen) * cantidad;

        return String.format("El valor %s [%s] corresponde al valor final de =>>> $%s [%s]\n",
                df.format(cantidad), monedaOrigen, df.format(resultado), monedaDestino);
    }
}
