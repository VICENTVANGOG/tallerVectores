import java.util.Scanner;

public class Ejercicio1_Binario {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int valorDecimal;

        do {
            System.out.print("Ingrese un valor entre 0 y 255: ");
            valorDecimal = teclado.nextInt();
        } while (valorDecimal < 0 || valorDecimal > 255);

        int[] vectorBinario = new int[8]; // 8 bits alcanzan para representar 0-255

        int numeroTemporal = valorDecimal;
        for (int posicion = 7; posicion >= 0; posicion--) {
            vectorBinario[posicion] = numeroTemporal % 2;
            numeroTemporal = numeroTemporal / 2;
        }

        System.out.print("El binario de " + valorDecimal + " es: ");
        for (int bit : vectorBinario) {
            System.out.print(bit);
        }
        System.out.println();
    }
}
