/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metodos;

/**
 *
 * @author telum
 */
public class prb {

    public static void main(String[] args) {

        Operaciones op = new Operaciones();
        String mensaje = "HOLA";
        op.encriptarContenido(mensaje);

        for (int i = 0; i < Operaciones.ascii.size(); i++) {

            System.out.print(Operaciones.ascii.get(i) + " ");
            System.out.print(Operaciones.binarios.get(i) + " ");
            System.out.print(Operaciones.aplicandoAndConG.get(i) + " ");
            System.out.print(Operaciones.tablaConRecorrido.get(i) + " ");
            System.out.print(Operaciones.asciiFinal.get(i) + "\n");

        }

    }

}
