/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metodos;

import Metodos.Operaciones;
import static Metodos.Operaciones.aplicandoAndConG;
import static Metodos.Operaciones.ascii;
import static Metodos.Operaciones.asciiFinal;
import static Metodos.Operaciones.binarios;
import static Metodos.Operaciones.tablaConRecorrido;
import java.util.ArrayList;

/**
 * Pasos para el desencriptado 1. Obtener cadena desde la GUI. 2. Localizar cada
 * caracter en el diccionario y obtener su valor en ascii. 3. Convertir el valor
 * de ascii en binario y completar binario a 8 bits 4. Aplicar desplazamiento a
 * la derecha 2 bits 5. Convertir binario en ASCII 6. Localizar ASCII en el
 * diccionario y obtener el caracter 7. Imprimir un String en la caja de texto
 *
 * @author Diego Najera
 * @return String texto desencriptado
 */
public class OpDesencriptado {

    public static ArrayList array_ascii = new ArrayList<>();
    public static ArrayList array_binarios = new ArrayList<>();
    public static ArrayList array_and = new ArrayList<>();
    public static ArrayList tablaConRecorrido = new ArrayList<>();
    public static ArrayList asciiFinal = new ArrayList<>();

    public static void main(String[] args) {
        desencriptar("HOLA CRAYOLA");
        limpiar();
    }

    public static String desencriptar(String mensaje) {
        int caracter_ascii = 0;
        String caracter_binario = "";

        char[] array = mensaje.toCharArray();
        for (int i = 0; i < array.length; i++) {

            caracter_ascii = obtenerASCII(array[i]);
            array_ascii.add(caracter_ascii);

            caracter_binario = conversionBinario(caracter_ascii);
            caracter_binario = completarBinarios(caracter_binario);
            array_binarios.add(caracter_binario);

            desplazarDerecha();

        }

        return mensaje;
    }

    public static int obtenerASCII(char caracter) {
        int ascii = 0;
        for (int i = 0; i < Diccionario.alpha.length; i++) {
            if (Diccionario.alpha[i][1].equals(String.valueOf(caracter))) {
                ascii = Integer.valueOf(Integer.parseInt(Diccionario.alpha[i][0]));
            }
        }
        return ascii;
    }

    public static String conversionBinario(int caracter_ascii) {
        String binario = null;
        binario = Integer.toBinaryString(caracter_ascii);
        return binario;
    }

    public static String completarBinarios(String binario) {
        String binario_completo = null;
        int faltantes = 0;

        if (binario.length() < 8) {
            faltantes = 8 - binario.length();
            for (int i = 0; i < faltantes; i++) {
                binario_completo += "0";
            }

        }
        binario_completo += binario;

        return binario_completo;
    }

    public static String desplazarDerecha() {
        String binario = "";
        for (int i = 0; i < array_binarios.size(); i++) {
            binario += array_binarios.get(i);
        }
        System.out.println(binario.length());
        return binario;
    }

    public static void limpiar() {
        array_ascii.clear();
        array_binarios.clear();
        array_and.clear();
        tablaConRecorrido.clear();
        asciiFinal.clear();
    }

}
