package com.limaapps.conversordemonedas;

import java.io.IOException;
import java.util.Scanner;


public class MainConsola {
    public static void main(String[] args) throws IOException {
        String monedaLocal = "DOP";
        Scanner teclado = new Scanner(System.in);
        String monedaDestino;
        String monedaOrigen = "";

        ConversorDeMonedasConsola conversorDeMonedas = new ConversorDeMonedasConsola();
        if (!conversorDeMonedas.reqResultado.equals("success")) {
            conversorDeMonedas.obtenerTasasDeCambio(monedaLocal);
        }

        String opciones = """
               *-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*
               Sea bienvenido/a al Conversor de Moneda
                      Moneda local == [%s]
               1) Moneda Local a Dólar
               2) Moneda Local a Euros
               3) Moneda Local a Libras Esterlinas
               4) Moneda Local a Yen Japonés
               5) Moneda Local a Won surcoreano
               **** O T R A S  O P C I O N E S ******
               6) Dólar a Moneda Local
               7) Euros a Moneda Local
               8) Libras a Moneda Local
               9) Yen Japonés a Moneda Local
               10) Won sul-coreano a Moneda Local
               0) SALIR

               Escriba una opción válida:
                """.formatted(monedaLocal);


        int opcion;
        do {
            System.out.print(opciones);
            opcion = teclado.nextInt();

            if (opcion >= 1 && opcion <= 10) {
                if (opcion >=1 && opcion<=5){
                    monedaDestino = obtenerMonedaDestino(opcion);
                    monedaOrigen=monedaLocal;
                }else{
                    monedaOrigen =obtenerMonedaDestino(opcion-5);
                    monedaDestino = monedaLocal;
                }
                String cadenaParaInput = "Cuál es el valor en [" + monedaOrigen + "] que desea convertir a["+monedaDestino+"]  : ";
                System.out.print(cadenaParaInput);

                double montoAConvertir = teclado.nextDouble();
                String montoConvertido = conversorDeMonedas.cambiarMoneda(monedaOrigen, monedaDestino, montoAConvertir);
                System.out.println(montoConvertido);
            } else if (opcion == 0) {
                System.out.println("\n*> Ha optado por salir del sistema. * ");
            } else {
                System.out.println("OPCIÓN NO VÁLIDA");
            }
        } while (opcion != 0);
    }

    private static String obtenerMonedaDestino(int opcion) {
        switch (opcion) {
            case 1:
                return "USD";
            case 2:
                return "EUR";
            case 3:
                return "GBP";
            case 4:
                return "JPY";
            case 5:
                return "KRW";

            default:
                return "";
        }
    }
}
