import java.util.Scanner;

/**
 * Clase principal que contiene el método main para ejecutar el programa del cine.
 */
public class Main {

    /**
     * Método principal para ejecutar el programa del cine.
     *
     * @param args Argumentos de la línea de comandos (no se utilizan en este caso).
     */
    public static void main(String[] args) {

        // Creación de objetos Pelicula
        Pelicula pelicula1 = new Pelicula("Titanic", 180, 10.0, "18:00");
        Pelicula pelicula2 = new Pelicula("Matrix", 150, 12.0, "20:30");

        // Creación de matrices de Butacas para dos salas
        Butaca[][] butacasSala1 = new Butaca[5][10];
        Butaca[][] butacasSala2 = new Butaca[5][10];

        // Inicialización de las butacas en cada sala
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 10; j++) {
                butacasSala1[i][j] = new Butaca();
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 10; j++) {
                butacasSala2[i][j] = new Butaca();
            }
        }

        // Creación de objetos Sala
        Sala sala1 = new Sala(1, pelicula1, butacasSala1);
        Sala sala2 = new Sala(2, pelicula2, butacasSala2);

        // Creación de un array de salas
        Sala[] salas = {sala1, sala2};

        // Creación del objeto Cine
        Cine cine = new Cine("Cine Planet", 50, salas, 50, 0.0);

        // Realizar operaciones en el cine
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("\n=== Menú Principal ===");
            System.out.println("1. Visualizar información del cine");
            System.out.println("2. Realizar compra de entradas");
            System.out.println("3. Consultar disponibilidad");
            System.out.println("4. Salir");
            System.out.print("Ingrese la opción deseada: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    cine.visualizarInformacion();
                    break;
                case 2:
                    cine.realizarCompra();
                    break;
                case 3:
                    cine.consultarDisponibilidad();
                    break;
                case 4:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
                    break;
            }
        } while (opcion != 4);
    }
}