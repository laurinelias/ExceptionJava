package Exceptions;

/**
 * @author oliver.keune, christian.supp, laurin.schubert
 */
public class DateiLeerException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DateiLeerException() {
		super();
	}

	public DateiLeerException(String msg) {
		super(msg);
	}

}
