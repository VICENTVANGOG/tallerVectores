import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Ejercicio7_ParesQueSumanK {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.print("Ingrese la cantidad de elementos del vector: ");
        int cantidadElementos = teclado.nextInt();

        int[] vectorNumeros = new int[cantidadElementos];
        for (int i = 0; i < cantidadElementos; i++) {
            System.out.print("Ingrese elemento #" + (i + 1) + ": ");
            vectorNumeros[i] = teclado.nextInt();
        }

        System.out.print("Ingrese el valor K: ");
        int valorK = teclado.nextInt();

        imprimirParesQueSumanK(vectorNumeros, valorK);
    }

    // Recorrido unico O(n) usando un conjunto de valores ya vistos como complemento
    static void imprimirParesQueSumanK(int[] vector, int valorK) {
        Set<Integer> valoresVistos = new HashSet<>();
        Set<String> paresYaImpresos = new HashSet<>();
        boolean seEncontroAlgunPar = false;

        for (int numeroActual : vector) {
            int complemento = valorK - numeroActual;

            if (valoresVistos.contains(complemento)) {
                int menor = Math.min(numeroActual, complemento);
                int mayor = Math.max(numeroActual, complemento);
                String claveDelPar = menor + "," + mayor;

                if (!paresYaImpresos.contains(claveDelPar)) {
                    System.out.println("(" + menor + ", " + mayor + ")");
                    paresYaImpresos.add(claveDelPar);
                    seEncontroAlgunPar = true;
                }
            }
            valoresVistos.add(numeroActual);
        }

        if (!seEncontroAlgunPar) {
            System.out.println("No existen parejas que sumen " + valorK);
        }
    }
}
