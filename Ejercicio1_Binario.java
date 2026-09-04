import java.util.Scanner;

public class Ejercicio1_Binario {
    public static void main(String[] args) {
        
        // Creo el Scanner para ingresar datos
        Scanner teclado = new Scanner(System.in);
        int valorDecimal;

        // Valido que el número esté entre 0 y 255
        do {
            System.out.print("Ingrese un valor entre 0 y 255: ");
            valorDecimal = teclado.nextInt();
        } while (valorDecimal < 0 || valorDecimal > 255);

        // Creo el vector para guardar los 8 bits
        int[] vectorBinario = new int[8];

        int numeroTemporal = valorDecimal;

        // Convierto el número decimal a binario
        for (int posicion = 7; posicion >= 0; posicion--) {
            vectorBinario[posicion] = numeroTemporal % 2;
            numeroTemporal = numeroTemporal / 2;
        }

        // Muestro el resultado
        System.out.print("El binario de " + valorDecimal + " es: ");
        for (int bit : vectorBinario) {
            System.out.print(bit);
        }

        System.out.println();
    }
}

