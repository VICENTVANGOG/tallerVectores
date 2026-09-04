import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Ejercicio7_ParesQueSumanK {

    public static void main(String[] args) {

        // Creo un objeto Scanner para poder ingresar los datos por teclado.
        Scanner teclado = new Scanner(System.in);

        // Le pido al usuario la cantidad de elementos que tendrá mi vector.
        System.out.print("Ingrese la cantidad de elementos del vector: ");
        int cantidadElementos = teclado.nextInt();

        // Creo mi vector con la cantidad de elementos indicada.
        int[] vectorNumeros = new int[cantidadElementos];

        // Recorro el vector para pedir cada uno de sus elementos.
        for (int i = 0; i < cantidadElementos; i++) {

            // Le pido al usuario que ingrese un número.
            System.out.print("Ingrese elemento #" + (i + 1) + ": ");

            // Guardo el número ingresado en mi vector.
            vectorNumeros[i] = teclado.nextInt();
        }

        // Le pido al usuario el valor K que deben sumar las parejas.
        System.out.print("Ingrese el valor K: ");
        int valorK = teclado.nextInt();

        // Llamo al método que se encarga de buscar e imprimir
        // las parejas que suman el valor K.
        imprimirParesQueSumanK(vectorNumeros, valorK);
    }


    // Creo este método para buscar e imprimir las parejas
    // de números cuya suma sea igual a K.
    static void imprimirParesQueSumanK(int[] vector, int valorK) {

        // Creo un conjunto donde voy guardando los números
        // que ya encontré mientras recorro el vector.
        Set<Integer> valoresVistos = new HashSet<>();

        // Creo otro conjunto para guardar las parejas que ya imprimí
        // y así evitar mostrar la misma pareja más de una vez.
        Set<String> paresYaImpresos = new HashSet<>();

        // Creo una variable para saber si encontré al menos una pareja.
        boolean seEncontroAlgunPar = false;

        // Recorro todos los números de mi vector.
        for (int numeroActual : vector) {

            // Calculo qué número necesito para que, junto con
            // el número actual, la suma sea igual a K.
            int complemento = valorK - numeroActual;

            // Compruebo si ese complemento ya apareció anteriormente
            // en mi recorrido.
            if (valoresVistos.contains(complemento)) {

                // Obtengo el menor de los dos números para ordenar
                // la pareja de menor a mayor.
                int menor = Math.min(numeroActual, complemento);

                // Obtengo el mayor de los dos números.
                int mayor = Math.max(numeroActual, complemento);

                // Creo una clave para identificar la pareja.
                // Por ejemplo, si la pareja es 3 y 7, la clave será "3,7".
                String claveDelPar = menor + "," + mayor;

                // Compruebo que esta pareja todavía no haya sido impresa.
                if (!paresYaImpresos.contains(claveDelPar)) {

                    // Muestro la pareja encontrada.
                    System.out.println("(" + menor + ", " + mayor + ")");

                    // Guardo la pareja en mi conjunto de parejas impresas
                    // para no volver a mostrarla.
                    paresYaImpresos.add(claveDelPar);

                    // Indico que encontré al menos una pareja.
                    seEncontroAlgunPar = true;
                }
            }

            // Después de realizar la comprobación, guardo el número actual
            // para utilizarlo en las siguientes iteraciones.
            valoresVistos.add(numeroActual);
        }

        // Compruebo si no encontré ninguna pareja.
        if (!seEncontroAlgunPar) {

            // Muestro un mensaje indicando que no existen parejas
            // cuya suma sea igual al valor K.
            System.out.println("No existen parejas que sumen " + valorK);
        }
    }
}
