package Exceptions;

/**
 * @author oliver.keune, christian.supp, laurin.schubert
 */
public class BeuteZuGrossException extends FressException {

	private static final long serialVersionUID = 1L;

	public BeuteZuGrossException() {
		super();

	}

	public BeuteZuGrossException(String msg) {
		super(msg);
	}
}
