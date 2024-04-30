package com.limaapps.conversordemonedas.herrmientas;

import com.limaapps.conversordemonedas.Common;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class Utilidades {
    ConversorDeMonedas conversorDeMonedas;
    Common common;


    public boolean convertirMondeda;
    public Utilidades(){
        this.common = new Common();
        this.conversorDeMonedas = new ConversorDeMonedas(common.MONEDALOCAL);
        this.convertirMondeda =false;
    }
    public static String fachaYHora(){
        Date fechaActual = new Date();
        // Crear un objeto SimpleDateFormat para formatear la fecha y hora
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy 'a las' hh:mm a");
        // Formatear la fecha y hora actual según el formato deseado
        return formato.format(fechaActual);
    }



    public static void mostrarMensaje(JLabel label, String texto, Color color){
        label.setText(texto);
        label.setForeground(color);
        label.setVisible(true);
    }
    public boolean isNumeric(String numero){
        //Verificacion de numeros ingresados
        return numero != null && numero.matches("[-+]?\\d*\\.?\\d+");
    }

    public void llenarComboBox(JComboBox comboBox){

        conversorDeMonedas.llenarMonedas();
        // monedas.llenarMonedas();
        for (Map.Entry entry: conversorDeMonedas.listaMonedas.entrySet() ){
            Object items = entry.getKey();
            Object nombres = entry.getValue();

            String nombre= (String) items + "-"+ (String) nombres;
            comboBox.addItem((String) nombre);
        }
    }

}
