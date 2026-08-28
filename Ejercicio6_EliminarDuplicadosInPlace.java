import java.util.Scanner;

public class Ejercicio6_EliminarDuplicadosInPlace {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.print("Ingrese la cantidad de elementos del vector ordenado: ");
        int cantidadElementos = teclado.nextInt();

        int[] vectorOrdenado = new int[cantidadElementos];
        for (int i = 0; i < cantidadElementos; i++) {
            System.out.print("Ingrese elemento #" + (i + 1) + ": ");
            vectorOrdenado[i] = teclado.nextInt();
        }

        int nuevoTamanioLogico = eliminarDuplicados(vectorOrdenado, cantidadElementos);

        System.out.println("Nuevo tamano logico: " + nuevoTamanioLogico);
        System.out.print("Vector modificado (elementos unicos al inicio): ");
        for (int i = 0; i < nuevoTamanioLogico; i++) {
            System.out.print(vectorOrdenado[i] + " ");
        }
        System.out.println();
    }

    // Tecnica de dos punteros: posicionUltimoUnico marca el final de la zona sin duplicados
    static int eliminarDuplicados(int[] vector, int cantidadElementos) {
        if (cantidadElementos == 0) {
            return 0;
        }

        int posicionUltimoUnico = 0;

        for (int posicionActual = 1; posicionActual < cantidadElementos; posicionActual++) {
            if (vector[posicionActual] != vector[posicionUltimoUnico]) {
                posicionUltimoUnico++;
                vector[posicionUltimoUnico] = vector[posicionActual];
            }
        }

        return posicionUltimoUnico + 1;
    }
}
