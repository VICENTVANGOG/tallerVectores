import java.util.Random;

public class MatrizSimetrica {

    public static void main(String[] args) {

        Random aleatorio = new Random();

        int dimension = 5;
        int[][] matriz = new int[dimension][dimension];

        // Llenar la matriz con números aleatorios
        for (int fila = 0; fila < dimension; fila++) {
            for (int columna = 0; columna < dimension; columna++) {
                matriz[fila][columna] = aleatorio.nextInt(10) + 1;
            }
        }

        boolean esSimetrica = true;

        // Comprobar simetría
        for (int fila = 0; fila < dimension && esSimetrica; fila++) {
            for (int columna = fila + 1; columna < dimension; columna++) {

                if (matriz[fila][columna] != matriz[columna][fila]) {
                    esSimetrica = false;
                    break;
                }
            }
        }

        System.out.println("Matriz:");

        for (int fila = 0; fila < dimension; fila++) {
            for (int columna = 0; columna < dimension; columna++) {
                System.out.print(matriz[fila][columna] + "\t");
            }
            System.out.println();
        }

        if (esSimetrica) {
            System.out.println("La matriz es simétrica.");
        } else {
            System.out.println("La matriz no es simétrica.");
        }
    }
}
