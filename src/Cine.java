import java.util.Scanner;

/**
 * La clase Cine representa un cine con salas, películas y operaciones relacionadas.
 */
public class Cine {
    private String nombre; // Nombre del cine
    private int aforo; // Aforo total del cine
    private Sala[] salas; // Arreglo de salas en el cine
    private int butacasLibres; // Número total de butacas libres en todas las salas
    private double totalIngresos; // Ingresos totales acumulados por ventas de boletas

    /**
     * Constructor de la clase Cine.
     *
     * @param nombre        Nombre del cine.
     * @param aforo         Aforo total del cine.
     * @param salas         Arreglo de salas en el cine.
     * @param butacasLibres Número total de butacas libres en todas las salas.
     * @param totalIngresos Ingresos totales acumulados por ventas de boletas.
     */
    public Cine(String nombre, int aforo, Sala[] salas, int butacasLibres, double totalIngresos) {
        this.nombre = nombre;
        this.aforo = aforo;
        this.salas = salas;
        this.butacasLibres = butacasLibres;
        this.totalIngresos = totalIngresos;
    }

    /**
     * Visualiza la información del cine, incluyendo detalles de cada sala y película.
     */
    public void visualizarInformacion() {
        System.out.println("Nombre del cine: " + nombre);
        System.out.println("Aforo total " + aforo);
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
     * Realiza la compra de boletas, permitiendo al usuario elegir asientos en una sala específica.
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
                    System.out.println("Reserva exitosa para: " + emailComprador + ". ¡Disfrute de la película!");
                } else {
                    System.out.println("La butaca no está disponible para reserva. Inténtelo de nuevo.");
                }
                break;
            case 3:
                consultarDisponibilidad();
                // Lógica para ver la matriz con asientos libres/ocupados de una sala concreta
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
     * Consulta la disponibilidad de asientos en una sala específica.
     */
    public void consultarDisponibilidad() {
        Scanner scanner = new Scanner(System.in);
        visualizarInformacion();
        // seleccionar sala
        System.out.println("Ingrese el numero de la sala");
        int salaId = scanner.nextInt();

        Sala salaSeleccionada = getSalaById(salaId);

        if (salaSeleccionada == null) {
            System.out.println("Sala no encontrada. Consulta cancelada");
            return;
        }

        // Mostrar matriz de asientos solo si la sala no es nula
        salaSeleccionada.mostrarAsientos();
    }

    /**
     * Obtiene una sala por su ID.
     *
     * @param id ID de la sala a buscar.
     * @return Sala con el ID proporcionado, o null si no se encuentra.
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
     * Obtiene la cantidad de butacas libres en todas las salas.
     *
     * @return Número total de butacas libres.
     */
    public int getButacasLibres() {
        return butacasLibres;
    }

    /**
     * Reserva una cantidad específica de butacas, actualizando el contador de butacas libres.
     *
     * @param cantidad Cantidad de butacas a reservar.
     */
    private void reservarButaca(int cantidad) {
        butacasLibres -= cantidad;
    }

    /**
     * Desocupa una cantidad específica de butacas, actualizando el contador de butacas libres.
     *
     * @param cantidad Cantidad de butacas a desocupar.
     */
    private void desocuparButaca(int cantidad) {
        butacasLibres += cantidad;
    }

    /**
     * Obtiene el total de ingresos acumulados por ventas de boletas.
     *
     * @return Total de ingresos acumulados.
     */
    public double getTotalIngresos() {
        return totalIngresos;
    }

    /**
     * Vende una boleta, actualizando el total de ingresos acumulados.
     *
     * @param precio Precio de la boleta vendida.
     */
    private void venderBoleta(double precio) {
        totalIngresos += precio;
    }
}