/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metodos;

import java.util.ArrayList;

/**
 *
 * @author telum
 */
public class Operaciones {

    /**
     * Estos Array se van a utilizar para cargarlos en la tabla del la GUI
     */
    public static ArrayList ascii = new ArrayList<>();
    public static ArrayList binarios = new ArrayList<>();
    public static ArrayList aplicandoAndConG = new ArrayList<>();
    public static ArrayList tablaConRecorrido = new ArrayList<>();
    public static ArrayList asciiFinal = new ArrayList<>();

    String gBinario = "1100111";

    /**
     * Método para encriptar el mensaje
     *
     * @param contenido Texto a encriptar en String
     * @return String Valor encriptado
     */
    public String encriptarContenido(String contenido) {
        char caracter = '0';
        int valorEnAscii = 0;
        String valorEnBinario = null;
        String valorConAnd = null;

        for (int i = 0; i < contenido.length(); i++) {
            caracter = contenido.charAt(i);

            valorEnAscii = caracterAAscii(caracter);
            ascii.add(valorEnAscii);
//            System.out.print("valor ascii " + valorEnAscii);

            valorEnBinario = asciiABinario(valorEnAscii);
            binarios.add(valorEnBinario);
//            System.out.print(" valor binario " + valorEnBinario);

            valorConAnd = aplicarAndConLetraG(valorEnBinario);
//            System.out.print(" valor con and " + valorConAnd + "\n");
            aplicandoAndConG.add(valorConAnd);
        }
        recorrerDosIzq();

        return binarioACaracter();
    }

    /**
     * Método para convertir los binarios a CARACTER
     *
     * @return String valor del binario en CARACTER
     */
    public String binarioACaracter() {
        int resultado = 0;
        String aux = "";
        String mensajeEncriptado = "";
        for (int i = 0; i < tablaConRecorrido.size(); i++) {
            aux = (String) tablaConRecorrido.get(i);
            resultado = binarioAAscii(aux);
            asciiFinal.add(resultado);
            mensajeEncriptado = mensajeEncriptado + (char) resultado;

        }
        return mensajeEncriptado;
    }

    /**
     * Convierte los caracteres en ASCII
     *
     * @param letra
     * @return int Valor en ASCII de los caracteres
     */
    public int caracterAAscii(char letra) {
        int resultado = 0;
        resultado = (int) letra;
        return resultado;
    }

    /**
     * Convierte el ASCII en Binario
     *
     * @param valorAscii
     * @return String Valor del ASCII en binario
     */
    public String asciiABinario(int valorAscii) {
        String binario = null;
        binario = Integer.toBinaryString(valorAscii);
        return binario;
    }

    /**
     * Aplicación de la operación AND con el Binario de la letra g (1100111)
     *
     * @param binario
     * @return String Valor en binario al aplicarle la operación
     */
    public String aplicarAndConLetraG(String binario) {
        String resultado = "";
        String bitBinario = null;
        String bitBinarioG = null;
        for (int i = 0; i < binario.length(); i++) {
            bitBinario = String.valueOf(binario.charAt(i));
            bitBinarioG = String.valueOf(gBinario.charAt(i));

            if (bitBinario.equals("1") && bitBinarioG.equals("1")) {
                resultado = resultado + "1";
            } else {
                resultado = resultado + "0";
            }
        }
        return resultado;
    }

    public void recorrerDosIzq() {
        String resultado = "";
        String septetoSiguiente = "";
        String septeto = "";

        for (int i = 0; i < aplicandoAndConG.size(); i++) {
            String add = (String) aplicandoAndConG.get(i);
            if (add.length() < 7) {
                add = "0" + add;
                aplicandoAndConG.remove(i);
                aplicandoAndConG.add(i, add);
            }

            if (i < (aplicandoAndConG.size() - 1)) {
                septeto = (String) aplicandoAndConG.get(i);
                septetoSiguiente = (String) aplicandoAndConG.get(i + 1);
                resultado = septeto.substring(2, 7) + septetoSiguiente.substring(0, 2);
            } else {
                septeto = (String) aplicandoAndConG.get(i);
                septetoSiguiente = (String) aplicandoAndConG.get(0);
                resultado = septeto.substring(2, 7) + septetoSiguiente.substring(0, 2);
            }
            tablaConRecorrido.add(resultado);
        }
    }

    public int binarioAAscii(String binario) {
        int resultado = 0;
        resultado = Integer.parseInt(binario, 2);
        return resultado;
    }

    public void limpiar() {
        ascii.clear();
        binarios.clear();
        aplicandoAndConG.clear();
        tablaConRecorrido.clear();
        asciiFinal.clear();
    }
}
