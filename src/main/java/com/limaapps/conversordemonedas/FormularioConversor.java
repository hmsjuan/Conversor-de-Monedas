package com.limaapps.conversordemonedas;

import com.limaapps.conversordemonedas.herrmientas.ConversorDeMonedas;
import com.limaapps.conversordemonedas.herrmientas.Utilidades;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;

public class FormularioConversor {

    //Variables del panel Monedas
    private JPanel PanelPrincipal;
    private JTabbedPane JpConversores;
    private JPanel jPMonedas;
    private JPanel jPTemperatura;
    private JComboBox cbMonedaOrigen;
    private JComboBox cbMonedaDestino;
    private JTextField textCantidad;
    private JButton btnCambiar;
    private JList lstResultadosMonedas;

    //Variables del panel Temperatura
    private JButton recargarButton;
    private JLabel lblEstatus;
    private JTextField textTEmperaturaCelcius;
    private JTextField textTemperaturaFahrenheit;
    private JLabel lblResultadoMoneda;

    //variables Generales
    private String iMonedaOrigen, iMonedaDestino;
    private double resultado, valoraConvertir;
    private DecimalFormat df = new DecimalFormat("###,###,###.00");
    private ArrayList<String> historico = new ArrayList<String>();
    private String monedaLocal="DOP";
    private ConversorDeMonedas conversor = new ConversorDeMonedas("DOP");
    private String valorTemporal;
    private String textoResultado="";

    public static void main(String[] args) {
        JFrame framePrincipal = new JFrame("Conversor de Monedas y Temperatura");
        framePrincipal.setContentPane(new FormularioConversor().PanelPrincipal);
        framePrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        framePrincipal.pack();
        framePrincipal.setLocale(null);
        framePrincipal.setSize(650,450);
        framePrincipal.setResizable(false);
        framePrincipal.setVisible(true);
    }

    public FormularioConversor(){

//Espacio para el convertidos de Monedas
        var utilidades = new Utilidades();

        conversor.ConsultatAPI(lblEstatus);
        utilidades.llenarComboBox(cbMonedaDestino);
        utilidades.llenarComboBox(cbMonedaOrigen);
        cbMonedaOrigen.addActionListener(e -> iMonedaOrigen = Objects.requireNonNull(cbMonedaOrigen.getSelectedItem()).toString().substring(0,3));
        cbMonedaDestino.addActionListener(e -> iMonedaDestino = Objects.requireNonNull(cbMonedaDestino.getSelectedItem()).toString().substring(0,3));


        btnCambiar.addActionListener(e -> {
            valorTemporal = textCantidad.getText();
            if (conversor.convertirMondeda) {
                if (utilidades.isNumeric(valorTemporal)) {
                    valoraConvertir = Double.parseDouble(valorTemporal);
                    resultado = conversor.convertir(iMonedaOrigen, iMonedaDestino, valoraConvertir);
                    textoResultado = df.format(valoraConvertir) + " " + cbMonedaOrigen.getSelectedItem() + " equivalen a " +
                            df.format(resultado) + " " + cbMonedaDestino.getSelectedItem();
                    lblResultadoMoneda.setText(textoResultado);
                    historico.add(utilidades.fachaYHora() + " " + textoResultado);

                    Comparator<String> comparador = Collections.reverseOrder();
                    Collections.sort(historico, comparador);

                    lstResultadosMonedas.setListData(historico.toArray());
                } else {
                    JOptionPane.showMessageDialog(null, "El valor ingresado no es válido");
                }
            } else if (!conversor.convertirMondeda) {
                JOptionPane.showMessageDialog(null, "No se han obtenido las tasas de cambio\n Intente con el boton -Recargar-");
            }
        });
        //Espacio para el convertidor de Temperatura
        textTEmperaturaCelcius.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char caracter = e.getKeyChar();
                if (e.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE) e.consume();
                if ((caracter <'0' || caracter>'9')&&(caracter<',' || caracter>'.')  ) e.consume();
            }

            @Override
            public void keyReleased(KeyEvent e) {
                String valorCelcius= textTEmperaturaCelcius.getText();
                if (valorCelcius.isEmpty()) textTemperaturaFahrenheit.setText("");
                if (utilidades.isNumeric(valorCelcius)){
                    double resultadoC = ((Double.parseDouble(valorCelcius)*1.8) + 32);
                    textTemperaturaFahrenheit.setText(df.format(resultadoC));
                }
            }
        });


        textTemperaturaFahrenheit.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char caracter = e.getKeyChar();
                if (e.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE) e.consume();
                if ((caracter <'0' || caracter>'9')&&(caracter<',' || caracter>'.')  ) e.consume();
            }

            @Override
            public void keyReleased(KeyEvent e) {
                String valorFarenhai= textTemperaturaFahrenheit.getText();
                if (valorFarenhai.isEmpty()) textTEmperaturaCelcius.setText("");
                if (utilidades.isNumeric(valorFarenhai)){
                    double resultadoC = ((Double.parseDouble(valorFarenhai) - 32)/1.8);
                    textTEmperaturaCelcius.setText(df.format(resultadoC));
                }
            }
        });
    }



}
