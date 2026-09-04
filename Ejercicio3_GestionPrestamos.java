import java.util.Scanner;

public class Ejercicio3_GestionPrestamos {

    // Defino la cantidad máxima de préstamos que puedo almacenar.
    static final int MAXIMO_PRESTAMOS = 100;

    // Creo un vector para guardar los números de los préstamos.
    static int[] numerosPrestamo = new int[MAXIMO_PRESTAMOS];

    // Creo un vector para guardar la cantidad de cuotas pagadas de cada préstamo.
    static int[] cuotasPagas = new int[MAXIMO_PRESTAMOS];

    // Creo un vector para guardar el valor de cada cuota.
    static double[] valorCuota = new double[MAXIMO_PRESTAMOS];

    // Creo un vector para guardar el total pagado durante el año.
    static double[] totalPagadoAnio = new double[MAXIMO_PRESTAMOS];

    // Creo una variable para saber cuántos préstamos tengo cargados.
    static int cantidadPrestamos = 0;


    public static void main(String[] args) {

        // Creo mi objeto Scanner para poder ingresar datos por teclado.
        Scanner teclado = new Scanner(System.in);

        // Primero cargo los préstamos iniciales.
        cargarPrestamosIniciales(teclado);

        // Después permito buscar préstamos y actualizar sus datos.
        ingresarYActualizarPrestamos(teclado);

        // Muestro todos los vectores con la información actualizada.
        mostrarVectores("Vectores actualizados:");

        // Genero un nuevo vector con los préstamos que tienen menos
        // de 10 cuotas pagadas.
        int[] prestamosMenosDe10Cuotas = generarVectorMenosDe10Cuotas();

        // Muestro los préstamos que cumplen con esa condición.
        mostrarVectorPrestamosFiltrado(prestamosMenosDe10Cuotas);

        // Ordeno todos mis préstamos de menor a mayor según su número.
        ordenarPorNumeroDePrestamo();

        // Muestro nuevamente los vectores después de realizar el ordenamiento.
        mostrarVectores("Vectores luego del ordenamiento:");
    }


    // En este método cargo inicialmente los préstamos que tengo registrados.
    static void cargarPrestamosIniciales(Scanner teclado) {

        // Le pido al usuario la cantidad de préstamos que quiere cargar.
        System.out.print("Ingrese la cantidad de prestamos a cargar (n): ");
        int cantidadAIngresar = teclado.nextInt();

        // Recorro la cantidad de préstamos que voy a ingresar.
        // También verifico que no supere el máximo permitido.
        for (int i = 0; i < cantidadAIngresar && i < MAXIMO_PRESTAMOS; i++) {

            // Muestro el número del préstamo que estoy cargando.
            System.out.println("\nPrestamo #" + (i + 1));

            // Pido y guardo el número del préstamo.
            System.out.print("Numero de prestamo: ");
            numerosPrestamo[i] = teclado.nextInt();

            // Pido y guardo la cantidad de cuotas que ya fueron pagadas.
            System.out.print("Cantidad de cuotas pagas: ");
            cuotasPagas[i] = teclado.nextInt();

            // Pido y guardo el valor de cada cuota.
            System.out.print("Valor de la cuota: ");
            valorCuota[i] = teclado.nextDouble();

            // Pido y guardo el total que se ha pagado durante el año.
            System.out.print("Total pagado en el ano: ");
            totalPagadoAnio[i] = teclado.nextDouble();

            // Aumento la cantidad de préstamos que tengo registrados.
            cantidadPrestamos++;
        }
    }


    // En este método busco préstamos por su número y actualizo
    // la cantidad de cuotas pagadas y el total pagado.
    static void ingresarYActualizarPrestamos(Scanner teclado) {

        // Utilizo un ciclo que se mantiene activo hasta que ingreso 0.
        while (true) {

            // Le pido al usuario el número del préstamo que quiere buscar.
            System.out.print("\nIngrese numero de prestamo a buscar (0 para terminar): ");
            int numeroBuscado = teclado.nextInt();

            // Si ingreso 0, termino el proceso de búsqueda y actualización.
            if (numeroBuscado == 0) {
                break;
            }

            // Busco la posición donde se encuentra el préstamo.
            int posicionEncontrada = buscarPosicionPrestamo(numeroBuscado);

            // Si el préstamo no existe, muestro un mensaje y continúo
            // buscando otro préstamo.
            if (posicionEncontrada == -1) {
                System.out.println("Numero de prestamo no encontrado.");
                continue;
            }

            // Pido la cantidad de cuotas que se pagaron en este movimiento.
            System.out.print("Ingrese cantidad de cuotas pagadas en este movimiento: ");
            int cuotasPagadasIngresadas = teclado.nextInt();

            // Sumo las nuevas cuotas pagadas a las cuotas que ya tenía registradas.
            cuotasPagas[posicionEncontrada] += cuotasPagadasIngresadas;

            // Actualizo el total pagado multiplicando las nuevas cuotas
            // por el valor de cada cuota.
            totalPagadoAnio[posicionEncontrada] +=
                    cuotasPagadasIngresadas * valorCuota[posicionEncontrada];
        }
    }


    // En este método busco la posición de un préstamo dentro de mi vector.
    static int buscarPosicionPrestamo(int numeroBuscado) {

        // Recorro todos los préstamos que tengo registrados.
        for (int i = 0; i < cantidadPrestamos; i++) {

            // Comparo el número buscado con el número de cada préstamo.
            if (numerosPrestamo[i] == numeroBuscado) {

                // Si encuentro el préstamo, devuelvo su posición.
                return i;
            }
        }

        // Si no encuentro el préstamo, devuelvo -1.
        return -1;
    }


    // En este método genero un nuevo vector con los préstamos
    // que tienen menos de 10 cuotas pagadas.
    static int[] generarVectorMenosDe10Cuotas() {

        // Creo un vector temporal con espacio suficiente para todos
        // los préstamos que tengo registrados.
        int[] vectorTemporal = new int[cantidadPrestamos];

        // Creo un contador para saber cuántos préstamos cumplen la condición.
        int contador = 0;

        // Recorro todos mis préstamos.
        for (int i = 0; i < cantidadPrestamos; i++) {

            // Compruebo si el préstamo tiene menos de 10 cuotas pagadas.
            if (cuotasPagas[i] < 10) {

                // Si cumple la condición, guardo su número en el vector temporal.
                vectorTemporal[contador] = numerosPrestamo[i];

                // Aumento el contador.
                contador++;
            }
        }

        // Creo un nuevo vector con el tamaño exacto de los préstamos
        // que cumplen la condición.
        int[] resultado = new int[contador];

        // Copio los datos del vector temporal al vector resultado.
        System.arraycopy(vectorTemporal, 0, resultado, 0, contador);

        // Devuelvo el nuevo vector.
        return resultado;
    }


    // En este método muestro los préstamos que tienen menos de 10 cuotas pagadas.
    static void mostrarVectorPrestamosFiltrado(int[] vector) {

        // Compruebo si el vector está vacío.
        if (vector.length == 0) {

            // Si está vacío, significa que ningún préstamo cumple la condición.
            System.out.println("\nNo hay prestamos con menos de 10 cuotas pagas.");

            // Termino el método.
            return;
        }

        // Muestro el título de los préstamos encontrados.
        System.out.print("\nPrestamos con menos de 10 cuotas pagas: ");

        // Recorro el vector que contiene los préstamos filtrados.
        for (int numeroPrestamo : vector) {

            // Muestro el número de cada préstamo.
            System.out.print(numeroPrestamo + " ");
        }

        // Hago un salto de línea.
        System.out.println();
    }


    // En este método ordeno mis préstamos de menor a mayor
    // utilizando el método de selección.
    static void ordenarPorNumeroDePrestamo() {

        // Recorro las posiciones del vector para buscar el menor número.
        for (int i = 0; i < cantidadPrestamos - 1; i++) {

            // Supongo inicialmente que la posición actual contiene
            // el número de préstamo más pequeño.
            int posicionMenor = i;

            // Comparo con los elementos que están después de la posición actual.
            for (int j = i + 1; j < cantidadPrestamos; j++) {

                // Si encuentro un número de préstamo menor,
                // guardo su posición.
                if (numerosPrestamo[j] < numerosPrestamo[posicionMenor]) {
                    posicionMenor = j;
                }
            }

            // Si encontré un número menor en otra posición,
            // realizo el intercambio.
            if (posicionMenor != i) {

                // Intercambio los números de los préstamos.
                intercambiar(numerosPrestamo, i, posicionMenor);

                // Intercambio también las cuotas pagadas para que
                // cada préstamo conserve su información.
                intercambiar(cuotasPagas, i, posicionMenor);

                // Intercambio los valores de las cuotas.
                intercambiar(valorCuota, i, posicionMenor);

                // Intercambio los totales pagados durante el año.
                intercambiar(totalPagadoAnio, i, posicionMenor);
            }
        }
    }


    // Creo este método para intercambiar dos posiciones de un vector de enteros.
    static void intercambiar(int[] vector, int i, int j) {

        // Guardo temporalmente el primer valor.
        int temp = vector[i];

        // Coloco el segundo valor en la primera posición.
        vector[i] = vector[j];

        // Coloco el valor temporal en la segunda posición.
        vector[j] = temp;
    }


    // Creo este método para intercambiar dos posiciones de un vector de números decimales.
    static void intercambiar(double[] vector, int i, int j) {

        // Guardo temporalmente el primer valor.
        double temp = vector[i];

        // Coloco el segundo valor en la primera posición.
        vector[i] = vector[j];

        // Coloco el valor temporal en la segunda posición.
        vector[j] = temp;
    }


    // En este método muestro toda la información de mis préstamos.
    static void mostrarVectores(String titulo) {

        // Muestro el título que recibo como parámetro.
        System.out.println("\n" + titulo);

        // Recorro todos los préstamos que tengo registrados.
        for (int i = 0; i < cantidadPrestamos; i++) {

            // Muestro el número del préstamo, las cuotas pagadas,
            // el valor de la cuota y el total pagado durante el año.
            System.out.println("Prestamo: " + numerosPrestamo[i] +
                    " | Cuotas pagas: " + cuotasPagas[i] +
                    " | Valor cuota: " + valorCuota[i] +
                    " | Total pagado ano: " + totalPagadoAnio[i]);
        }
    }
}
