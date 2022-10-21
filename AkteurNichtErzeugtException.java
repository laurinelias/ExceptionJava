package Exceptions;

/**
 * @author oliver.keune, christian.supp, laurin.schubert
 */
public class AkteurNichtErzeugtException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public AkteurNichtErzeugtException() {
		super();
	}

	public AkteurNichtErzeugtException(String msg) {
		super(msg);
	}

}
