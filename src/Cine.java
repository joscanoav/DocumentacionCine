import java.util.Scanner;
public class Cine {
    //Se crean los atributos para la clase nombre aforo y sala
    private String nombre;
    private int aforo;
    private Sala[] salas;
    private int butacasLibres;
    private double totalIngresos;

    // Se generan los constructores con los valores para inicializar los valores
    // nombre del cine, el aforo total y un arreglo de salas como parámetros

    public Cine(String nombre, int aforo, Sala[] salas, int butacasLibres, double totalIngresos) {
        super();
        this.nombre = nombre;
        this.aforo = aforo;
        this.salas = salas;
        this.butacasLibres = aforo;
        this.totalIngresos = 0.0;
    }



    // Se registra el primer metodo void ya que no devuelve ningun
    //valor, solo es imprimir informacion
    // En este caso no es static lo que implica que
    // debe ser llamado a traves de la instancia cine
    //Si fuera estatico se llamaria directamente
    //Cine miCine = new Cine("Cine Ejemplo", 100, salas);
    //miCine.visualizarInformacion();
    // Llamada directa a un método estático
    //Cine.visualizarInformacion();
    //Como visializarInformacion necesita acceder atributos
    //Necesita que no sea estatico

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



    //Este metodo permite al usuario la disponibilidad
    //de asientos en una sala

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
                    System.out.println("Reserva exitosa para : " + emailComprador + "¡Disfrute de la película!");
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

    //Metodo para que un usuario consulte la disponibilidad de asiento

    public void consultarDisponibilidad() {
        Scanner scanner = new Scanner(System.in);
        visualizarInformacion();
        //seleccionar sala
        System.out.println("Ingrese el numero de la sala");
        int salaId = scanner.nextInt();

        Sala salaSeleccionada = getSalaById(salaId);

        if(salaSeleccionada == null) {
            System.out.println("Sala no encontrada. Consulta cancelada");
            return;
        }

        // Mostrar matriz de asientos
        salaSeleccionada.mostrarAsientos();
    }

    //Metodo para obtener una sala por su ID

    private Sala getSalaById(int id) {
        for (Sala sala : salas) {
            if(sala.getId()==id) {
                return sala;
            }
        }
        return null;
    }

    public int getButacasLibres() {
        return butacasLibres;
    }

    private void reservarButaca(int cantidad) {
        butacasLibres -= cantidad;
    }

    private void desocuparButaca(int cantidad) {
        butacasLibres += cantidad;
    }

    public double getTotalIngresos() {
        return totalIngresos;
    }

    private void venderBoleta(double precio) {
        totalIngresos += precio;
    }
}
