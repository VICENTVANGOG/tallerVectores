import java.util.Scanner;

public class Ejercicio2_InsertarOrdenado {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        final int CANTIDAD_VALORES = 10;
        int[] vectorOrdenado = new int[CANTIDAD_VALORES];
        int cantidadIngresada = 0;

        for (int i = 0; i < CANTIDAD_VALORES; i++) {
            System.out.print("Ingrese valor #" + (i + 1) + ": ");
            int valorIngresado = teclado.nextInt();

            // Insercion ordenada: se recorre desde el final buscando la posicion correcta
            int posicionInsercion = cantidadIngresada;
            while (posicionInsercion > 0 && vectorOrdenado[posicionInsercion - 1] > valorIngresado) {
                vectorOrdenado[posicionInsercion] = vectorOrdenado[posicionInsercion - 1];
                posicionInsercion--;
            }
            vectorOrdenado[posicionInsercion] = valorIngresado;
            cantidadIngresada++;

            System.out.print("Vector parcial ordenado: ");
            for (int j = 0; j < cantidadIngresada; j++) {
                System.out.print(vectorOrdenado[j] + " ");
            }
            System.out.println();
        }

        System.out.println("\nVector final ordenado:");
        for (int valor : vectorOrdenado) {
            System.out.print(valor + " ");
        }
        System.out.println();
    }
}
