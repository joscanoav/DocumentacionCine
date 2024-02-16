public class Pelicula {

    private String titulo;
    private int duracion;
    private double precioEntrada;
    private String horario;



    public Pelicula(String titulo, int duracion, double precioEntrada, String horario) {
        this.titulo = titulo;
        this.duracion = duracion;
        this.precioEntrada = precioEntrada;
        this.horario = horario;
    }

    //Se utiliza get para acceder a valores privados de una clase
    // Es un medio controlado y seguro para acceder a atributos desde fuera de clase
    // practica comun es usar encapsulamiento
    // Flexibilidad: Si más adelante necesitas realizar alguna lógica adicional (como validaciones, cálculos, etc.) al acceder o modificar un atributo, puedes hacerlo en los métodos getters y setters sin afectar a las partes del código que ya lo utilizan.
    // No se usa setter porque no seria necesario
    // En caso lo usariamos si tuvieramos cambiar valoresa los atributos
    // , los setters son métodos que se utilizan para modificar o actualizar los valores de los atributos de un objeto
    /*
     *  public void setTitulo(String nuevoTitulo) {
        this.titulo = nuevoTitulo;
        }
     *
     *  */
    public String getTitulo() {
        return titulo;
    }

    public int getDuracion() {
        return duracion;
    }

    public double getPrecioEntrada() {
        return precioEntrada;
    }

    public String getHorario() {
        return horario;
    }

}