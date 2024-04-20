package com.limaapps.conversordemonedas;

import java.io.IOException;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class Main
{
    public static void main(String[] args) throws IOException {

        String monedaLocal="DOP";
        String montoConvertido = "**";
        Scanner teclado = new Scanner(System.in);
        int opcion = 500;
        double montoAConvertir=0;

        ConversorDeMonedas conversorDeMonedas = new ConversorDeMonedas();
        if (!conversorDeMonedas.reqResultado.equals("success")){
            conversorDeMonedas.obtenerTasasDeCambio(monedaLocal);
        }

        String opciones = """
               *-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*
               Sea bienvenido/a al Conversor de Moneda

               1) Peso a Dólar
               2) Peso a Euros
               3) Peso a Libras Esterlinas
               4) Peso a Yen Japonés
               5) Peso a Won surcoreano
               **** O T R A S  O P C I O N E S ******
               6) Dólar a Peso
               7) Euros a Peso
               8) Libras a Peso
               9) Yen Japonés a Peso
               10) Won sul-coreano a Peso
               0) SALIR

               Escriba una opción válida:
                """;

        while (opcion!=0) {
            System.out.print(opciones);
            opcion = teclado.nextInt();

            if (opcion>=1 && opcion<=10){
                switch (opcion){
                    case 1:
                        System.out.print("Cuál es el valor que desea convertir: ");
                        montoAConvertir = teclado.nextDouble();
                        montoConvertido = conversorDeMonedas.cambiarMoneda("DOP","USD", montoAConvertir);
                        break;
                    case 2:
                        System.out.print("Cuál es el valor que desea convertir: ");
                        montoAConvertir = teclado.nextDouble();
                        montoConvertido = conversorDeMonedas.cambiarMoneda("DOP","EUR", montoAConvertir);
                        break;
                    case 3:
                        System.out.print("Cuál es el valor en %s que desea convertir: ");
                        montoAConvertir = teclado.nextDouble();
                        montoConvertido = conversorDeMonedas.cambiarMoneda("DOP","GBP", montoAConvertir);
                        break;
                    case 4:
                        System.out.print("Cuál es el valor que desea convertir :");
                        montoAConvertir = teclado.nextDouble();
                        montoConvertido = conversorDeMonedas.cambiarMoneda("DOP","JPY", montoAConvertir);
                        break;
                    case 5:
                        System.out.print("Cuál es el valor que desea convertir:  ");
                        montoAConvertir = teclado.nextDouble();
                        montoConvertido = conversorDeMonedas.cambiarMoneda("DOP","KRW", montoAConvertir);
                        break;
                    case 6:
                        System.out.print("Cuál es el valor que desea convertir: ");
                        montoAConvertir = teclado.nextDouble();
                        montoConvertido = conversorDeMonedas.cambiarMoneda("USD","DOP", montoAConvertir);
                        break;
                    case 7:
                        System.out.print("Cuál es el valor que desea convertir a : ");
                        montoAConvertir = teclado.nextDouble();
                        montoConvertido = conversorDeMonedas.cambiarMoneda("EUR","DOP", montoAConvertir);
                        break;
                    case 8:
                        System.out.print("Cuál es el valor que desea convertir : ");
                        montoAConvertir = teclado.nextDouble();
                        montoConvertido = conversorDeMonedas.cambiarMoneda("GBP","DOP", montoAConvertir);
                        break;
                    case 9:
                        System.out.print("Cuál es el valor que desea convertir :");
                        montoAConvertir = teclado.nextDouble();
                        montoConvertido = conversorDeMonedas.cambiarMoneda("JPY","DOP", montoAConvertir);
                        break;
                    case 10:
                        System.out.println("Cuál es el valor que desea convertir : ");
                        montoAConvertir = teclado.nextDouble();
                        montoConvertido = conversorDeMonedas.cambiarMoneda("KRW","DOP", montoAConvertir);
                        break;
                }
                System.out.println(montoConvertido);
            }else if (opcion==0){
                System.out.println("\n*> Ha optado por salir del sistema. * ");
            }else{
                System.out.println("OPCIÓN NO VÁLIDA");
            }

        }

    }
}
