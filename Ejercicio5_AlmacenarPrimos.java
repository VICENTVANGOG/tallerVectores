import java.util.Scanner;

public class Ejercicio5_AlmacenarPrimos {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        final int CANTIDAD_PRIMOS_REQUERIDOS = 15;
        int[] vectorPrimos = new int[CANTIDAD_PRIMOS_REQUERIDOS];
        int cantidadAlmacenada = 0;

        while (cantidadAlmacenada < CANTIDAD_PRIMOS_REQUERIDOS) {
            System.out.print("Ingrese un numero: ");
            int numeroIngresado = teclado.nextInt();

            if (!esPrimo(numeroIngresado)) {
                System.out.println("No es primo, descartado.");
                continue;
            }

            if (estaRepetido(vectorPrimos, cantidadAlmacenada, numeroIngresado)) {
                System.out.println("Numero primo repetido, descartado.");
                continue;
            }

            vectorPrimos[cantidadAlmacenada] = numeroIngresado;
            cantidadAlmacenada++;
        }

        System.out.println("\nVector de numeros primos:");
        for (int primo : vectorPrimos) {
            System.out.print(primo + " ");
        }
        System.out.println();
    }

    static boolean esPrimo(int numero) {
        if (numero < 2) {
            return false;
        }
        for (int divisor = 2; divisor * divisor <= numero; divisor++) {
            if (numero % divisor == 0) {
                return false;
            }
        }
        return true;
    }

    static boolean estaRepetido(int[] vector, int cantidadValida, int numero) {
        for (int i = 0; i < cantidadValida; i++) {
            if (vector[i] == numero) {
                return true;
            }
        }
        return false;
    }
}
