public class Sala {
    // Se crea un identificador a la sala
    private int id;
    //Se declara una variable llamada pelicula de tipo Pelicula
    private Pelicula pelicula;
    // Se declara una matriz de tipo Butaca que representa la disposicion de cada butaca
    private Butaca[][] butacas;

    // Se declara un constructor para inicializar Sala con datos
    // No se crea un constructor vacio ya que se necesita informacion especifica
    //para crear una sala
    public Sala(int id, Pelicula pelicula, Butaca[][] butacas) {
        this.id = id;
        this.pelicula = pelicula;
        this.butacas = butacas;
    }

    // Se genera los getter para obtener informacion de los atributos
    public int getId() {
        return id;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public Butaca[][] getButacas() {
        return butacas;
    }

    // Se crean los metodos para tareas especificas:

    // Metodo sirver para ubicar a la butaca por coordenadas
    // Este metodo esta dentro de los limites matriz butaca
    public Butaca getButaca(int fila, int columna) {
        // se pone - 1 porque los indices empiezan desde 0
        return butacas[fila - 1][columna -1];

    }

    // Metodo para verificar si una Butaca especifica esta libre
    public boolean isButacaLibre(int fila, int columna) {
        // Utiliza el metodo getButaca para obetener referencia de la butaca exacta
        Butaca butaca = getButaca(fila,columna);
        //verifica si la butaca no es nulla y si no esta ocupada
        // return butaca != null -- verifica si la variable butaca es nulo
        // es && (AND) Porque si no cumple no continua con la siguiente expresion
        //!butaca.isOcupada() estoy verifica si la butaca no es ta ocupada
        return butaca != null && !butaca.isOcupada();
    }

    // Metodo para reservar una Butaca
    public boolean reservarButaca(int fila, int columna, String emailComprador) {
        Butaca butaca = getButaca(fila, columna);
        if (butaca != null && !butaca.isOcupada()) {
            butaca.ocupar(emailComprador);
            return true; //Reserva exitosa
        }

        return false; // La butaca no esta disponible para reserva
    }

    public void desocuparButaca(int fila, int columna) {
        Butaca butaca = getButaca(fila, columna);
        if (butaca != null && butaca.isOcupada()) {
            butaca.desocupar();
        }
    }

    // Metodo para mostrar la matriz de asientos
    public void mostrarAsientos() {
        System.out.println("Estado de los asientos: ");

        for(int i=0; i < butacas.length;i++) {
            for(int j = 0; j < butacas[0].length;j++) {
                if(butacas[i][j].isOcupada()) {
                    System.out.print("[x]");// Asiento Ocupado
                }else {
                    System.out.print("[ ]");//Asiento disponible
                }
            }
            System.out.println();
        }
    }

}