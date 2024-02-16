import java.util.Scanner;

/**
 * La clase Cine representa un cine con información sobre su nombre, aforo, salas, butacas libres y total de ingresos.
 */
public class Cine {

    private String nombre; // Nombre del cine
    private int aforo; // Aforo total del cine
    private Sala[] salas; // Arreglo de salas en el cine
    private int butacasLibres; // Cantidad de butacas libres en todas las salas
    private double totalIngresos; // Total de ingresos del cine

    /**
     * Constructor de la clase Cine.
     * @param nombre Nombre del cine.
     * @param aforo Aforo total del cine.
     * @param salas Arreglo de salas en el cine.
     * @param butacasLibres Cantidad de butacas libres inicial.
     * @param totalIngresos Total de ingresos inicial.
     */
    public Cine(String nombre, int aforo, Sala[] salas, int butacasLibres, double totalIngresos) {
        this.nombre = nombre;
        this.aforo = aforo;
        this.salas = salas;
        this.butacasLibres = butacasLibres;
        this.totalIngresos = totalIngresos;
    }

    /**
     * Visualiza la información del cine, incluyendo las películas en proyección en cada sala.
     */
    public void visualizarInformacion() {
        System.out.println("Nombre del cine: " + nombre);
        System.out.println("Aforo total: " + aforo);
        System.out.println("Butacas disponibles: " + butacasLibres);

        for (Sala sala : salas) {
            System.out.println("Sala " + sala.getId() + ":");
            System.out.println("Pelicula: " + sala.getPelicula().getTitulo());
            System.out.println("Duracion: " + sala.getPelicula().getDuracion() + " minutos");
            System.out.println("Precio de entrada: $" + sala.getPelicula().getPrecioEntrada());
            System.out.println("Horario: " + sala.getPelicula().getHorario());
        }
    }

    /**
     * Permite al usuario realizar la compra de boletas para una película en una sala específica.
     */
    public void realizarCompra() {
        Scanner scanner = new Scanner(System.in);
        visualizarInformacion();
        System.out.println("\n=== Realizar Compra ===");
        System.out.println("1. Ver salas y datos de películas");
        System.out.println("2. Elegir sala y butaca para reservar");
        System.out.println("3. Ver la matriz con asientos libres/ocupados de una sala concreta");
        System.out.println("4. Salir");
        System.out.print("Ingrese la opción deseada: ");
        int opcion = scanner.nextInt();

        switch (opcion) {
            case 1:
                visualizarInformacion();
                break;
            case 2:
                realizarReserva();
                break;
            case 3:
                consultarDisponibilidad();
                break;
            case 4:
                System.out.println("Compra cancelada. ¡Hasta luego!");
                return;
            default:
                System.out.println("Opción no válida. Inténtelo de nuevo.");
                break;
        }
    }

    /**
     * Permite al usuario reservar una butaca para una película en una sala específica.
     */
    private void realizarReserva() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el número de la sala:");
        int salaId = scanner.nextInt();

        Sala salaSeleccionada = getSalaById(salaId);

        if (salaSeleccionada == null) {
            System.out.println("Sala no encontrada. Reserva cancelada.");
            return;
        }

        salaSeleccionada.mostrarAsientos();

        System.out.println("Ingrese la fila de la butaca:");
        int fila = scanner.nextInt();

        System.out.println("Ingrese la columna de la butaca:");
        int columna = scanner.nextInt();

        System.out.println("Ingrese su correo electrónico:");
        String emailComprador = scanner.next();

        // Verificar disponibilidad y realizar reserva
        if (salaSeleccionada.reservarButaca(fila, columna, emailComprador)) {
            System.out.println("Reserva exitosa para : " + emailComprador + "¡Disfrute de la película!");
            actualizarIngresos(salaSeleccionada.getPelicula().getPrecioEntrada());
        } else {
            System.out.println("La butaca no está disponible para reserva. Inténtelo de nuevo.");
        }
    }

    /**
     * Consulta la disponibilidad de asientos en una sala específica.
     */
    private void consultarDisponibilidad() {
        Scanner scanner = new Scanner(System.in);
        visualizarInformacion();
        System.out.println("Ingrese el numero de la sala");
        int salaId = scanner.nextInt();

        Sala salaSeleccionada = getSalaById(salaId);

        if (salaSeleccionada == null) {
            System.out.println("Sala no encontrada. Consulta cancelada");
            return;
        }

        salaSeleccionada.mostrarAsientos();
    }

    /**
     * Obtiene una sala específica por su ID.
     * @param id Identificador único de la sala.
     * @return La sala con el ID especificado, o null si no se encuentra.
     */
    private Sala getSalaById(int id) {
        for (Sala sala : salas) {
            if (sala.getId() == id) {
                return sala;
            }
        }
        return null;
    }

    /**
     * Actualiza la cantidad de butacas libres y registra los ingresos por una venta.
     * @param precio Precio de la entrada vendida.
     */
    private void actualizarIngresos(double precio) {
        butacasLibres--;
        totalIngresos += precio;
    }

    /**
     * Obtiene la cantidad de butacas libres en todas las salas.
     * @return La cantidad de butacas libres.
     */
    public int getButacasLibres() {
        return butacasLibres;
    }

    /**
     * Obtiene el total de ingresos del cine.
     * @return El total de ingresos.
     */
    public double getTotalIngresos() {
        return totalIngresos;
    }
}
