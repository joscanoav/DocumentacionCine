/**
 * La clase Pelicula representa una película en un cine,
 * con información sobre su título, duración, precio de entrada y horario de proyección.
 */
public class Pelicula {

    private String titulo; // Título de la película
    private int duracion; // Duración de la película en minutos
    private double precioEntrada; // Precio de entrada para ver la película
    private String horario; // Horario de proyección de la película

    /**
     * Constructor de la clase Pelicula.
     * Se utiliza para crear una nueva instancia de Pelicula con la información proporcionada.
     * @param titulo El título de la película.
     * @param duracion La duración de la película en minutos.
     * @param precioEntrada El precio de entrada para ver la película.
     * @param horario El horario de proyección de la película.
     */
    public Pelicula(String titulo, int duracion, double precioEntrada, String horario) {
        this.titulo = titulo;
        this.duracion = duracion;
        this.precioEntrada = precioEntrada;
        this.horario = horario;
    }

    /**
     * Obtiene el título de la película.
     * @return El título de la película.
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Obtiene la duración de la película en minutos.
     * @return La duración de la película en minutos.
     */
    public int getDuracion() {
        return duracion;
    }

    /**
     * Obtiene el precio de entrada para ver la película.
     * @return El precio de entrada para ver la película.
     */
    public double getPrecioEntrada() {
        return precioEntrada;
    }

    /**
     * Obtiene el horario de proyección de la película.
     * @return El horario de proyección de la película.
     */
    public String getHorario() {
        return horario;
    }
}