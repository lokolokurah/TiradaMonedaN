package TiradaMoneda;

import java.util.Scanner;

public class TiradaMonedaCX {

    public static void main(String[] args) {
//las variables a y b servirán para guardar el resultado de la tirada de dos monedas
        int tiradasA, tiradasB;
        int contadorCaras = 0, contadorCruces = 0, numTiradas;
//las variables contador1 y contador2 servirán para guardar el número de caras y cruces dobles consecutivas
        int contador1 = 0, contador2 = 0;
        int maximoCarasDoblesConsecutivas = 0, maximoCrucesDoblesConsecutivas = 0;
        boolean esCruzDoble = false, esCaraDoble = false;
        String tirada1;
        String tirada2;
        Scanner teclado = new Scanner(System.in);

        do {
            System.out.print("Introduce el número de veces que se van a lanzar las monedas (max 50): ");
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

        System.out.println("Caras: " + contadorCaras + ", Cruces: " + contadorCruces);
        System.out.println("Maximo de caras dobles consecutivas: " + maximoCarasDoblesConsecutivas);
        System.out.println("Maximo de cruces dobles consecutivas: " + maximoCrucesDoblesConsecutivas);
    }
}
