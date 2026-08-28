import java.util.Scanner;

public class Ejercicio4_ComprobarMitades {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.print("Ingrese la cantidad de elementos del vector (debe ser par): ");
        int cantidadElementos = teclado.nextInt();

        while (cantidadElementos % 2 != 0) {
            System.out.print("La cantidad debe ser par. Ingrese nuevamente: ");
            cantidadElementos = teclado.nextInt();
        }

        int[] vectorNumeros = new int[cantidadElementos];
        for (int i = 0; i < cantidadElementos; i++) {
            System.out.print("Ingrese elemento #" + (i + 1) + ": ");
            vectorNumeros[i] = teclado.nextInt();
        }

        int mitad = cantidadElementos / 2;
        boolean mitadesIguales = true;

        for (int i = 0; i < mitad; i++) {
            if (vectorNumeros[i] != vectorNumeros[mitad + i]) {
                mitadesIguales = false;
                break;
            }
        }

        if (mitadesIguales) {
            System.out.println("La primera mitad es igual a la segunda mitad.");
        } else {
            System.out.println("La primera mitad NO es igual a la segunda mitad.");
        }
    }
}
