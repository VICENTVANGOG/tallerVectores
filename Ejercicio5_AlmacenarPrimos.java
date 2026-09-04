import java.util.Scanner;

public class Ejercicio5_AlmacenarPrimos {

    public static void main(String[] args) {

        // Creo un objeto Scanner para poder ingresar números por teclado.
        Scanner teclado = new Scanner(System.in);

        // Defino la cantidad de números primos que necesito almacenar.
        final int CANTIDAD_PRIMOS_REQUERIDOS = 15;

        // Creo un vector donde voy a guardar los 15 números primos.
        int[] vectorPrimos = new int[CANTIDAD_PRIMOS_REQUERIDOS];

        // Creo una variable para llevar la cuenta de cuántos números primos
        // válidos tengo almacenados.
        int cantidadAlmacenada = 0;

        // Repito el proceso mientras todavía no tenga almacenados
        // los 15 números primos que necesito.
        while (cantidadAlmacenada < CANTIDAD_PRIMOS_REQUERIDOS) {

            // Le pido al usuario que ingrese un número.
            System.out.print("Ingrese un numero: ");
            int numeroIngresado = teclado.nextInt();

            // Compruebo si el número ingresado es primo.
            if (!esPrimo(numeroIngresado)) {

                // Si no es primo, muestro un mensaje y lo descarto.
                System.out.println("No es primo, descartado.");

                // Vuelvo al inicio del ciclo para pedir otro número.
                continue;
            }

            // Compruebo si el número primo ya se encuentra almacenado
            // en mi vector.
            if (estaRepetido(vectorPrimos, cantidadAlmacenada, numeroIngresado)) {

                // Si el número ya existe, lo descarto para no repetirlo.
                System.out.println("Numero primo repetido, descartado.");

                // Vuelvo al inicio del ciclo para pedir otro número.
                continue;
            }

            // Si el número es primo y no está repetido,
            // lo guardo en la siguiente posición disponible.
            vectorPrimos[cantidadAlmacenada] = numeroIngresado;

            // Aumento la cantidad de números primos que tengo almacenados.
            cantidadAlmacenada++;
        }

        // Muestro en pantalla el título de mi vector de números primos.
        System.out.println("\nVector de numeros primos:");

        // Recorro todos los elementos de mi vector.
        for (int primo : vectorPrimos) {

            // Muestro cada número primo almacenado.
            System.out.print(primo + " ");
        }

        // Hago un salto de línea al terminar de mostrar el vector.
        System.out.println();
    }


    // Creo este método para comprobar si un número es primo.
    static boolean esPrimo(int numero) {

        // Si el número es menor que 2, no puede ser primo.
        if (numero < 2) {
            return false;
        }

        // Pruebo posibles divisores desde el número 2.
        // Solo necesito comprobar hasta la raíz cuadrada del número.
        for (int divisor = 2; divisor * divisor <= numero; divisor++) {

            // Compruebo si la división es exacta.
            if (numero % divisor == 0) {

                // Si encuentro un divisor exacto, significa que
                // el número no es primo.
                return false;
            }
        }

        // Si no encontré ningún divisor, determino que el número es primo.
        return true;
    }


    // Creo este método para comprobar si un número ya está repetido
    // dentro de mi vector.
    static boolean estaRepetido(int[] vector, int cantidadValida, int numero) {

        // Recorro únicamente las posiciones que ya tienen números válidos.
        for (int i = 0; i < cantidadValida; i++) {

            // Comparo el número ingresado con cada número almacenado.
            if (vector[i] == numero) {

                // Si encuentro el mismo número, indico que está repetido.
                return true;
            }
        }

        // Si termino el recorrido y no encontré el número,
        // indico que no está repetido.
        return false;
    }
}
