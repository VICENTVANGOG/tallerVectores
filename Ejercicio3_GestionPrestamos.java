import java.util.Scanner;

public class Ejercicio3_GestionPrestamos {
    static final int MAXIMO_PRESTAMOS = 100;

    static int[] numerosPrestamo = new int[MAXIMO_PRESTAMOS];
    static int[] cuotasPagas = new int[MAXIMO_PRESTAMOS];
    static double[] valorCuota = new double[MAXIMO_PRESTAMOS];
    static double[] totalPagadoAnio = new double[MAXIMO_PRESTAMOS];
    static int cantidadPrestamos = 0;

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        cargarPrestamosIniciales(teclado);
        ingresarYActualizarPrestamos(teclado);
        mostrarVectores("Vectores actualizados:");

        int[] prestamosMenosDe10Cuotas = generarVectorMenosDe10Cuotas();
        mostrarVectorPrestamosFiltrado(prestamosMenosDe10Cuotas);

        ordenarPorNumeroDePrestamo();
        mostrarVectores("Vectores luego del ordenamiento:");
    }

    // Carga inicial de los n prestamos otorgados (numero, cuotas pagas, valor cuota, total pagado)
    static void cargarPrestamosIniciales(Scanner teclado) {
        System.out.print("Ingrese la cantidad de prestamos a cargar (n): ");
        int cantidadAIngresar = teclado.nextInt();

        for (int i = 0; i < cantidadAIngresar && i < MAXIMO_PRESTAMOS; i++) {
            System.out.println("\nPrestamo #" + (i + 1));
            System.out.print("Numero de prestamo: ");
            numerosPrestamo[i] = teclado.nextInt();
            System.out.print("Cantidad de cuotas pagas: ");
            cuotasPagas[i] = teclado.nextInt();
            System.out.print("Valor de la cuota: ");
            valorCuota[i] = teclado.nextDouble();
            System.out.print("Total pagado en el ano: ");
            totalPagadoAnio[i] = teclado.nextDouble();
            cantidadPrestamos++;
        }
    }

    // Busca un prestamo por numero, actualiza cuotas pagas y total pagado, hasta ingresar 0
    static void ingresarYActualizarPrestamos(Scanner teclado) {
        while (true) {
            System.out.print("\nIngrese numero de prestamo a buscar (0 para terminar): ");
            int numeroBuscado = teclado.nextInt();
            if (numeroBuscado == 0) {
                break;
            }

            int posicionEncontrada = buscarPosicionPrestamo(numeroBuscado);
            if (posicionEncontrada == -1) {
                System.out.println("Numero de prestamo no encontrado.");
                continue;
            }

            System.out.print("Ingrese cantidad de cuotas pagadas en este movimiento: ");
            int cuotasPagadasIngresadas = teclado.nextInt();

            cuotasPagas[posicionEncontrada] += cuotasPagadasIngresadas;
            totalPagadoAnio[posicionEncontrada] += cuotasPagadasIngresadas * valorCuota[posicionEncontrada];
        }
    }

    static int buscarPosicionPrestamo(int numeroBuscado) {
        for (int i = 0; i < cantidadPrestamos; i++) {
            if (numerosPrestamo[i] == numeroBuscado) {
                return i;
            }
        }
        return -1;
    }

    // Genera un nuevo vector con los numeros de prestamo que pagaron menos de 10 cuotas
    static int[] generarVectorMenosDe10Cuotas() {
        int[] vectorTemporal = new int[cantidadPrestamos];
        int contador = 0;
        for (int i = 0; i < cantidadPrestamos; i++) {
            if (cuotasPagas[i] < 10) {
                vectorTemporal[contador] = numerosPrestamo[i];
                contador++;
            }
        }
        int[] resultado = new int[contador];
        System.arraycopy(vectorTemporal, 0, resultado, 0, contador);
        return resultado;
    }

    static void mostrarVectorPrestamosFiltrado(int[] vector) {
        if (vector.length == 0) {
            System.out.println("\nNo hay prestamos con menos de 10 cuotas pagas.");
            return;
        }
        System.out.print("\nPrestamos con menos de 10 cuotas pagas: ");
        for (int numeroPrestamo : vector) {
            System.out.print(numeroPrestamo + " ");
        }
        System.out.println();
    }

    // Ordena por numero de prestamo (seleccion) arrastrando los demas vectores
    static void ordenarPorNumeroDePrestamo() {
        for (int i = 0; i < cantidadPrestamos - 1; i++) {
            int posicionMenor = i;
            for (int j = i + 1; j < cantidadPrestamos; j++) {
                if (numerosPrestamo[j] < numerosPrestamo[posicionMenor]) {
                    posicionMenor = j;
                }
            }
            if (posicionMenor != i) {
                intercambiar(numerosPrestamo, i, posicionMenor);
                intercambiar(cuotasPagas, i, posicionMenor);
                intercambiar(valorCuota, i, posicionMenor);
                intercambiar(totalPagadoAnio, i, posicionMenor);
            }
        }
    }

    static void intercambiar(int[] vector, int i, int j) {
        int temp = vector[i];
        vector[i] = vector[j];
        vector[j] = temp;
    }

    static void intercambiar(double[] vector, int i, int j) {
        double temp = vector[i];
        vector[i] = vector[j];
        vector[j] = temp;
    }

    static void mostrarVectores(String titulo) {
        System.out.println("\n" + titulo);
        for (int i = 0; i < cantidadPrestamos; i++) {
            System.out.println("Prestamo: " + numerosPrestamo[i] +
                    " | Cuotas pagas: " + cuotasPagas[i] +
                    " | Valor cuota: " + valorCuota[i] +
                    " | Total pagado ano: " + totalPagadoAnio[i]);
        }
    }
}
