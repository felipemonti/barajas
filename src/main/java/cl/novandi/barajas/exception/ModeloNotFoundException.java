package cl.novandi.barajas.exception;


//@ResponseStatus(HttpStatus.NOT_FOUND)
public class ModeloNotFoundException extends RuntimeException {


	private static final long serialVersionUID = -4976494771704243284L;

	public ModeloNotFoundException(String mensaje) {
		super(mensaje);
	}
}
