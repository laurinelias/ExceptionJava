package Exceptions;

/**
 * @author oliver.keune, christian.supp, laurin.schubert
 */
public class AkteurBereitsGefressenException extends FressException {

	private static final long serialVersionUID = 1L;

	public AkteurBereitsGefressenException() {
		super();
	}

	public AkteurBereitsGefressenException(String msg) {
		super(msg);
	}

}
