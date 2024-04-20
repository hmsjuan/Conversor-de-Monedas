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
        //Se puede indicar la moneda local para que la herramienta funciones en cualquira que indiques-
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

        String cadenaParaInput = "Cuàl es el valor en ["+monedaLocal+"] que desea convertir a: ";
        while (opcion!=0) {
            System.out.print(opciones);
            opcion = teclado.nextInt();

            if (opcion>=1 && opcion<=10){
                switch (opcion){
                    case 1:
                        System.out.print(cadenaParaInput+"[USD]");
                        montoAConvertir = teclado.nextDouble();
                        montoConvertido = conversorDeMonedas.cambiarMoneda(monedaLocal,"USD", montoAConvertir);
                        break;
                    case 2:
                        System.out.print(cadenaParaInput+"[EUR]");
                        montoAConvertir = teclado.nextDouble();
                        montoConvertido = conversorDeMonedas.cambiarMoneda(monedaLocal,"EUR", montoAConvertir);
                        break;
                    case 3:
                        System.out.print(cadenaParaInput+"[GBP]");
                        montoAConvertir = teclado.nextDouble();
                        montoConvertido = conversorDeMonedas.cambiarMoneda(monedaLocal,"GBP", montoAConvertir);
                        break;
                    case 4:
                        System.out.print(cadenaParaInput+"[JPY]");
                        montoAConvertir = teclado.nextDouble();
                        montoConvertido = conversorDeMonedas.cambiarMoneda(monedaLocal,"JPY", montoAConvertir);
                        break;
                    case 5:
                        System.out.print(cadenaParaInput+"[KRW]");
                        montoAConvertir = teclado.nextDouble();
                        montoConvertido = conversorDeMonedas.cambiarMoneda(monedaLocal,"KRW", montoAConvertir);
                        break;
                    case 6:
                        System.out.print("Cuál es el valor en [USD] que desea convertir a["+monedaLocal+"]: ");
                        montoAConvertir = teclado.nextDouble();
                        montoConvertido = conversorDeMonedas.cambiarMoneda("USD",monedaLocal, montoAConvertir);
                        break;
                    case 7:
                        System.out.print("Cuál es el valor en [EUR] que desea convertir a["+monedaLocal+"]: ");
                        montoAConvertir = teclado.nextDouble();
                        montoConvertido = conversorDeMonedas.cambiarMoneda("EUR",monedaLocal, montoAConvertir);
                        break;
                    case 8:
                        System.out.print("Cuál es el valor en [GBP] que desea convertir a["+monedaLocal+"]: ");
                        montoAConvertir = teclado.nextDouble();
                        montoConvertido = conversorDeMonedas.cambiarMoneda("GBP",monedaLocal, montoAConvertir);
                        break;
                    case 9:
                        System.out.print("Cuál es el valor en [JPY] que desea convertir a["+monedaLocal+"]: ");
                        montoAConvertir = teclado.nextDouble();
                        montoConvertido = conversorDeMonedas.cambiarMoneda("JPY",monedaLocal, montoAConvertir);
                        break;
                    case 10:
                        System.out.print("Cuál es el valor en [KRW] que desea convertir a["+monedaLocal+"]: ");
                        montoAConvertir = teclado.nextDouble();
                        montoConvertido = conversorDeMonedas.cambiarMoneda("KRW",monedaLocal, montoAConvertir);
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
