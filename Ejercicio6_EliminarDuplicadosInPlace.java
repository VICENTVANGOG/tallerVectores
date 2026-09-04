import java.util.Scanner;

public class Ejercicio6_EliminarDuplicadosInPlace {

    public static void main(String[] args) {

        // Creo un objeto Scanner para poder ingresar los datos por teclado.
        Scanner teclado = new Scanner(System.in);

        // Le pido al usuario la cantidad de elementos que tendrá mi vector.
        System.out.print("Ingrese la cantidad de elementos del vector ordenado: ");
        int cantidadElementos = teclado.nextInt();

        // Creo mi vector con la cantidad de elementos indicada por el usuario.
        int[] vectorOrdenado = new int[cantidadElementos];

        // Recorro el vector para pedir cada uno de sus elementos.
        for (int i = 0; i < cantidadElementos; i++) {

            // Le pido al usuario que ingrese cada elemento.
            System.out.print("Ingrese elemento #" + (i + 1) + ": ");

            // Guardo el elemento ingresado en mi vector.
            vectorOrdenado[i] = teclado.nextInt();
        }

        // Llamo al método que elimina los elementos repetidos
        // y guardo el nuevo tamaño lógico del vector.
        int nuevoTamanioLogico = eliminarDuplicados(vectorOrdenado, cantidadElementos);

        // Muestro la cantidad de elementos únicos que quedaron.
        System.out.println("Nuevo tamano logico: " + nuevoTamanioLogico);

        // Muestro el vector modificado, pero solamente hasta
        // el nuevo tamaño lógico.
        System.out.print("Vector modificado (elementos unicos al inicio): ");

        // Recorro únicamente la parte del vector que contiene
        // los elementos sin repetir.
        for (int i = 0; i < nuevoTamanioLogico; i++) {

            // Muestro cada elemento único.
            System.out.print(vectorOrdenado[i] + " ");
        }

        // Hago un salto de línea.
        System.out.println();
    }


    // Creo este método para eliminar los elementos duplicados
    // directamente sobre el mismo vector.
    static int eliminarDuplicados(int[] vector, int cantidadElementos) {

        // Si mi vector no tiene elementos, no tengo nada que eliminar.
        if (cantidadElementos == 0) {

            // Devuelvo 0 porque el nuevo tamaño lógico es cero.
            return 0;
        }

        // Creo una posición que me indica dónde está
        // el último elemento único que encontré.
        int posicionUltimoUnico = 0;

        // Recorro el vector desde la segunda posición,
        // porque el primer elemento siempre lo considero único inicialmente.
        for (int posicionActual = 1;
             posicionActual < cantidadElementos;
             posicionActual++) {

            // Comparo el elemento actual con el último elemento único.
            if (vector[posicionActual] != vector[posicionUltimoUnico]) {

                // Si son diferentes, avanzo la posición
                // donde voy a guardar el siguiente elemento único.
                posicionUltimoUnico++;

                // Copio el elemento actual en la nueva posición.
                vector[posicionUltimoUnico] = vector[posicionActual];
            }
        }

        // Devuelvo la cantidad total de elementos únicos.
        // Le sumo 1 porque las posiciones empiezan desde 0.
        return posicionUltimoUnico + 1;
    }
}
