/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metodos;

import java.util.ArrayList;

/**
 * Pasos para el desencriptado 1. Obtener cadena desde la GUI. 2. Localizar cada
 * caracter en el diccionario y obtener su valor en ascii. 3. Convertir el valor
 * de ascii en binario y completar binario a 8 bits 4. Aplicar desplazamiento a
 * la derecha 2 bits X: Aplicar NAND 5. Convertir binario en ASCII 6. Localizar
 * ASCII en el diccionario y obtener el caracter 7. Imprimir un String en la
 * caja de texto
 *
 * @author Diego Najera
 * @return String texto desencriptado
 */
public class OpDesencriptado {

    public static ArrayList array_ascii = new ArrayList<>();
    public static ArrayList array_binarios = new ArrayList<>();
    public static ArrayList array_and = new ArrayList<>();
    public static ArrayList tablaConRecorrido = new ArrayList<>();
    public static ArrayList array_asciiFinal = new ArrayList<>();

    public static void main(String[] args) {
        desencriptar("♥▲↕♠♥▬▬→↕▲");
        limpiar();
    }

    public static String desencriptar(String mensaje) {
        int caracter_ascii = 0;
        String caracter_binario = "";
        String binarios = "";
        String binario_completo = "";

        char[] array = mensaje.toCharArray();
        for (int i = 0; i < array.length; i++) {

            caracter_ascii = obtenerASCII(array[i]);
            array_ascii.add(caracter_ascii);

            caracter_binario = conversionBinario(caracter_ascii);
            binario_completo = completarBinarios(caracter_binario);
            array_binarios.add(binario_completo);
            binarios += binario_completo;
        }

        binarios = desplazarDerecha(binarios);
        binarios = aplicarNAND("01100111", binarios);
        separarAASCII(binarios);
        limpiar();

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
        String binario_completo = "";
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

    public static String desplazarDerecha(String cadena_binarios) {
        String nueva_cadena = "";
        nueva_cadena += cadena_binarios.charAt(cadena_binarios.length() - 2);
        nueva_cadena += cadena_binarios.charAt(cadena_binarios.length() - 1);

        for (int i = 0; i < cadena_binarios.length() - 2; i++) {
            nueva_cadena += cadena_binarios.charAt(i);
        }

        return cadena_binarios;

    }

    public static String aplicarNAND(String g, String binarios) {
        int total_g = binarios.length() / g.length();
        String cadena_g = "";
        String cadenaNAND = "";
        for (int i = 0; i < total_g; i++) {
            cadena_g += g;
        }

        /* Aplicaicion NAND */
        for (int i = 0; i < binarios.length(); i++) {
            if ((binarios.charAt(i) == '0') && (cadena_g.charAt(i) == '0')) {
                cadenaNAND += "1";
            } else {
                cadenaNAND += "0";
            }
        }

        return cadenaNAND;
    }

    public static String separarAASCII(String cadena_binarios) {
        System.out.println(cadena_binarios);

        for (int i = 0; i < cadena_binarios.length() / 8; i++) {
            int limite = (i + 1) * 8;
            int index = limite - 8;
            String respuesta = "";
            for (int j = index; j < limite; j++) {
                respuesta += cadena_binarios.charAt(j);
            }
            System.out.println(respuesta);
        }

        return "";
    }

    public static void limpiar() {
        array_ascii.clear();
        array_binarios.clear();
        array_and.clear();
        tablaConRecorrido.clear();
        array_asciiFinal.clear();
    }

}
