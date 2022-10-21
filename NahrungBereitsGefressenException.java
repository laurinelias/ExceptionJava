package Exceptions;

/**
 * @author oliver.keune, christian.supp, laurin.schubert
 */
public class NahrungBereitsGefressenException extends FressException {

	private static final long serialVersionUID = 1L;

	public NahrungBereitsGefressenException() {
		super();
	}

	public NahrungBereitsGefressenException(String msg) {
		super(msg);
	}
}
