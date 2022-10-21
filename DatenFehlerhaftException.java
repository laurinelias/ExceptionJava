package Exceptions;

/**
 * @author oliver.keune, christian.supp, laurin.schubert
 */
public class DatenFehlerhaftException extends FressException {

	private static final long serialVersionUID = 1L;

	public DatenFehlerhaftException() {
		super();
	}

	public DatenFehlerhaftException(String msg) {
		super(msg);
	}
}
