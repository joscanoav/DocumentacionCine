/**
 * La clase Sala representa una sala de cine con información sobre su identificador, película actual y disposición de butacas.
 */
public class Sala {
    // Identificador único de la sala
    private int id;
    // Película actualmente en proyección en la sala
    private Pelicula pelicula;
    // Matriz que representa la disposición de las butacas en la sala
    private Butaca[][] butacas;

    /**
     * Constructor de la clase Sala.
     * @param id Identificador único de la sala.
     * @param pelicula Película actualmente en proyección en la sala.
     * @param butacas Matriz que representa la disposición de las butacas en la sala.
     */
    public Sala(int id, Pelicula pelicula, Butaca[][] butacas) {
        this.id = id;
        this.pelicula = pelicula;
        this.butacas = butacas;
    }

    // Getters para obtener información de los atributos

    /**
     * Obtiene el identificador único de la sala.
     * @return El identificador único de la sala.
     */
    public int getId() {
        return id;
    }

    /**
     * Obtiene la película actualmente en proyección en la sala.
     * @return La película actualmente en proyección en la sala.
     */
    public Pelicula getPelicula() {
        return pelicula;
    }

    /**
     * Obtiene la matriz que representa la disposición de las butacas en la sala.
     * @return La matriz de butacas en la sala.
     */
    public Butaca[][] getButacas() {
        return butacas;
    }

    // Métodos para tareas específicas:

    /**
     * Obtiene la butaca ubicada en una posición específica de la sala.
     * @param fila Número de fila de la butaca.
     * @param columna Número de columna de la butaca.
     * @return La butaca ubicada en la posición especificada.
     */
    public Butaca getButaca(int fila, int columna) {
        return butacas[fila - 1][columna - 1]; // Se resta 1 porque los índices empiezan desde 0
    }

    /**
     * Verifica si una butaca específica está disponible.
     * @param fila Número de fila de la butaca.
     * @param columna Número de columna de la butaca.
     * @return true si la butaca está disponible, false si está ocupada o no existe.
     */
    public boolean isButacaLibre(int fila, int columna) {
        Butaca butaca = getButaca(fila, columna);
        return butaca != null && !butaca.isOcupada();
    }

    /**
     * Reserva una butaca específica para un comprador.
     * @param fila Número de fila de la butaca.
     * @param columna Número de columna de la butaca.
     * @param emailComprador Correo electrónico del comprador.
     * @return true si la reserva es exitosa, false si la butaca está ocupada o no existe.
     */
    public boolean reservarButaca(int fila, int columna, String emailComprador) {
        Butaca butaca = getButaca(fila, columna);
        if (butaca != null && !butaca.isOcupada()) {
            butaca.ocupar(emailComprador);
            return true; // Reserva exitosa
        }
        return false; // La butaca no está disponible para reserva
    }

    /**
     * Desocupa una butaca específica.
     * @param fila Número de fila de la butaca.
     * @param columna Número de columna de la butaca.
     */
    public void desocuparButaca(int fila, int columna) {
        Butaca butaca = getButaca(fila, columna);
        if (butaca != null && butaca.isOcupada()) {
            butaca.desocupar();
        }
    }

    /**
     * Muestra el estado actual de los asientos en la sala.
     */
    public void mostrarAsientos() {
        System.out.println("Estado de los asientos en la Sala " + id + ": ");

        for (int i = 0; i < butacas.length; i++) {
            for (int j = 0; j < butacas[0].length; j++) {
                if (butacas[i][j].isOcupada()) {
                    System.out.print("[x]"); // Asiento Ocupado
                } else {
                    System.out.print("[ ]"); // Asiento disponible
                }
            }
            System.out.println();
        }
    }
}