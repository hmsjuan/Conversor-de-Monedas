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

public class ConversorDeMonedas {
    public String reqResultado="";
    Map<String, Double> tasaDeCambio = new HashMap<>();

    public void obtenerTasasDeCambio(String monedaLocal) throws IOException {
        // Setting URL
        String url_str = "https://v6.exchangerate-api.com/v6/579d93f1562091d14c9eef2f/latest/" + monedaLocal;

        // Making Request
        URL url = new URL(url_str);
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.connect();
        // Convert to JSON
        JsonParser jp = new JsonParser();
        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
        JsonObject jsonobj = root.getAsJsonObject();

        reqResultado = jsonobj.get("result").getAsString();

        if (!reqResultado.equals("success")){
            //errores
        }else{
            String valoresModenas= String.valueOf(jsonobj.get("conversion_rates"));
            // Elimina los caracteres de llaves y comas
            valoresModenas = valoresModenas.replace("{", "").replace("}", "");

            String[] keyValuePairs = valoresModenas.split(",");

            for (String pair : keyValuePairs) {
                String[] keyValue = pair.split(":");
                String key = keyValue[0].replace("\"", ""); // Elimina las comillas
                double value = Double.parseDouble(keyValue[1]);
                tasaDeCambio.put(key, value);
            }

        }
    }

    public String cambiarMoneda(String monedaOrigen, String monedaDestino, double cantidad) {
        DecimalFormat df = new DecimalFormat("0.000");
        double resutado = 0;
        double valorOrigen = tasaDeCambio.get(monedaOrigen);
        double valorDestino = tasaDeCambio.get(monedaDestino);

        resutado= (valorDestino/valorOrigen) * (cantidad);

        return String.format("El valor %s [%s] corresponde al valor final de =>>> $%s [%s]\n",
                df.format(cantidad),monedaOrigen,df.format(resutado),monedaDestino);
    }
}
