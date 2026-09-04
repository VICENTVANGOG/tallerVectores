import java.util.Scanner;

public class Ejercicio4_ComprobarMitades {
    public static void main(String[] args) {
        // Creo el Scanner para ingresar datos
        Scanner teclado = new Scanner(System.in);

        // Pido la cantidad de elementos
        System.out.print("Ingrese la cantidad de elementos del vector (debe ser par): ");
        int cantidadElementos = teclado.nextInt();

        // Verifico que la cantidad sea par
        while (cantidadElementos % 2 != 0) {
            System.out.print("La cantidad debe ser par. Ingrese nuevamente: ");
            cantidadElementos = teclado.nextInt();
        }

        // Creo el vector y lo lleno con los datos
        int[] vectorNumeros = new int[cantidadElementos];
        for (int i = 0; i < cantidadElementos; i++) {
            System.out.print("Ingrese elemento #" + (i + 1) + ": ");
            vectorNumeros[i] = teclado.nextInt();
        }

        // Calculo la mitad del vector
        int mitad = cantidadElementos / 2;
        boolean mitadesIguales = true;

        // Comparo los elementos de las dos mitades
        for (int i = 0; i < mitad; i++) {
            if (vectorNumeros[i] != vectorNumeros[mitad + i]) {
                mitadesIguales = false;
                break;
            }
        }

        // Muestro si las dos mitades son iguales
        if (mitadesIguales) {
            System.out.println("La primera mitad es igual a la segunda mitad.");
        } else {
            System.out.println("La primera mitad NO es igual a la segunda mitad.");
        }
    }
}
