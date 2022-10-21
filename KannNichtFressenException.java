package Exceptions;

/**
 * @author oliver.keune, christian.supp, laurin.schubert
 */
public class KannNichtFressenException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public KannNichtFressenException() {
		super();
	}

	public KannNichtFressenException(String msg) {
		super(msg);
	}
}
