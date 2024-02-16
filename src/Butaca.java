/**
 * La clase Butaca representa un asiento en un lugar específico, con la capacidad de estar ocupada o desocupada.
 */
public class Butaca {

    private boolean ocupada; // Indica si la butaca está ocupada o no
    private String emailComprador; // Almacena el correo electrónico del comprador cuando la butaca está ocupada

    /**
     * Constructor de la clase Butaca.
     * Se llama al crear una nueva Butaca, proporcionando una forma predeterminada de inicializarla como desocupada.
     */
    public Butaca() {
        // Al principio, la butaca está desocupada
        this.ocupada = false;
        this.emailComprador = null;
    }

    /**
     * Verifica si la butaca está ocupada.
     * @return true si la butaca está ocupada, false si está desocupada.
     */
    public boolean isOcupada() {
        return ocupada;
    }

    /**
     * Obtiene el correo electrónico del comprador de la butaca.
     * @return El correo electrónico del comprador, o null si la butaca está desocupada.
     */
    public String getEmailComprador() {
        return emailComprador;
    }

    /**
     * Ocupa la butaca asignándole un comprador y marcándola como ocupada.
     * @param emailComprador El correo electrónico del comprador que ocupa la butaca.
     */
    public void ocupar(String emailComprador) {
        this.ocupada = true; // Marcar la butaca como ocupada
        this.emailComprador = emailComprador;
    }

    /**
     * Desocupa la butaca, marcándola como desocupada y eliminando el correo electrónico del comprador.
     */
    public void desocupar() {
        this.ocupada = false; // Marcar la butaca como desocupada
        this.emailComprador = null; // Eliminar el correo electrónico del comprador
    }
}

