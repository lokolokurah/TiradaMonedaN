/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiradamoneda;

import java.util.Scanner;

/**
 *
 * @author Jaime
 */
public class extraer {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        //las variables a y b servirán para guardar el resultado de la tirada de dos monedas
        int tiradasA;
        int tiradasB;
        int contadorCaras = 0;
        int contadorCruces = 0;
        int numTiradas;
        //las variables contador1 y contador2 servirán para guardar el número de caras y cruces dobles consecutivas
        int contador1 = 0;
        int contador2 = 0;
        int maximoCarasDoblesConsecutivas = 0;
        int maximoCrucesDoblesConsecutivas = 0;
        boolean esCruzDoble = false;
        boolean esCaraDoble = false;
        String tirada1;
        String tirada2;
        Scanner teclado = new Scanner(System.in);
        do {
            System.out.print("Introduce el n\u00famero de veces que se van a lanzar las monedas (max 50): ");
            numTiradas = teclado.nextInt();
        } while (numTiradas < 1 || numTiradas > 50);
        for (int i = 0; i < numTiradas; i++) {
            tiradasA = (int) (Math.random() * 2);
            tiradasB = (int) (Math.random() * 2);
            if (tiradasA == 0) {
                contadorCaras++;
                tirada1 = "cara";
            } else {
                contadorCruces++;
                tirada1 = "cruz";
            }
            if (tiradasB == 0) {
                contadorCaras++;
                tirada2 = "cara";
            } else {
                contadorCruces++;
                tirada2 = "cruz";
            }
            System.out.println("Moneda 1: " + tirada1 + ", Moneda 2: " + tirada2);
            if (tiradasA == tiradasB) {
                if (tiradasA == 0) {
                    esCaraDoble = true;
                    esCruzDoble = false;
                } else {
                    esCaraDoble = false;
                    esCruzDoble = true;
                }
            } else {
                esCaraDoble = false;
                esCruzDoble = false;
            }
            if (esCaraDoble) {
                contador1++;
                if (contador1 > maximoCarasDoblesConsecutivas) {
                    maximoCarasDoblesConsecutivas = contador1;
                }
            } else {
                contador1 = 0;
            }
            if (esCruzDoble) {
                contador2++;
                if (contador2 > maximoCrucesDoblesConsecutivas) {
                    maximoCrucesDoblesConsecutivas = contador2;
                }
            } else {
                contador2 = 0;
            }
        }
        imprime(contadorCaras, contadorCruces, maximoCarasDoblesConsecutivas, maximoCrucesDoblesConsecutivas);
    }

    /**
     *
     * @param contadorCaras the value of contadorCaras
     * @param contadorCruces the value of contadorCruces
     * @param maximoCarasDoblesConsecutivas the value of maximoCarasDoblesConsecutivas
     * @param maximoCrucesDoblesConsecutivas the value of maximoCrucesDoblesConsecutivas
     */
    protected static void imprime(int contadorCaras, int contadorCruces, int maximoCarasDoblesConsecutivas, int maximoCrucesDoblesConsecutivas) {
        System.out.println("Caras: " + contadorCaras + ", Cruces: " + contadorCruces);
        System.out.println("Maximo de caras dobles consecutivas: " + maximoCarasDoblesConsecutivas);
        System.out.println("Maximo de cruces dobles consecutivas: " + maximoCrucesDoblesConsecutivas);
    }
    
}
