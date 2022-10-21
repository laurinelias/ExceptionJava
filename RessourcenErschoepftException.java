package Exceptions;

/**
 * @author oliver.keune, christian.supp, laurin.schubert
 */
public class RessourcenErschoepftException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public RessourcenErschoepftException() {
		super();
	}

	public RessourcenErschoepftException(String msg) {
		super(msg);
	}
}
