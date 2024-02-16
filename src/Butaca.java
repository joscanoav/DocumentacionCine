public class Butaca {
    private boolean ocupada;
    private String emailComprador;

    // Se genera el costructor de la clase Butaca
    // Se llama cuando se crea una nueva Butaca
    // Se genera un constructor sin parametros
    // Proporciona una forma predeterminada de inicializar una butaca sin tener que especificar su estado de ocupación
    // Butaca butaca = new Butaca(); Es util para espeficar desocuapada por defecto

    public Butaca( ) {
        //Al principio la butaca esta desocupada
        this.ocupada = false;
        this.emailComprador = null;
    }

    // Se crea el metodo para verificar si la butaca esta ocupada
    // A diferencia de una variable, los metodos realizan tareas o operaciones especificas
    //Este metodo no almacena datos, si no consulta si esta ocupada
    //Retorna un tipo booleano(True si esta ocupada o false si no lo esta)
	/*Butaca butaca = new Butaca();
	  boolean estaOcupada = butaca.isOcupada();
	  if (estaOcupada) {
      System.out.println("La butaca está ocupada.");
      } else {
      System.out.println("La butaca está desocupada.");
      }*/
    // este metodo devuelve un valor booleano
    public boolean isOcupada() {
        return ocupada;
    }

    //Metodo para obtener email del comprador
    public String getEmailComprador() {
        return emailComprador;
    }
    //Se aplica metodo void para no devolvera un valor
    // Solo para al llamarlo cumplir la accion que tienen

    public void ocupar(String emailComprador) {
        this.ocupada = true; // marcar ocupada
        this.emailComprador = emailComprador;
    }




    public void desocupar() {
        this.ocupada = false;// marcar desocupada
        this.emailComprador=null; //Eliminar el email
    }



}

